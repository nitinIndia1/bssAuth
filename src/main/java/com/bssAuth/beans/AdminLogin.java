package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class AdminLogin implements Serializable {

	private static final long serialVersionUID = -7491336403488733069L;
	
	
	@NotBlank(message = "username can not be blank")
	
private String username;
	@NotBlank(message = "password can not be blank")
	
private String password;
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



}
