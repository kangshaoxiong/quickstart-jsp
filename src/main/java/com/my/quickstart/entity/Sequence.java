package com.my.quickstart.entity;

/***********************************************************************
 * Module:  Sequence.java
 * Author:   Alan
 * Purpose: Defines the Class Sequence
 ***********************************************************************/

import java.util.*;

import com.my.quickstart.base.BaseEntity;

/**
 * 生成序列号表
 * 
 * @pdOid 51fa32cd-6ab6-4ede-aa33-aa5807843682
 */
public class Sequence extends BaseEntity {
	private static final long serialVersionUID = 7993088501195992145L;
	/**
	 * 名称
	 * 
	 * @pdOid 62b07782-3616-453e-9d75-87beb64c4424
	 */
	private String name;
	/**
	 * 编码
	 * 
	 * @pdOid 1b7ea469-c6c5-4534-989d-67f4c3b4078c
	 */
	private String code;
	/**
	 * 序列值
	 * 
	 * @pdOid c946c607-478a-4dc9-b0d7-23d0e8a98171
	 */
	private Long value;
	/**
	 * 最后修改时间
	 * 
	 * @pdOid ae288625-b355-4c6f-a7ad-d67364bca47a
	 */
	private Date lastUpdateTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}