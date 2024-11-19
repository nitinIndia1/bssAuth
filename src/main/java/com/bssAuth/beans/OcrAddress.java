package com.bssAuth.beans;

import java.io.Serializable;

public class OcrAddress implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String address;
	
	public OcrAddress() {}
	
	
	public OcrAddress(String address) {
		this.address=address;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
