package com.linkgoo.framework.utils.generation.builder;

import com.linkgoo.framework.utils.generation.config.Config;
import com.linkgoo.framework.utils.generation.model.Table;
import com.linkgoo.framework.utils.generation.model.TemplateConfig;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@Component
@Order(1)
public class SqlBuider implements CodeBuilder {


    static final String MAGER_FINE_NAME = "schema.sql";

    @Override
    public void builder(Config config, Table table) {

        Set<String> needMager = new HashSet<>();

        for (TemplateConfig templateConfig : config.getTemplates().values()) {
            if (templateConfig.getGenerationNameSuffix().contains(".sql")) {
                needMager.add(templateConfig.getGenerationPath());
            }
        }

        //合并文件
        needMager.forEach( directory->{
            BufferedWriter bw = null;
            BufferedReader br = null;
            try {
                bw = new BufferedWriter(new FileWriter(directory+MAGER_FINE_NAME));
                File[] list = new File(directory).listFiles();
                for(File file : list)
                {
                    if(file.isFile()&&!file.getName().contains(MAGER_FINE_NAME)){
                        br = new BufferedReader(new FileReader(file));
                        String line;
                        while((line=br.readLine())!=null) {
                            bw.write(line);
                            bw.newLine();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if(br != null){
                        br.close();
                    }
                    if(bw != null){
                        bw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

    }
}
