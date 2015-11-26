package com.my.quickstart.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.my.quickstart.base.BaseLogger;

@Component
public class TestJob1 extends BaseLogger {
	
//	@Scheduled(fixedDelay=3000)
	public void doSomething(){
		logger.info("定时执行任务测试1.。。。。。。");
	}

}
