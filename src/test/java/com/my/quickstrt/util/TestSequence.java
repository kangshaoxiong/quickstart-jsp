package com.my.quickstrt.util;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.my.quickstart.sequence.Sequence;
import com.my.quickstrt.base.BaseTest;

public class TestSequence extends BaseTest {
	
	@Autowired
	private Sequence globalSequence;

	@Test
	@Rollback(false)
	public void testGlobalSequence(){
		long v=globalSequence.nextValue();
		System.out.println("v="+v);
	}
}
