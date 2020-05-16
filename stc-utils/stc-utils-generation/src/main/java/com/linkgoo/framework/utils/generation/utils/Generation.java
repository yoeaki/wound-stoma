package com.linkgoo.framework.utils.generation.utils;

import com.linkgoo.framework.utils.generation.builder.CodeBuilder;
import com.linkgoo.framework.utils.generation.config.Config;
import com.linkgoo.framework.utils.generation.model.Table;
import com.linkgoo.framework.utils.generation.parser.FileParser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;

@Component
public class Generation implements CommandLineRunner, ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(Generation.class);

    @Autowired
    public Config config;

    @Autowired
    public List<CodeBuilder> codeBuilderList;

    public ApplicationContext applicationContext;

    public static final String TEMPLATE_NAME_SUFFIX  = ".ftl";

    public static final String JAVA_SOURCE_PATH  = "src/main/java/";

    @Override
    public void run(String... args) throws Exception {
        //解析文件
        Table table = FileParser.parserFile(config);
        //初始化
        initBean(table);
        //获取构建器
        if (CollectionUtils.isEmpty(codeBuilderList)) {
            logger.error(" Builder not found ");
        }
        //使用构建器生成代码
        codeBuilderList.forEach( builder -> builder.builder(config, table));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void initBean(Table table) {
        config.getTemplates().forEach((k,template)->{
            if (StringUtils.isBlank(template.getTemplateNameSuffix())) {
                template.setTemplateNameSuffix(TEMPLATE_NAME_SUFFIX);
            }
            if (template.getCover()==null) {
                template.setCover(false);
            }
            if (template.getGenerationNameSuffix().endsWith(".xml")){
                template.setGenerationFileName(table.getModelNameFirstLowerCamel() + File.separator +table.getNameFirstUpperCamel()+
                        template.getGenerationNameSuffix());
                System.out.println(table.getModelNameFirstLowerCamel() + File.separator +table.getNameFirstUpperCamel()+template.getGenerationNameSuffix());
            }else {
                template.setGenerationFileName(table.getNameFirstUpperCamel() + template.getGenerationNameSuffix());
            }
            //Java类 模板
            if (template.getGenerationNameSuffix().endsWith(".java")) {

                if (StringUtils.isBlank(template.getGenerationPackage())) {
                    int i = template.getGenerationPath().indexOf(JAVA_SOURCE_PATH)+JAVA_SOURCE_PATH.length();
                    String pkg = template.getGenerationPath().substring(i).replace("/", ".") + table.getModelNameFirstLowerCamel();
                    template.setGenerationPackage(pkg.toLowerCase());
                }else {
                    String generationPackage = template.getGenerationPackage();

                    if (generationPackage.substring(generationPackage.length() - 1).equals(".")) {
                        generationPackage += table.getModelNameFirstLowerCamel();
                    }else{
                        generationPackage += "." + table.getModelNameFirstLowerCamel();
                    }
                    template.setGenerationPackage(generationPackage);
                }
                template.setGenerationPath(template.getGenerationPath()+table.getModelNameFirstLowerCamel()+"/");
                template.setGenerationClassName(template.getGenerationFileName().replace(".java",""));
                template.setGenerationClassesPath(template.getGenerationPackage()+"."+template.getGenerationClassName());
            }
        });
    }
}
