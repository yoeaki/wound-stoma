package com.linkgoo.framework.utils.generation.parser;

import com.linkgoo.framework.utils.generation.model.Table;
import com.linkgoo.framework.utils.generation.utils.StringUtil;
import com.linkgoo.framework.utils.generation.config.Dialect;
import com.linkgoo.framework.utils.generation.model.Column;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TableParser {

    public static void parseTableName(Table table, String line) throws Exception {
        if (StringUtils.isBlank(line)) {
            throw new Exception("line 为空 无法解析表头");
        }
        String[] paramStr = line.split(",");

        String dbTableName = paramStr[0];
        String comment = paramStr[1];
        String modelName = paramStr[2];

        table.setNameLower(dbTableName.toLowerCase());
        table.setNameUpper(dbTableName.toUpperCase());
        table.setNameFirstLowerCamel(FirstUpperCase(dbTableName));

        String camel = StringUtil.underlineToCamel(dbTableName);
        table.setNameFirstLowerCamel(camel);
        table.setNameFirstUpperCamel(FirstUpperCase(camel));
        table.setComment(comment);

        table.setModelName(modelName.toLowerCase());
        table.setModelNameFirstLowerCamel(StringUtil.underlineToCamel(table.getModelName()));
        table.setModelNameFirstUpperCamel(FirstUpperCase(table.getModelNameFirstLowerCamel()));

    }

    public static String FirstUpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static List<Column> parseColumn(List<String> listContent, Dialect sqlDialect) throws Exception {
        List<Column> list = new ArrayList<Column>();
        int i = 0;
        for (String line : listContent) {
            i++;
            if (StringUtils.isBlank(line)) {
                continue;
            }
            String[] columns = line.split("\t");
            if (columns.length >= 3) {

                    String columnName = columns[1].toLowerCase();
                    String dbType = columns[2];

                    Column column = new Column();
                    column.setComment(columns[0]);
                    column.setDbType(dbType);
                    column.setNameLower(columnName.toLowerCase());
                    column.setNameUpper(columnName.toUpperCase());
                    String camel = StringUtil.underlineToCamel(columnName);

                    column.setNameFirstLowerCamel(camel);
                    column.setNameFirstUpperCamel(FirstUpperCase(camel));

                    column = sqlDialect.parseDate(column);

                if (columns.length > 3) {
                    if (columns[3].contains("必填")) {
                        column.setRequired(true);
                    }else{
                        column.setRequired(false);
                    }
                    if (columns[3].equalsIgnoreCase("PK")) {
                        column.setPk(true);
                    }else{
                        column.setPk(false);
                        column.setRequired(true);
                    }
                }

                list.add(column);
            } else {
                throw new Exception("第" + i + "行数据异常:"+line);
            }
        }
        return list;
    }


}
