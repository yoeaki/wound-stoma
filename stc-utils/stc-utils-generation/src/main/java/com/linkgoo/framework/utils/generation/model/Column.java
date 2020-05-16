package com.linkgoo.framework.utils.generation.model;

import lombok.Data;

@Data
public class Column {

    //名字大写 下划线命名
    private String nameUpper;
    //名字小写 下划线命名
    private String nameLower;
    //首字母大写 驼峰命名
    private String nameFirstUpperCamel;

    //首字母小写 驼峰命名
    private String nameFirstLowerCamel;


    private String dbType;
    private String javaType;
    private String jdbcType;

    private String javaTypeClassPaths;


    //注释
    private String comment;

    //是否必填
    private boolean required;

    //主键
    private boolean pk;

    //精度
    private String Precision;

    //范围
    private String Scale;

}
