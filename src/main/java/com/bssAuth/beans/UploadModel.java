package com.bssAuth.beans;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2315656765504759438L;

	private String nid;
	private String address;
	
	
	
	public UploadModel() {}



	public UploadModel(String nid, String address) {
		this.nid = nid;
		this.address = address;
	}



	public String getNid() {
		return nid;
	}



	public void setNid(String nid) {
		this.nid = nid;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	
	
}
