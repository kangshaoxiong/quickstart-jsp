package com.my.quickstart.entity;

/***********************************************************************
 * Module:  OperateLog.java
 * Author:  Alan
 * Purpose: Defines the Class OperateLog
 ***********************************************************************/

import java.util.*;

import com.my.quickstart.base.BaseEntity;

/**
 * 操作日志表
 * 
 * @pdOid a6174169-3b1e-444e-9b9e-c883e6189ce9
 */
public class OperateLog extends BaseEntity {
	private static final long serialVersionUID = 1302329620684824222L;
	/**
	 * 账号
	 * 
	 * @pdOid 150c8087-98b8-4a67-85da-f4b808ce53ab
	 */
	private String account;
	/**
	 * 昵称
	 * 
	 * @pdOid 65db82e5-9221-4c75-857c-a28c4d6d614b
	 */
	private String nickname;
	/**
	 * 操作内容
	 * 
	 * @pdOid 416d8cf5-9c62-4fe8-9b05-7c7ae66bcbf3
	 */
	private String content;
	/**
	 * 操作时间
	 * 
	 * @pdOid a855ef71-52f9-4b5b-980a-5f163dc921d7
	 */
	private Date operateTime;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
}