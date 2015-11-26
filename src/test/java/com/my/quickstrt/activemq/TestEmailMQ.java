package com.my.quickstrt.activemq;

import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;
import javax.jms.JMSException;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;

import com.my.quickstart.activemq.producer.EmailProducer;
import com.my.quickstrt.base.BaseTest;
/**
 * 消息测试
 * @author Alan
 *
 */
public class TestEmailMQ extends BaseTest {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Resource
	private EmailProducer emailProducer;

	@Test
	public void sendSimpleMessage() throws InterruptedException, JMSException {
		logger.info("开始发送消息。。。");
		this.emailProducer.send("Test message");
		Thread.sleep(1000L);
		assertTrue(this.outputCapture.toString().contains("Test message"));
	}
}
