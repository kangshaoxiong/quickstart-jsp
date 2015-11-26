package com.my.quickstart.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.my.quickstart.base.BaseEntity;

/**
 * 登录账户实体
 * 
 * @author Alan
 * 
 */
@Entity(name = "t_user_account")
public class UserAccount extends BaseEntity implements UserDetails {
	private static final long serialVersionUID = 6536556384760133181L;
	@Column(nullable = false)
	@NotBlank
	private String username;// 用户账号
	@Column(nullable = false)
	private String nickname;// 昵称
	private String password;// 密码
	private String mobile;// 绑定登录手机
	private String email;// 绑定登录邮箱
	private String qq;// 绑定登录qq
	/**
	 * 最后登陆时间
	 */
	private Date lastLandTime;
	/**
	 * 最后登陆IP
	 */
	private String lastLandIp;
	private boolean isAccountNonExpired; // 用户账号是否过期
	private boolean isAccountNonLocked; // 用户账号是否被锁定
	private boolean isCredentialsNonExpired; // 用户密码是否过期
	private boolean isEnabled; // 用户是否可用

	// 不和数据库做映射关系
	@Transient
	private String plainPassword;// 明文密码

	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> grants = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
				"ROLE_USER");
		SimpleGrantedAuthority authority1 = new SimpleGrantedAuthority(
				"ROLE_WELCOME");
		grants.add(authority);
		grants.add(authority1);
		return grants;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Date getLastLandTime() {
		return lastLandTime;
	}

	public void setLastLandTime(Date lastLandTime) {
		this.lastLandTime = lastLandTime;
	}

	public String getLastLandIp() {
		return lastLandIp;
	}

	public void setLastLandIp(String lastLandIp) {
		this.lastLandIp = lastLandIp;
	}
	
}
