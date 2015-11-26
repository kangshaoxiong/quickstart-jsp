package com.my.quickstart.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
/**
 * 登录成功后的操作
 * @author Alan
 *
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private final Log logger=LogFactory.getLog(getClass());

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		logger.info("登录成功，记录保存登录成功信息！");
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
}
