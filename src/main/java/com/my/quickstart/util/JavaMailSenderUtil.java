package com.my.quickstart.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 发送邮件工具类
 * @author Alan
 *
 */
@Component
public class JavaMailSenderUtil {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired 
	private  JavaMailSender javaMailSender;
	
	@Value("${email.isSupport}")
	private boolean isSupport;
	@Value("${spring.mail.properties.mail.from}")
	private String from;
	
	/**
	 * 发送邮件
	 * @param emailAddress
	 * @param content
	 */
	public  void sendSimpleEmail(String emailAddress,String subject,String content){
		sendSimpleEmail(emailAddress,subject,content, null);
	}

	/**
	 * 向某个人发送邮件，支持替换指定字符串为想要的内容
	 * @param emailAddress
	 * @param content
	 * @param map
	 */
	public  void sendSimpleEmail(String emailAddress,String subject,String content,Map<String, String> map){
		if(!isSupport) return ;
		
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom(this.from);
		msg.setTo(emailAddress);
		msg.setSubject(subject);
		if(map!=null){
			for(String key:map.keySet()){
				content.replace(key, map.get(key));
			}
		}
		msg.setText(content);
		try {
			javaMailSender.send(msg);
		} catch (Exception e) {
			logger.error("发送email失败，发送地址为:["+emailAddress+"],错误原因为:",e);
		}
	}
	
	
	/**
	 * 群发邮件内容
	 * @param emailAddresses
	 * @param content
	 */
	public void  sendSimpleEmail(String [] emailAddresses,String subject,String content){
		if(!isSupport) return ;
		
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom(this.from);
		msg.setTo(emailAddresses);
		msg.setSubject(subject);
		msg.setText(content);
		try {
			javaMailSender.send(msg);
		} catch (Exception e) {
			logger.error("发送email失败，发送地址为:["+emailAddresses.toString()+"],错误原因为:",e);
		}
	}
	
	//以上提供的只是发送简单的邮件，如果要发送复杂的邮件或使用Velocity模板，请参照网址: http://docs.spring.io/spring/docs/4.1.8.RELEASE/spring-framework-reference/htmlsingle/#mail 
	
}
