package com.my.quickstart.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class NumberUtil {

	public static Pattern patternInt = Pattern.compile("(^[+-]?([0-9]|([1-9][0-9]*)))");
//	public static Pattern patternInt = Pattern.compile("^[+-]?[0-9]+$");
	
	public static Pattern patternDouble = Pattern.compile("^[+-]?(([1-9]\\d*\\.?\\d+)|(0{1}\\.\\d+)|0{1})");//判断是否为小数
//	public static Pattern patternDouble = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");//判断是否为小数

	public static boolean isNumeric(String str) { 
		if(StringUtils.isBlank(str)) {
			return false;
		}
		
		for (int i = str.length();--i>=0;){
			if (!Character.isDigit(str.charAt(i))){
				return false;    
				}   
		}   return true;  
	} 
	
	/**
	 * 判断是否是个整数（int,long等）
	 * @param str
	 * @return
	 */
	public static boolean isNumericInt(String str) {
		if(str == null) {
			return false;
		}
		
		return patternInt.matcher(str).matches();
	}
	
	/***
	 * 判断object是否是数字
	 * @param obj
	 * @return
	 */
	public static boolean isNumericInt(Object obj){
		if(obj==null){
			return false;
		}
		if (obj instanceof Integer) {
			return true;
		}else if(obj instanceof Long){
			return true;
		}else if (obj instanceof Double ){
			return true;
		} else if (obj instanceof Float) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 判断是否是个小数（double,float等）
	 * @param str
	 * @return
	 */
	public static boolean isNumericDouble(String str) {
		if(str == null) {
			return false;
		}
		
		return patternDouble.matcher(str).matches()||isNumericInt(str);
	}
	
	public static boolean isBoolean(String str) {
		if(str == null) {
			return false;
		}
		
		return str.equals("true") || str.equals("false");
	}
	
	public static boolean isDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			format.parse(str);
		} catch (ParseException e) {
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 生成订单编号
	 * @return
	 */
	public static String getBillNo(String uid) {
		java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
		java.text.SimpleDateFormat formatter2 = new java.text.SimpleDateFormat("yyyyMMddHHmmss"); 
		Random random = new Random(); 
		String billno = uid+formatter2.format(currentTime) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
		
		return billno;
	}

	/**
	 * 把int类型转换成long类型
	 */
	public static long getLongVal(int value) {
		return Long.parseLong(value + "");
	}
	
	/**
	 * 金额格式化
	 */
	public static String amountFormat(double amount) {
		DecimalFormat myformat = new DecimalFormat();
		myformat.applyPattern("##,###.00");
		
		return myformat.format(amount);
	}
}
