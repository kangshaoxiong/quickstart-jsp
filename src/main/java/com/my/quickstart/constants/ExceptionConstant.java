package com.my.quickstart.constants;

import org.springframework.http.HttpStatus;

/**
 * 异常处理常量
 * @author Alan
 *
 */
public class ExceptionConstant {
	
	private static final String prefix="/";
	/**
	 * 请求错误： /400 Bad Request
	 */
	public static final String PAGE_400=prefix+HttpStatus.BAD_REQUEST.value();
	/**
	 * 无权限： /401 Unauthorized
	 */
	public static final String PAGE_401=prefix+HttpStatus.UNAUTHORIZED.value();
	/**
	 * /402 Payment Required
	 */
	public static final String PAGE_402=prefix+HttpStatus.PAYMENT_REQUIRED.value();
	/**
	 * 拒绝： /403, "Forbidden"
	 */
	public static final String PAGE_403=prefix+HttpStatus.FORBIDDEN.value();
	/**
	 * 找不到： /404, "Not Found"
	 */
	public static String PAGE_404=prefix+HttpStatus.NOT_FOUND.value();
	/**
	 * 方法不允许访问： /405, "Method Not Allowed"
	 */
	public static final String PAGE_405=prefix+HttpStatus.METHOD_NOT_ALLOWED.value();
	/**
	 * 服务器错误： /500 Internal Server Error
	 */
	public static final String PAGE_500=prefix+HttpStatus.INTERNAL_SERVER_ERROR.value();
	/**
	 * 请求超时： /504 Gateway Timeout
	 */
	public static final String PAGE_504=prefix+HttpStatus.GATEWAY_TIMEOUT.value();

}
