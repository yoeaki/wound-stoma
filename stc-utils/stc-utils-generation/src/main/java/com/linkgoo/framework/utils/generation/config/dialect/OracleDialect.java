package com.linkgoo.framework.utils.generation.config.dialect;


import com.linkgoo.framework.utils.generation.config.Dialect;

import java.util.HashMap;
import java.util.Map;

public class OracleDialect extends Dialect {

	private final static Map<String,String> dbTypes = new HashMap<>();
	static {
		dbTypes.put("int", "NUMERIC");
		dbTypes.put("char", "VARCHAR");
		dbTypes.put("varchar", "VARCHAR");
		dbTypes.put("longtext", "LONGVARCHAR");
		dbTypes.put("bit", "BOOLEAN");
		dbTypes.put("BIGINT", "BIGINT");
		dbTypes.put("double", "DOUBLE");
		dbTypes.put("decimal", "DECIMAL");
		dbTypes.put("datetime", "TIMESTAMP");
	}

	@Override
	public Map<String,String> getDbTypes() {
		return dbTypes;
	}

	@Override
	public String getDatabaseName() {
		return "oracle";
	}

	@Override
	public String getDriverClass() {
		return "oracle.jdbc.driver.OracleDriver";
	}
}
