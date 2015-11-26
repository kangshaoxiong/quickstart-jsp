package com.my.quickstart.entity;

/***********************************************************************
 * Module:  UserAccountRelatedMenu.java
 * Author:   Alan
 * Purpose: Defines the Class UserAccountRelatedMenu
 ***********************************************************************/

/**
 * 用户关联菜单表
 * 
 * @pdOid daab77e7-97ab-4973-9c45-d5c079c05044
 */
public class UserAccountRelatedMenu {
	/**
	 * 用户ID
	 * 
	 * @pdOid ac08875f-d060-4001-97e8-1f42c7358bd8
	 */
	private Long userAccountId;
	/**
	 * 用户菜单ID
	 * 
	 * @pdOid 1a596521-3709-4471-9ecb-8c0f20d99708
	 */
	private Long userMenuId;

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public Long getUserMenuId() {
		return userMenuId;
	}

	public void setUserMenuId(Long userMenuId) {
		this.userMenuId = userMenuId;
	}

}