package com.my.quickstrt.service;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.my.quickstart.entity.UserAccount;
import com.my.quickstart.service.UserAccountService;
import com.my.quickstrt.base.BaseTest;

@SuppressWarnings("deprecation")
public class TestUserAccountService extends BaseTest {
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Test
	public void getUserAccountById(){
		UserAccount entity = userAccountService.getUserAccountById(1L);
		Assert.assertEquals("100100",entity.getUsername());
	}
	
	@Test
	public void getUserByIdAndAccount(){
		UserAccount entityAccount = userAccountService.getUserByIdAndUsername(3L);
		Assert.assertEquals("100102",entityAccount.getUsername());
	}
	@Test 
	public void test(){
		System.out.println("调试。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
	}
	@Test
	public void addUserAccount(){
		UserAccount userAccount=new UserAccount();
		userAccount.setUsername("admin");
		userAccount.setNickname("admin");
		userAccount.setMobile("13100000000");
		userAccount.setEmail("123@163.com");
		userAccount.setQq("12345678");
		userAccount.setPlainPassword("123456");
		userAccount.setLastLandTime(new Date());
		userAccount.setLastLandIp("127.0.0.1");
		userAccount.setAccountNonExpired(true);
		userAccount.setAccountNonLocked(true);
		userAccount.setCredentialsNonExpired(true);
		userAccount.setEnabled(true);
		userAccountService.addUserAccount(userAccount);
	}
	
	@Test
	public void findAll(){
		logger.info("#########################################################");
		userAccountService.findAll();
		logger.info("=======================================================");
		userAccountService.findAll();
		logger.info("#########################################################");
	}
	
}
