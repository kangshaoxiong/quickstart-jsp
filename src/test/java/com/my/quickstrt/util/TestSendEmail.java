package com.my.quickstrt.util;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.jms.JMSException;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;

import com.my.quickstart.activemq.producer.EmailProducer;
import com.my.quickstart.dto.EmailDto;
import com.my.quickstart.util.JavaMailSenderUtil;
import com.my.quickstrt.base.BaseTest;

public class TestSendEmail extends BaseTest { 
	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	@Autowired
	private JavaMailSenderUtil javaMailSenderUtil;
	@Autowired
	private EmailProducer emailProducer;

	@Test
	public void sendMsg(){
		logger.info("开始发送邮件。。。。。。");
		javaMailSenderUtil.sendSimpleEmail("anzhongyao@fumen.com","温馨提示3！", "您好，这是一份问候邮件，请勿回复！");
		logger.info("邮件发送处理完成！");
	}
	
	@Test
	public void sendMail() throws InterruptedException , JMSException {
		logger.info("开始通过消息服务发送邮件。。。");
		EmailDto email=new EmailDto();
		email.setTo("anzhongyao@fumen.com");
		email.setSubject("这是一个使用消息服务发送的邮件");
		email.setText("您好，这是一份问候邮件，请勿回复！"+new Date());
		emailProducer.send(email);
		logger.info("邮件发送成功！");
		logger.info("等待消费者消费。。。");
		Thread.sleep(3000L);
		assertTrue(this.outputCapture.toString().contains(email.getText()));
	}
}
