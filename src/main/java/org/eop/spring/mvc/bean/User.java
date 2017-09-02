package org.eop.spring.mvc.bean;

import java.util.Date;

/**
 * @author lixinjie
 * @since 2017-08-19
 */
public class User {

	private Long id;
	private String userName;
	private String password;
	private Date registerTime;
	
	public User() {
		
	}
	
	public User(Long id, String userName, String password, Date registerTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", registerTime=" + registerTime
				+ "]";
	}
	
}
