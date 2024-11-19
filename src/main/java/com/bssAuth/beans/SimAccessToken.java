package com.bssAuth.beans;

import java.io.Serializable;

public class SimAccessToken implements Serializable{

	private static final long serialVersionUID = 1L;
	private String accessToken;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
}
