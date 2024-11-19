package com.bssAuth.beans;

import java.io.Serializable;

public class Image_ implements Serializable{

	private static final long serialVersionUID = 1L;
	private String imgType;
	private String base64;
	
	private String token;
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
