package com.my.quickstart.constants;
/**
 * 常用静态常量
 * @author Alan
 *
 */
public class Constant {
	/**
	 * 查询配置前缀
	 */
	public static final String QUERY_PRFIX="qp_";
	/**
	 * BCryptPasswordEncoder strength <br/>
	 * 由于采用的慢算法，该值越大，计算加密密码的时间越长
	 */
	public static final int BCRYPT_LENGTH=12;
}
