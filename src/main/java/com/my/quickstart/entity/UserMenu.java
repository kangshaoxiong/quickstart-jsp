package com.my.quickstart.entity;

import com.my.quickstart.base.BaseEntity;

/***********************************************************************
 * Module:  UserMenu.java
 * Author:   Alan
 * Purpose: Defines the Class UserMenu
 ***********************************************************************/

/**
 * 用户菜单表
 * 
 * @pdOid f348c4c4-1cca-4336-ad14-aac6cae028fc
 */
public class UserMenu extends BaseEntity {
	private static final long serialVersionUID = 8058656620845556539L;
	/**
	 * 名称
	 * 
	 * @pdOid ca05f1ca-ce9a-42ef-b563-99552d94ba0f
	 */
	private String name;
	/**
	 * 级别(0:根节点，1、2、3)
	 * 
	 * @pdOid 698cafeb-5cb8-4854-a5c1-52894567d6fe
	 */
	private short level;
	/**
	 * 父节点
	 * 
	 * @pdOid 9d173c98-af41-464a-a177-f9cd422cdf24
	 */
	private Long parentId;
	/**
	 * 状态(true:可用,false:不可用)
	 * 
	 * @pdOid de5446ce-604d-4157-992f-6cdd5bac4bc9
	 */
	private boolean status;
	/**
	 * 是否可访问(true:有访问链接,false:无访问链接)
	 * 
	 * @pdOid 8b5b8d6e-bc99-4d07-bd02-02a6bbffa4ff
	 */
	private boolean isCanVisit;
	/**
	 * 访问链接(菜单对应的访问url)
	 * 
	 * @pdOid bfb43af6-dca5-43f5-8571-41ad1e8243b5
	 */
	private String visitUrl;
	/**
	 * 是否展开子节点(true:子节点展开,false:子节点合并)
	 * 
	 * @pdOid 3a6600a7-daaf-4112-b9a0-f9d24f79a929
	 */
	private boolean isSpread;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getLevel() {
		return level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isCanVisit() {
		return isCanVisit;
	}

	public void setCanVisit(boolean isCanVisit) {
		this.isCanVisit = isCanVisit;
	}

	public String getVisitUrl() {
		return visitUrl;
	}

	public void setVisitUrl(String visitUrl) {
		this.visitUrl = visitUrl;
	}

	public boolean isSpread() {
		return isSpread;
	}

	public void setSpread(boolean isSpread) {
		this.isSpread = isSpread;
	}
}