package com.my.quickstrt.util;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.my.quickstart.util.Digests;
import com.my.quickstrt.base.BaseTest;

public class SecurityTest extends BaseTest {
	private static ShaPasswordEncoder sha;
	@Before
	public void before(){
		sha=new ShaPasswordEncoder(512);
		sha.setEncodeHashAsBase64(true);
	}
	
	public static void main(String [] args) throws UnsupportedEncodingException{
//		String salt=Digests.generateUUIDSalt();
//		System.out.println(salt);
//		String pw=sha.encodePassword("123456",salt);
//		System.out.println(pw); 
		byte [] b=new byte[16];
		SecureRandom random=new SecureRandom(b);
//		for(int i=0;i<10;i++){
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
			String encoderpassword = encoder.encode("123456");
			System.out.println("password=["+encoderpassword+"]");
//		}
		
	}
	
	@Test
	public void testSha(){
		String salt="de7d08e1-2fd6-387b-ba94-0a0a75c7b57e";
		String pw=sha.encodePassword("123456",salt);
		System.out.println(pw);
	}
	
	@Test
	public void testBcrypt(){
		for(int i=0;i<10;i++){
			String password = "123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			System.out.println(hashedPassword);
		}
	}

}
