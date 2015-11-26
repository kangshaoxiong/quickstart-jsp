package com.my.quickstart.entity;

/***********************************************************************
 * Module:  UserAccountRelatedGroup.java
 * Author:   Alan
 * Purpose: Defines the Class UserAccountRelatedGroup
 ***********************************************************************/

/**
 * 用户关联用户组表
 * 
 * @pdOid b71de334-4c71-4520-80a3-490ae97ac6cc
 */
public class UserAccountRelatedGroup {
	/**
	 * 用户登陆表主键
	 * 
	 * @pdOid aa7f4382-27ea-4b09-a657-446e9723374b
	 */
	private Long userAccountId;
	/**
	 * 用户组表主键
	 * 
	 * @pdOid aad283a2-600b-4062-9732-ffb76521ee15
	 */
	private Long userGroupId;

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}
}