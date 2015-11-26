package com.my.quickstart.entity;

/***********************************************************************
 * Module:  UserGroupRelatedAuthority.java
 * Author:   Alan
 * Purpose: Defines the Class UserGroupRelatedAuthority
 ***********************************************************************/

/**
 * 用户组关联权限表
 * 
 * @pdOid 590e217b-1352-4b3d-9803-590941fb7578
 */
public class UserGroupRelatedAuthority{
	/**
	 * 用户组表主键
	 * 
	 * @pdOid 333b05f3-c8d1-4ec4-8a83-18be81e97d49
	 */
	private Long userGroupId;
	/**
	 * 权限表主键
	 * 
	 * @pdOid 0e979d00-9cd0-46d7-b3ea-92af26db3762
	 */
	private Long userAuthorityId;

	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	public Long getUserAuthorityId() {
		return userAuthorityId;
	}

	public void setUserAuthorityId(Long userAuthorityId) {
		this.userAuthorityId = userAuthorityId;
	}
}