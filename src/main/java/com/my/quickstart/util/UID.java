package com.my.quickstart.util;

import java.util.Date;

/**
 * 生成唯一性的数字串
 * 
 * @author yuy
 *
 */
public class UID {

	private static Date date = new Date();
	private static StringBuilder buf = new StringBuilder();
	private static int seq = 0;
	private static final int ROTATION = 99999;

	public static synchronized String next() {
		if (seq > ROTATION)
			seq = 0;
		buf.delete(0, buf.length());
		date.setTime(System.currentTimeMillis());
		return String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);
	}

}
