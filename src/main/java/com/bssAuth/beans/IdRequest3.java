package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class IdRequest3 implements Serializable{

	private static final long serialVersionUID = -5494425614414566476L;
	@NotBlank(message="image can not be blank")
	private String image;
	@NotBlank(message="token can not be blank")
	private String token;
	
public IdRequest3() {
	
}

public IdRequest3(String image, String token) {
	this.image = image;
	this.token = token;
}



public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}


	
}
