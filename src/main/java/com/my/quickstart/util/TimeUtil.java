package com.my.quickstart.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间工具类
 * 
 * @author yuy
 * @date 2015-05-19 20:41
 */
public class TimeUtil {

	private static Logger logger = LoggerFactory.getLogger(TimeUtil.class);

	/**
	 * Date 转成 yyyyMMddHHmmss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToStr_yyyyMMddHHmmss(Date date) {
		if (date == null)
			return null;
		String str = null;
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		str = format.format(date);
		return str;
	}

	/**
	 * Date 转成 yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToStr_yyyyMMdd(Date date) {
		if (date == null)
			return null;
		String str = null;
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		str = format.format(date);
		return str;
	}

	/**
	 * yyyyMMdd 转成 Date
	 * 
	 * @param str
	 * @return
	 */
	public static Date strToDate_yyyyMMdd(String str) {
		if (StringUtil.isnull(str))
			return null;
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			logger.error("yyyyMMdd转Date出现异常", e);
			return null;
		}
		return date;
	}

	/**
	 * yyyyMMddHHmmss 转成 Date
	 * 
	 * @param str
	 * @return
	 */
	public static Date strToDate_yyyyMMddHHmmss(String str) {
		if (StringUtil.isnull(str))
			return null;
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			logger.error("yyyyMMddHHmmss转Date出现异常", e);
			return null;
		}
		return date;
	}

	/**
	 * yyyyMMddHHmmss 转成 Date
	 * 
	 * @param str
	 * @return
	 */
	public static Date strToDate(String str) {
		if (StringUtil.isnull(str))
			return null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			logger.error("yyyyMMddHHmmss转Date出现异常", e);
			return null;
		}
		return date;
	}

}
