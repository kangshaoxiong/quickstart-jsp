package com.my.quickstart.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 数据源实体类
 * @author Administrator
 *
 */
@Component
@ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
public class DataSourceProperties{
	public static final String PREFIX = "primarys.datasource";
	private String driverClassName ;
	private String url;
	private String username;
	private String password;
	private int maxActive;
	private int maxIdle;
	private int minIdle;
	private boolean defaultAutoCommit;
	
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	public int getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	public int getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	public boolean isDefaultAutoCommit() {
		return defaultAutoCommit;
	}
	public void setDefaultAutoCommit(boolean defaultAutoCommit) {
		this.defaultAutoCommit = defaultAutoCommit;
	}
}
