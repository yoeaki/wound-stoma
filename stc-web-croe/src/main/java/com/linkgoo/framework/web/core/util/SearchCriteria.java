package com.linkgoo.framework.web.core.util;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.Map.Entry;

/**
 * 模糊查询工具类,已支持like和In
 *
 * @author one
 *
 */
@SuppressWarnings("serial")
public class SearchCriteria implements java.io.Serializable {
	public static final boolean MAP_UNDERSCORE_TO_CAMELCASE = true;
	private static final char SEPARATOR = '_';
	/**
	 * like查询匹配,如like_name
	 */
	public static final String LIKE = "like";
	/**
	 * 左模糊匹配,如llike_name
	 */
	public static final String R_LIKE = "rlike";
	/**
	 * 右模糊匹配,如rlike_name
	 */
	public static final String L_LIKE = "llike";
	/**
	 * in方式查询,需要value为数组,或者value为逗号分割的字符串
	 */
	public static final String IN = "in";
	/**
	 * not in方式查询,需要value为数组,或者value为逗号分割的字符串
	 */
	public static final String N_IN = "nin";
	/**
	 * 等于的查询,可省略
	 */
	public static final String EQ = "eq";
	/**
	 * 不等于查询方式
	 */
	public static final String NE = "ne";
	/**
	 * 大于查询方式
	 */
	public static final String GT = "gt";
	/**
	 * 小于查询方式
	 */
	public static final String LT= "lt";
	/**
	 * 小于等于查询方式
	 */
	public static final String LTE= "lte";
	/**
	 * 大于等于查询方式
	 */
	public static final String GTE= "gte";

	/**
	 * 大于等于查询方式
	 */
	public static final String NNUll= "nnull";

	protected static Map<String, String> operatorMap = new HashMap<>();
	static {

		operatorMap.put(EQ, "=");
		operatorMap.put(NE, "!=");
		operatorMap.put(L_LIKE, LIKE);
		operatorMap.put(R_LIKE, LIKE);
		operatorMap.put(LIKE, LIKE);
		operatorMap.put(GT, ">");
		operatorMap.put(LT, "<");
		operatorMap.put(GTE, ">=");
		operatorMap.put(LTE, "<=");
		operatorMap.put(IN, IN);
		operatorMap.put(N_IN, "not in");
		operatorMap.put(NNUll, "is not");
	}

	private String field;
	private Object value;
	private String op;

	/**
	 * 默认构造函数
	 */
	public SearchCriteria() {
		//do nothing
	}
	/**
	 * 初始化查询
	 * @param field
	 * @param op
	 * @param value
	 */
	public SearchCriteria(String field, String op, Object value) {
		this.field = field;
		this.value = value;
		this.op = op;
	}
	/**
	 * 解析查询,返回适合sql使用的类型
	 * @param searchParams
	 * @return
	 */
	public static Map<String, SearchCriteria> parse(
			Map<String, Object> searchParams) {
		Map<String, SearchCriteria> filters = new HashMap<>();

		for (Entry<String, Object> entry : searchParams.entrySet()) {
			SearchCriteria filter = createCriteria(entry);
			if (filter != null)
				filters.put(entry.getKey(), filter);
		}
		return filters;
	}
	/**
	 * 返回数组的查询构造
	 * @param searchParams
	 * @return
	 */
	public static List<SearchCriteria> toList(Map<String, Object> searchParams) {

		List<SearchCriteria> filters = new ArrayList<>();

		for (Entry<String, Object> entry : searchParams.entrySet()) {
			SearchCriteria filter = createCriteria(entry);
			if (filter != null)
				filters.add(filter);
		}
		return filters;
	}

	protected static SearchCriteria createCriteria(Entry<String, Object> entry) {
		// 过滤掉空值
		String key = entry.getKey();
		Object value = entry.getValue();
		if (value instanceof String && StringUtils.isBlank((String) value)&&key.indexOf(NNUll)<0) {
			return null;
		}

		// 拆分operator与field
		String[] names = StringUtils.split(key, "_");

		if (names.length == 1) {
			return new SearchCriteria(underline(key), operatorMap.get(EQ), value);
		}

		if (names.length == 3 && "d".equals(names[0])) {
			value = DateTimeUtil.formatDate(new Date(Long.valueOf((String)value)), DateTimeUtil.PATTERN_DATETIME);
			return new SearchCriteria(names[2], operatorMap.get(names[1]),
					value);
		}

		if(!operatorMap.containsKey(names[0])){
			return new SearchCriteria(key, operatorMap.get(EQ), value);
		}
		if (names.length != 2) {
			throw new IllegalArgumentException(key
					+ " is not a valid search filter name");
		}
		String field = names[1];
		if (MAP_UNDERSCORE_TO_CAMELCASE) {
			field = underline(field);
		}

		if (LIKE.equals(names[0])) {
			value = String.format("%%%s%%", value);

		} else if (R_LIKE.equals(names[0])) {
			value = String.format("%s%%", value);
		} else if (L_LIKE.equals(names[0])) {
			value = String.format("%%%s", value);
		} else if (IN.equals(names[0])){
			if(!(value instanceof List || value.getClass().isArray() ))
			value = Arrays.asList(((String)value).split(","));
		} else if (NNUll.equals(names[0])) {
			value = null;
		}
		return new SearchCriteria(field, operatorMap.get(names[0]), value);
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public static String underline(String s) {
		Objects.requireNonNull(s);

		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			boolean nextUpperCase = true;

			if (i < (s.length() - 1)) {
				nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
			}

			if ((i >= 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					if (i > 0)
						sb.append(SEPARATOR);
				}
				upperCase = true;
			} else {
				upperCase = false;
			}

			sb.append(Character.toLowerCase(c));
		}

		return sb.toString();
	}


}
