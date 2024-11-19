package com.bssAuth.beans;

import java.io.Serializable;

public class AgentLogin implements Serializable{

	private static final long serialVersionUID = 6188727200792158428L;

	
	private String userName;
	private String password;
	
	public AgentLogin() {}

	public AgentLogin(String userName, String password) {
		this.userName = userName;
		this.password = password;
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

	@Override
	public String toString() {
		return "AgentLogin [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
