package com.linkgoo.framework.utils.generation.model;

import lombok.Data;

@Data
public class TemplateConfig {
    /**
     * 模板名字
     */
    private String templateName;
    /**
     * 模板后缀
     */
    private String templateNameSuffix;
    /**
     * 模板路径
     */
    private String templateDirectory;
    /**
     * 生成文件名后缀
     */
    private String generationNameSuffix;
    /**
     * 生成文件名
     */
    private String generationFileName;
    /**
     * 生成类名
     */
    private String generationClassName;
    /**
     * 生成文件路径
     */
    private String generationPath;
    /**
     * package name
     */
    private String generationPackage;
    /**
     * classes path
     */
    private String generationClassesPath;
    /**
     * 是否覆盖
     */
    private Boolean cover;

}
