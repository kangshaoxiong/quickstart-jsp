package com.my.quickstart.entity;

import com.my.quickstart.base.BaseEntity;

/***********************************************************************
 * Module:  UserGroup.java
 * Author:   Alan
 * Purpose: Defines the Class UserGroup
 ***********************************************************************/

/**
 * 用户组表
 * 
 * @pdOid 6f731d39-5d22-4f8d-9533-62488c1d5b58
 */
public class UserGroup extends BaseEntity {
	private static final long serialVersionUID = 8150074734819187880L;
	/**
	 * 名称
	 * 
	 * @pdOid 76d7b87c-68d8-4920-ad8c-d59e737ea8fa
	 */
	private String name;
	/**
	 * 编码
	 * 
	 * @pdOid 4550890b-c301-4de0-910c-89d035dfc2a4
	 */
	private String code;
	/**
	 * 状态（true：可用，false：不可用）
	 * 
	 * @pdOid 23865871-eaa1-4fb3-b2ca-a1feadcfceb6
	 */
	private boolean status;
	/**
	 * 备注
	 * 
	 * @pdOid a50f309d-e616-44a7-a117-6be4ceb187bb
	 */
	private String remarks;

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}