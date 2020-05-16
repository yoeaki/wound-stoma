package com.linkgoo.framework.utils.generation.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class Table {

    private String nameUpper;
    private String nameLower;

    //首字母大写 驼峰命名
    private String nameFirstUpperCamel;

    //首字母小写写 驼峰命名
    private String nameFirstLowerCamel;

    //注释
    private String comment;

    //模块名
    private String modelName;

    //模块名 首字母大写驼峰
    private String modelNameFirstUpperCamel;
    //模块名 首字母小写驼峰
    private String modelNameFirstLowerCamel;

    //前缀
    private String prefix;

    // pk的列
    private List<Column> pk = new ArrayList<Column>();

    private List<Column> columns = new ArrayList<Column>();// 所有的列

    private List<Column> plainColumns = new ArrayList<Column>();// 除pk的列

    //全名
    public String getFullName() {
        if (StringUtils.isBlank(prefix)) {
            return modelName+"_"+nameLower;
        }else{
            return prefix+"_"+modelName+"_"+nameLower;
        }
    }


}
