package com.bssAuth.beans;

import java.io.Serializable;

public class VerifyMLRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private String image;
	private String nimage;
	private String name;
	private String id;
	private String utype;
	
	public VerifyMLRequest() {}
	
	
	public VerifyMLRequest(String image, String nimage, String name, String id, String utype) {
		this.image = image;
		this.nimage = nimage;
		this.name = name;
		this.id = id;
		this.utype = utype;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNimage() {
		return nimage;
	}
	public void setNimage(String nimage) {
		this.nimage = nimage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	
}
