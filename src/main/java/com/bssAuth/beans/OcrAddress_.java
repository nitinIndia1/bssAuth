package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class OcrAddress_ implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@NotBlank(message = "address can not be blank")
	
	private String address;
	
	@NotBlank(message = "token can not be blank")
	private String token;
	

	private String alternateNumber;
	
	
	private String email;
	
	
	
	public OcrAddress_() {}
	
	
	public String getAlternateNumber() {
		return alternateNumber;
	}


	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public OcrAddress_(String address) {
		this.address=address;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
	
	

}
