package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class StatusUpdate implements Serializable{


	private static final long serialVersionUID = -2894727132533567128L;
	@NotBlank(message="status can not be blank")
	private String status;
	@NotBlank(message="token can not be blank")
	private String token;
	@NotBlank(message="type can not be blank")
	private String type;
	public StatusUpdate() {}

	public StatusUpdate(String status, String token) {
		this.status = status;
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "StatusUpdate [status=" + status + ", token=" + token + ", type=" + type + "]";
	}
	
	
	
	
	
}
