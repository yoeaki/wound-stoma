package com.linkgoo.framework.web.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具
 *
 */
public abstract class DateTimeUtil {
	/**
	 * 日的定义
	 */
	public static final String DAY = "0";
	/**
	 * 月定义
	 */
	public static final String MONTH = "1";
	/**
	 * 年定义
	 */
	public static final String YEAR = "2";

	/**
	 * 返回类型：String XXXXXXXX 传入类型：String XXXX-XX-XX
	 *
	 * @param str10date
	 * @return
	 */
	public static String getStr8Date(String str10date) {
		return str10date.substring(0, 4) + str10date.substring(5, 7)
				+ str10date.substring(8, 10);
	}

	/**
	 * 返回类型：YYYY-MM-DD
	 *
	 * @return String
	 */
	public static String currentDay() {
		return formatDate(new Date(), "yyyy-MM-dd");
	}

	public static Date getMaxDate() {
		return parseDate("2999-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 取当前日期的短格式
	 *
	 * @return String
	 */
	public static String getCurrentDateShort() {
		return formatDate(new Date(), PATTERN_DATESHORT);
	}

	/**
	 * 取得当前时间的字符串,格式为yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 */
	public static String currentDateTime() {
		return formatDate(new Date(), DateTimeUtil.PATTERN_DATETIME);
	}

	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static String currentYearMonth() {
		return formatDate(new Date(), "yyyyMM");
	}

	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static String currentYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static String currentMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 返回两个日期（DATE类型）相差的天数
	 *
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static int compareTo(Date dateStart, Date dateEnd) {

		return (int) (dateEnd.getTime() - dateStart.getTime()) / 1000 / 60 / 60
				/ 24;
	}

	/**
	 * 返回两个日期(STRING类型)相差的天数 "1999-11-11"
	 *
	 * @param dateStart
	 *            日期格式必须为：YYYY-MM-DD
	 * @param dateEnd
	 *            日期格式必须为：YYYY-MM-DD
	 * @return
	 */
	public static int compareToByString(String dateStart, String dateEnd) {
		Date start = DateTimeUtil.parseDate(dateStart);
		Date end = DateTimeUtil.parseDate(dateEnd);
		return compareTo(start, end);
	}

	/**
	 * 根据给出的日期，计算n天后的日期,n可以为负整数，表示n天前
	 *
	 * @param givenDate
	 * @param n
	 * @return
	 */
	public static Date addNday(Date givenDate, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(givenDate);
		c.add(Calendar.DATE, n);

		return c.getTime();
	}

	/**
	 * 根据给出的日期，计算n小时后的日期,n可以为负整数，表示n小时前
	 *
	 * @param givenDate
	 * @param n
	 * @return
	 */
	public static Date addNhour(Date givenDate, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(givenDate);
		c.add(Calendar.HOUR_OF_DAY, n);

		return c.getTime();
	}

	/**
	 * 计算日期
	 *
	 * @param givenDate
	 *            需要计算的日期
	 * @param amount
	 *            数量(LONG类型) 可以为负数
	 * @param unit
	 *            单位 (TimeUnit.YEAR/TimeUnit.MONTH/TimeUnit.DAY)
	 * @author LiuYuan
	 * @return
	 */
	public static Date accountDate(Date givenDate, long amount, String unit) {
		return accountDate(givenDate, (int) amount, unit);

	}

	/**
	 * 计算日期
	 *
	 * @param givenDate
	 *            需要计算的日期
	 * @param amount
	 *            数量(INT类型) 可以为负数
	 * @param unit
	 *            单位 (TimeUnit.YEAR/TimeUnit.MONTH/TimeUnit.DAY)
	 * @author LiuYuan
	 * @return
	 */
	public static Date accountDate(Date givenDate, int amount, String unit) {
		Calendar c = Calendar.getInstance();
		c.setTime(givenDate);

		if (DAY.equals(unit)) {
			c.add(Calendar.DATE, amount);
			return c.getTime();
		}
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		if (MONTH.equals(unit)) {
			// 判断所有月份是否是最后一天
			if (DateTimeUtil
					.formatDate(givenDate)
					.substring(8, 10)
					.equals(String.valueOf(c
							.getActualMaximum(Calendar.DAY_OF_MONTH)))) {
				c.add(Calendar.MONTH, amount);

				c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			} else {
				c.add(Calendar.MONTH, amount);
			}

			if ((c.get(Calendar.YEAR) - year) * 12 + c.get(Calendar.MONTH)
					- month > amount) {
				c.set(Calendar.DATE, 1);
				c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
				c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			}
			return c.getTime();
		}
		if (YEAR.equals(unit)) {
			c.add(Calendar.YEAR, amount);
			return c.getTime();
		} else {
			return givenDate;
		}
	}

	/**
	 * 获取指定日期所在月的最后一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getEndMonthDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.roll(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期的第一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getBeginMonthDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 统计日期当年有多少天
	 *
	 * @param date
	 * @return
	 * @author LiuYuan
	 */
	public static int getLenientDays(Date date) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		return c.isLenient() ? 366 : 365;
	}

	/**
	 * 计算日期月份内有多少天
	 *
	 * @param date
	 * @return
	 * @author LiuYuan
	 */
	public static int getDateDays(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 计算两个日期相差的单位数 取整值
	 *
	 * @param date1
	 *            日期1
	 * @param date2
	 *            日期2
	 * @param unit
	 *            计算单位 (TimeUnit.YEAR/TimeUnit.MONTH/TimeUnit.DAY)
	 * @return
	 */
	public static int getDiscrepantDays(Date date1, Date date2, String unit) {
		int dateUnit;
		if (unit != null && unit.trim().equals(DAY)) {
			dateUnit = Calendar.DATE;
		} else if (unit != null && unit.trim().equals(MONTH)) {
			dateUnit = Calendar.MONTH;
		} else if (unit != null && unit.trim().equals(YEAR)) {
			dateUnit = Calendar.YEAR;
		} else {
			return 0;
		}
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date1);
		c2.setTime(date2);
		int days = 0;
		while (c1.before(c2)) {
			c1.add(dateUnit, 1);
			days++;
		}
		while (c2.before(c1)) {
			c2.add(dateUnit, 1);
			days--;
		}
		return days;
	}

	/**
	 * 计算两个日期之间相差多少月 精确到日期
	 *
	 * （截止日期－开始日期 的最小月数) + (剩余天数/开始日期所属月的总天数)；
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static double getDiscrepantMonth(Date date1, Date date2) {

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date1);
		c2.setTime(date2);
		int year1 = c1.get(Calendar.YEAR);
		int month1 = c1.get(Calendar.MONTH);
		int day1 = c1.get(Calendar.DATE);
		int year2 = c2.get(Calendar.YEAR);
		int month2 = c2.get(Calendar.MONTH);
		int day2 = c2.get(Calendar.DATE);
		return ((year1 - year2) * 12) + (month1 - month2) + (day1 - day2)
				/ (double) c2.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 比较两个日期是否相同
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean compareDateTime(Date date1, Date date2) {
		return (date1.before(date2) || date2.before(date1)) ? false : true;
	}

	/**
	 * <pre>
	 * <h5>
	 * 根据指定格式转换字符串为日期
	 * </h5>
	 * </pre>
	 *
	 * <pre>
	 *               如果字符串格式不正确,则返回null
	 * </pre>
	 *
	 * @param date
	 *            日期字符串
	 * @param pattern
	 *            指定格式,参照类中常量定义
	 * @return java.util.Date
	 */
	public static Date parseDate(String date, String pattern) {
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException pe) {
			pe.getStackTrace();
			return null;
		}
	}

	/**
	 * <pre>
	 * <h5>
	 * 返回日期的默认格式
	 * </h5>
	 * </pre>
	 *
	 * @param date
	 *            日期字符串
	 * @return java.util.Date
	 */
	public static Date parseDate(String date) {
		return parseDate(date, PATTERN_DEFAULT);
	}

	/**
	 * <pre>
	 * <h5>
	 *               根据指定格式,格式化日期
	 * </h5>
	 * </pre>
	 *
	 * @param date
	 *            日期
	 * @param pattern
	 *            指定格式,参照类中常量定义
	 * @return java.util.Date
	 */
	public static String formatDate(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 年末
	 *
	 * @return
	 */
	public static Date getEndOfYear() {
		return parseDate(Calendar.getInstance().get(Calendar.YEAR) + "-12-31");// 停止计费时间为年底
	}

	/**
	 * 年末
	 *
	 * @return
	 */
	public static String getEndOfYearStr() {
		return Calendar.getInstance().get(Calendar.YEAR) + "-12-31";// 停止计费时间为年底
	}

	/**
	 * 月末
	 *
	 * @return
	 * @throws Exception
	 */
	public static Date getEndOfNextMonth() {
		Calendar calendar = Calendar.getInstance();
		int nextMonth = calendar.get(Calendar.MONTH) + 1;
		Date startOfNextMonth = parseDate(calendar.get(Calendar.YEAR) + "-"
				+ nextMonth + "-1");// 停止计费时间为年底

		int nextMonthDays = getDateDays(startOfNextMonth);

		return parseDate(calendar.get(Calendar.YEAR) + "-" + nextMonth + "-"
				+ nextMonthDays);
	}

	/**
	 * 日期格式化
	 *
	 * @param date
	 * @return
	 */
	public static Date dateFormat(Date date) {
		String date1 = DateTimeUtil.formatDate(date,
				DateTimeUtil.PATTERN_DEFAULT);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(date1.substring(0, 4)),
				Integer.parseInt(date1.substring(5, 7)) - 1,
				Integer.parseInt(date1.substring(8, 10)), 0, 0, 0);
		return new Date(calendar.getTimeInMillis());
	}

	/**
	 * 取指定日期的开始时间
	 *
	 * @param date
	 * @return
	 */
	public static String getDayBegin(Date date) {
		return formatDate(date) + " 00:00:00";
	}

	/**
	 * 取指定日期的结束时间
	 *
	 * @param date
	 * @return
	 */
	public static String getDayEnd(Date date) {
		return formatDate(date) + " 23:59:59";
	}

	/**
	 * 年
	 *
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 月
	 *
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 天
	 *
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * <pre>
	 * <h5>
	 *               根据默认格式,格式化日期
	 * </h5>
	 * </pre>
	 *
	 * @param date
	 *            日期
	 * @return java.util.Date
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat(PATTERN_DEFAULT).format(date);
	}

	/**
	 * 默认日期格式, <code>yyyy-MM-dd</code>
	 */
	public static final String PATTERN_DEFAULT = "yyyy-MM-dd";

	/**
	 * 路径格式, <code>yyyy\MM\dd\</code>
	 */
	public static final String PATTERN_DAYPATH = "yyyy\\MM\\dd\\";

	/**
	 * 日期时间格式, <code>yyyy-MM-dd HH:mm:ss</code>, 24小时制
	 */
	public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 无间隔符的日期时间格式, <code>yyyyMMddHHmmss</code>, 24小时制
	 */
	public static final String PATTERN_DATETIME_COMPACT = "yyyyMMddHHmmss";

	/**
	 * 无间隔符日期格式, <code>yyyyMMdd</code>
	 */
	public static final String PATTERN_DATE_COMPACT = "yyyyMMdd";

	/**
	 * 无间隔符日期格式, <code>yyMMdd</code>
	 */
	public static final String PATTERN_DATESHORT = "yyMMdd";

	/**
	 * 无间隔符日期格式, <code>yyyyMM</code>
	 */
	public static final String PATTERN_DATETOOSHORT = "yyyyMM";

	/**
	 * 将时间转为时分格式，如00:00
	 * @return
	 */
	public static String formatToHM(Calendar now) {
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		return String.format("%02d", hour) + ":" + String.format("%02d", minute);
	}

}
