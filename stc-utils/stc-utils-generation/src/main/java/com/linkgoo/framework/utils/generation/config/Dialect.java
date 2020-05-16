package com.linkgoo.framework.utils.generation.config;

import com.linkgoo.framework.utils.generation.model.Column;
import lombok.Data;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class Dialect {



    final static Map<String,String> jdbcTojavaTypes = new HashMap<>();
    static {
        jdbcTojavaTypes.put("BIGINT", "Long");
        jdbcTojavaTypes.put("BINARY", "Byte[]");
        jdbcTojavaTypes.put("BIT", "Boolean");
        jdbcTojavaTypes.put("CHAR", "String");
        jdbcTojavaTypes.put("DATE", "java.util.Date");
        jdbcTojavaTypes.put("TIMESTAMP", "java.util.Date");
        jdbcTojavaTypes.put("DECIMAL", "java.math.BigDecimal");
        jdbcTojavaTypes.put("LONGVARBINARY", "Byte[]");
        jdbcTojavaTypes.put("INTEGER", "Integer");
        jdbcTojavaTypes.put("LONGVARCHAR", "String");
        jdbcTojavaTypes.put("REAL", "Float");
        jdbcTojavaTypes.put("SMALLINT", "Integer");
        jdbcTojavaTypes.put("TINYINT", "Integer");
        jdbcTojavaTypes.put("VARBINARY", "Byte[]");
        jdbcTojavaTypes.put("DOUBLE", "Double");
        jdbcTojavaTypes.put("VARCHAR", "String");
    }


    public abstract Map<String,String> getDbTypes();

    public abstract String getDatabaseName();

    public abstract String getDriverClass();

    public Column parseDate(Column column) throws Exception {
        Map<String, String> dbTypes = this.getDbTypes();
        String dbType = column.getDbType();

        String jdbcType = dbTypes.get(dbType.replaceAll("\\([\\s\\S]*\\)", ""));
        String javaType = jdbcTojavaTypes.get(jdbcType);
        column.setJavaType(javaType);
        column.setJdbcType(jdbcType);
        column.setJavaTypeClassPaths(javaType);

        Pair<String, String> pair =  parseNumber(dbType);
        column.setPrecision(pair.getLeft());
        column.setScale(pair.getRight());

        return column;
    }
    static Pair<String, String> parseNumber(String field) {
        if (!field.contains("(") || !field.contains(")"))
            return new ImmutablePair<String, String>(null, null);
        String temp = field.trim();
        int begin = temp.indexOf("(");
        int end = temp.indexOf(")");
        String precision = temp.substring(begin + 1, end).trim();
        String scale = null;
        if (precision.contains(",")) {
            String arr[] = precision.split(",");
            precision = arr[0].trim();
            scale = arr[1].trim();
        }
        return new ImmutablePair<String, String>(precision, scale);
    }
}
