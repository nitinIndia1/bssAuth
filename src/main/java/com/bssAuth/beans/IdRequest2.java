package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class IdRequest2 implements Serializable{

	private static final long serialVersionUID = -5494425616814566476L;
	private String docname;
	@NotBlank(message="image can not be blank")
	private String image;
	@NotBlank(message="token can not be blank")
	private String token;
	
public IdRequest2() {
	
}

public IdRequest2(String docname, String image, String token) {
	this.docname = docname;
	this.image = image;
	this.token = token;
}

public String getDocname() {
	return docname;
}

public void setDocname(String docname) {
	this.docname = docname;
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
