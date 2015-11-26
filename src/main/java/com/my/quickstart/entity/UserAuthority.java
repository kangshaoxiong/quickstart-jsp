package com.my.quickstart.entity;

import com.my.quickstart.base.BaseEntity;

/***********************************************************************
 * Module:  UserAuthority.java
 * Author:   Alan
 * Purpose: Defines the Class UserAuthority
 ***********************************************************************/

/**
 * 用户权限表
 * 
 * @pdOid faddc00d-c321-49af-950b-c3d8cf9c6550
 */
public class UserAuthority extends BaseEntity {
	private static final long serialVersionUID = 5219975365217420242L;
	/**
	 * 名称
	 * 
	 * @pdOid 513c8220-c397-4496-bb58-ce94d07cf890
	 */
	private String name;
	/**
	 * 编码
	 * 
	 * @pdOid 0de01df9-ecbf-464b-bbd7-a1c92e8c48eb
	 */
	private String code;
	/**
	 * 备注
	 * 
	 * @pdOid 4b4e6242-2123-4dfc-9569-e6d4769b0c0d
	 */
	private String remarks;
	/**
	 * 状态（true：可用，false：不可用）
	 * 
	 * @pdOid 61363d8a-ae26-44b3-8636-fae66e572260
	 */
	private boolean status;

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}