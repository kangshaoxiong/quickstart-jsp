package com.my.quickstart.activemq.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
/**
 * email消息生产者
 * @author Alan
 *
 */
@Component
public class EmailProducer {
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue emailQueue;

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.emailQueue, msg);
	}
	
	public void send(Object obj ) {
		this.jmsMessagingTemplate.convertAndSend(this.emailQueue,obj);
	}
}
