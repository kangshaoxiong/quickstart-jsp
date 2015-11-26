package com.my.quickstart.entity;

import java.util.Date;

import com.my.quickstart.base.BaseEntity;

/***********************************************************************
 * Module:  LoginHistory.java
 * Author:  Alan
 * Purpose: Defines the Class LoginHistory
 ***********************************************************************/

/**
 * 登陆记录表
 * 
 * @pdOid 07000bc5-ba3d-424f-bf5c-2985f830267d
 */
public class LoginHistory extends BaseEntity {
	private static final long serialVersionUID = -5361140228719877143L;
	/**
	 * 登陆信息(账号、邮箱、手机等)
	 * 
	 * @pdOid 787ba47f-40c3-47c4-ab51-282cb1ef4c95
	 */
	private String loginInfo;
	/**
	 * 登陆IP
	 * 
	 * @pdOid de21155d-b720-43f3-ad8c-92deee1560c0
	 */
	private String loginIp;
	/**
	 * 登陆时间
	 * 
	 * @pdOid 8e4fea40-5538-4cf2-9c04-9e6f027556d3
	 */
	private Date loginTime;
	/**
	 * IP所在省
	 * 
	 * @pdOid 9b899101-f9da-4fbc-9649-fb4d43597ed0
	 */
	private String province;
	/**
	 * IP所在市
	 * 
	 * @pdOid deb3c5a9-63ab-4da1-9ca2-596e6bdbcb48
	 */
	private String city;
	/**
	 * IP所在区
	 * 
	 * @pdOid 2f01e49f-ba06-4389-9d6b-634e87700ed9
	 */
	private String district;
	/**
	 * 退出时间
	 * 
	 * @pdOid fc710741-42fd-47e3-aac4-948f2afd8f3d
	 */
	private Date logoutTime;
	/**
	 * 登陆时长(分)
	 * 
	 * @pdOid 5113dd28-dbc0-4b29-aced-8d1b1fef8c7f
	 */
	private int timeLength;
	/**
	 * 退出类型(1:主动退出，2:会话过期)
	 * 
	 * @pdOid b16d67f2-4b36-45f6-8d13-b8f3d0751363
	 */
	private short logoutType;

	public String getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(String loginInfo) {
		this.loginInfo = loginInfo;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public int getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(int timeLength) {
		this.timeLength = timeLength;
	}

	public short getLogoutType() {
		return logoutType;
	}

	public void setLogoutType(short logoutType) {
		this.logoutType = logoutType;
	}
}