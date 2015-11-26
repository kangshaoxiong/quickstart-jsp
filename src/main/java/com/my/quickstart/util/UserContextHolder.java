package com.my.quickstart.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.my.quickstart.entity.UserAccount;
/**
 * 用户登录对象操作类
 * @author Alan
 *
 */
public class UserContextHolder {
	
	/**
	 * 判断是否登陆，true：是，false：否
	 * @return
	 */
	public static boolean isLogin(){
		SecurityContext context=SecurityContextHolder.getContext();
		Authentication au=context.getAuthentication();
		if(au==null){
			return false;
		}
		Object obj=au.getPrincipal();
		if(obj instanceof UserAccount){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取用户对象
	 * @return
	 */
	public static UserAccount getUserAccount(){
		if(isLogin()){
			return (UserAccount) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		return null;
	}
	/**
	 * 获取用户登录的Id主键
	 * @return
	 */
	public static Long getUserAccountId(){
		UserAccount ua=getUserAccount();
		if(null!=ua){
			return ua.getId();
		}
		return null;
	}
	/**
	 * 获取用户名
	 * @return
	 */
	public static String getUsername(){
		UserAccount ua=getUserAccount();
		if(null!=ua){
			return ua.getUsername();
		}
		return null;
	}

}
