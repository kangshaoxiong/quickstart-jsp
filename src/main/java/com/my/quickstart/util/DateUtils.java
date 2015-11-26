/**
 * 
 */
package com.my.quickstart.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.my.quickstart.exception.UtilException;

/**
 * @author mingxing.fmx
 * 
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS="yyyy-MM-dd HH:mm:ss";
    
    /**
     * 默认将数据库中取出的日期转化为指定的日期格式
     * @author azy
     * @param date
     * @return
     */
    public static String formatDate(Date date){
        String d=formatDate(date, FORMAT_YYYY_MM_DD_HH_MM_SS);
        return d;
    }
    
    /**
     * 将数据库中取出的时间直接转化为指定的时间格式
     * @author azy
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date,String pattern){
        String d=null;
        if(date!=null)
            d=DateFormatUtils.format(date, pattern);
        return d;
    }

    /**
     * 将数据版本号转化为相对应的日期格式字符串
     * 
     * @param dataVersion
     * @param pattern
     * @return
     * @throws UtilException
     */
    public static String formatDate(Integer dataVersion, String pattern) throws UtilException {
        String tmp = dataVersion.toString();
        DateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Date date;
        try {
            date = sf.parse(tmp);
        } catch (ParseException e) {
            throw new UtilException("字符串解析成日期对象时异常", e);
        }
        DateFormat sf2 = new SimpleDateFormat(pattern);
        return sf2.format(date);
    }
    
    /**
     * 以参数中的日期向前或向后推N天，获取数据版本
     * 
     * @param dataVersion
     * @param days
     * @return
     * @throws UtilException
     */
    public static int addDays(Integer dataVersion, int days) throws UtilException {
        String tmp = dataVersion.toString();
        DateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Date date;
        try {
            date = sf.parse(tmp);
        } catch (ParseException e) {
            throw new UtilException("字符串解析成日期对象时异常", e);
        }

        String dateStr = sf.format(addDays(date, days));
        return Integer.parseInt(dateStr);
    }

    /**
     * 以昨天为日期获取数据版本
     * 
     * @return
     */
    public static int getYesterdayDataVersion() {
        Date d = addDays(new Date(), -1);
        DateFormat sf = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt(sf.format(d));
    }
    
    /**
     * 字符串转换到指定的时间格式
     * @param dateStr 需要转换的时间字符串
     * @param formatStr 需要格式的目标字符串格式,如： yyyy-MM-dd
     * @return 返回转换后的时间
     */
    public static Date formatStringToDate(String dateStr,String formatStr){
        if(StringUtils.isBlank(dateStr)){
            return null;
        }
        DateFormat sdf=new SimpleDateFormat(formatStr);
        Date date=null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
