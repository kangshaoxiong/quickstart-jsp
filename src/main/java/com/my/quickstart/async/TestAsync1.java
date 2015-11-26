package com.my.quickstart.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.my.quickstart.base.BaseLogger;

@Component
public class TestAsync1 extends BaseLogger {
	
	@Async
	public void doAsync() throws InterruptedException{
		logger.info("异步执行任务1.。。。。");
		Thread.sleep(3000L);
	}

}
