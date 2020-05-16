package com.linkgoo.framework.utils.generation.builder;

import com.linkgoo.framework.utils.generation.model.Table;
import com.linkgoo.framework.utils.generation.config.Config;
import com.linkgoo.framework.utils.generation.model.TemplateConfig;
import com.linkgoo.framework.utils.generation.utils.FileUtil;
import freemarker.template.Template;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(0)
public class BaseBuilder implements CodeBuilder {

    static final String  TABLE = "table";
    static final String  TEMPLATES = "templates";
    static final String  TEMPLATE = "template";
    static final String  CONFIG = "config";


    @Override
    public void builder(Config config, Table table) {
        logger.info("BaseBuilder start");
        try {
            // 获取所有的模板配置。
            Map<String, TemplateConfig> templateMap = config.getTemplates();

            //遍历模板
            for (Map.Entry<String, TemplateConfig> templateItem : templateMap.entrySet()) {

                TemplateConfig templateConfig = templateItem.getValue();

                // 设置模板文件所在的路径。
                configuration.setDirectoryForTemplateLoading(new File(templateConfig.getTemplateDirectory()));
                // 设置模板文件使用的字符集。一般就是utf-8.
                configuration.setDefaultEncoding(config.getOutputFileCharacterCoding());

                Config cf = new Config();
                //拷贝bean
                BeanUtils.copyProperties(config,cf);

                //加载模板
                Template template = configuration.getTemplate(
                        templateConfig.getTemplateName()+templateConfig.getTemplateNameSuffix());
                String filePath = templateConfig.getGenerationPath()+ templateConfig.getGenerationFileName();
                if (FileUtil.fileExists(filePath)&&!templateConfig.getCover()) {
                    continue;
                }

                Map map = new HashMap<String,Object>();
                map.put(TABLE,table);
                map.put(TEMPLATES, templateMap);
                map.put(TEMPLATE, templateConfig);
                map.put(CONFIG,config);
                // 创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
                Writer out = new FileWriter(FileUtil.getFile(filePath));
                //调用模板对象的process方法输出文件,生成静态页面。
                template.process(map, out);
                // 关闭流。
                out.close();
                logger.info("Generate code ["+templateConfig.getTemplateName()+"]: "+templateConfig.getGenerationPath()
                        +table.getNameFirstLowerCamel()+ templateConfig.getGenerationNameSuffix());
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("BaseBuilder end");
    }
}
