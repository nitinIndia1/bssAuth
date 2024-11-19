package com.bssAuth.beans;

import java.io.Serializable;

public class AdminSave implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2913457615176990439L;

	
	private String userName;
	private String password;
	
	public AdminSave() {
		
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
		return "AdminSave [userName=" + userName + "]";
	}
	
	
	
}
