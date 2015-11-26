package com.my.quickstart.activemq.consumer;

import javax.jms.JMSException;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.my.quickstart.base.BaseLogger;
import com.my.quickstart.constants.ActivemqConstant;
import com.my.quickstart.dto.EmailDto;
import com.my.quickstart.util.JavaMailSenderUtil;
import com.my.quickstart.util.StringUtils;
/**
 * email消息消费者
 * @author Alan
 *
 */
@Component
public class EmailConsumer extends BaseLogger {
	
	@Autowired
	private JavaMailSenderUtil javaMailSenderUtil;
	
	@JmsListener(destination = ActivemqConstant.EMAIL_QUEUE)
	public void receiveQueue(Object obj) throws JMSException {
		ActiveMQObjectMessage amt=(ActiveMQObjectMessage)obj;
		Object object=amt.getObject();
		if(object instanceof EmailDto){
			EmailDto e=(EmailDto) object;
			String to=e.getTo();
			if(StringUtils.isNotBlank(to)){
				javaMailSenderUtil.sendSimpleEmail(to,e.getSubject(),e.getText());
			}
			String [] tos=e.getTos();
			if(tos!=null&&tos.length>0){
				javaMailSenderUtil.sendSimpleEmail(tos, e.getSubject(), e.getText());
			}
		}
	}
}
