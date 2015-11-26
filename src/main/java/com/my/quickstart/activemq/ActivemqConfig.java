package com.my.quickstart.activemq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.my.quickstart.base.BaseLogger;
import com.my.quickstart.constants.ActivemqConstant;
/**
 * Activemq配置
 * @author Alan
 *
 */
@Configuration
public class ActivemqConfig extends BaseLogger {

	
	@Bean
	public Queue emailQueue() {
		return new ActiveMQQueue(ActivemqConstant.EMAIL_QUEUE);
	}
	
	@Bean
	public Queue SMSQueue() {
		return new ActiveMQQueue(ActivemqConstant.SMS_QUEUE);
	}
}
