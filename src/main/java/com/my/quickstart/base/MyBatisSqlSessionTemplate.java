package com.my.quickstart.base;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
/*
 * 定义执行mybatis的模板类
 * Alan
 */
public class MyBatisSqlSessionTemplate {
	
	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;
	
}
