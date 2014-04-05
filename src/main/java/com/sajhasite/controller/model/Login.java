package com.sajhasite.controller.model;

public class Login {
	private String loginId;
	private String password;
	
	public Login() {
		this(null, null);
	}

	public Login(String loginId, String password) {
		this.loginId = loginId;
		this.password = password;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
