package com.my.quickstart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.my.quickstart.base.BaseLogger;
import com.my.quickstart.entity.UserAccount;
import com.my.quickstart.service.UserAccountService;
import com.my.quickstart.util.StringUtils;
@Component
public class UserDetailsServiceImpl extends BaseLogger implements UserDetailsService {
	
	@Autowired
	private UserAccountService userAccountService;

	@Override
	public UserAccount loadUserByUsername(String username)
			throws UsernameNotFoundException {
		if(StringUtils.isBlank(username)){
			return null;
		}
		UserAccount user= userAccountService.findByAccount(username);
		if(user==null){
			logger.info("用户["+username+"]不存在！");
			throw new UsernameNotFoundException("用户["+username+"]不存在！");
		}
		return user;
	}

}
