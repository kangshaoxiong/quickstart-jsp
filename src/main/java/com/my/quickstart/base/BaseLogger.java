package com.my.quickstart.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 日志输出类，需要输出日志的类继承该类
 * @author Alan
 *
 */
public class BaseLogger {
	protected Log logger = LogFactory.getLog(getClass());
}
