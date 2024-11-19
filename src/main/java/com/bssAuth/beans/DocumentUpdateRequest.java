package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class DocumentUpdateRequest implements Serializable{

	private static final long serialVersionUID = -5494425619014566476L;
	@NotBlank(message="documentName can not be blank")
	private String documentName;
	@NotBlank(message="image can not be blank")
	private String image;
	@NotBlank(message="token can not be blank")
	private String token;
	
public DocumentUpdateRequest(String documentName, String image, String token) {
		this.documentName = documentName;
		this.image = image;
		this.token = token;
	}

public DocumentUpdateRequest() {
	
}




public String getDocumentName() {
	return documentName;
}

public void setDocumentName(String documentName) {
	this.documentName = documentName;
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
