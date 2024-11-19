package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class SimCase implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotBlank(message="msisdn can not be blank")
	String msisdn;
	@NotBlank(message="simCase can not be blank")
	
	String simCase;
	@NotBlank(message="id64 can not be blank")
	
	String id64;
	@NotBlank(message="doc64 can not be blank")
	
	String doc64;
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getSimCase() {
		return simCase;
	}
	public void setSimCase(String simCase) {
		this.simCase = simCase;
	}
	public String getId64() {
		return id64;
	}
	public void setId64(String id64) {
		this.id64 = id64;
	}
	public String getDoc64() {
		return doc64;
	}
	public void setDoc64(String doc64) {
		this.doc64 = doc64;
	}
	
	
	
	
}
