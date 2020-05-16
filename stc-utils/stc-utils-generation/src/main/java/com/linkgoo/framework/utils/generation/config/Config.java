package com.linkgoo.framework.utils.generation.config;

import com.linkgoo.framework.utils.generation.model.TemplateConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;



/**
 * Config class
 *
 * @description:
 *
 * @author qixiao.bi
 * @date 2020-01-07  15:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "code.generation")
public class Config {

    private String inputFilePath;
    private String inputFileCharacterCoding;
    private String outputFileCharacterCoding;
    private String company;
    private String author;
    private String tablePrefix;
    private String sqlDialect;
    private String sqlPath;
    private String basePath;
    private String basePackagePath;
    private String templateDirectory;
    private String baseClassPath;


    /**
     *
     * @Description templates for
     * entity、 repository、 repositoryExt、 repositoryXml、 repositoryExtXml、
     * controller、 service、 serviceImpl、 mysql、 sqlServer、 oracle、 h2、
     *
     * @date 2019/12/2 21:37
     */

    private Map<String, TemplateConfig> templates;

    @Bean
    public Dialect dialect() throws Exception {
        System.out.println(sqlDialect);
        Class clz = null;
        try {
            clz = Class.forName(sqlPath + "." + sqlDialect);
        } catch (Exception e) {
            throw new Exception("异常：无法加载"+sqlDialect);
        }
        Object obj = clz.newInstance();
        if (obj instanceof Dialect) {
            return (Dialect) obj;
        }else{
            throw new Exception("异常：无法加载"+sqlDialect);
        }
    }
}
