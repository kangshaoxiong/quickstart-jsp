package com.my.quickstart.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
/**
 * 登录失败后相应的操作
 * @author Alan
 *
 */
public class LoginFailHandler extends SimpleUrlAuthenticationFailureHandler {
	private final Log logger=LogFactory.getLog(getClass());

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		logger.info("登录失败后的处理。。。");
		super.setDefaultFailureUrl("/login");
		super.onAuthenticationFailure(request, response, exception);
	}
}
