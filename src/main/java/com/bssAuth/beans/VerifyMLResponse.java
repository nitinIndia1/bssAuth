package com.bssAuth.beans;

import java.io.Serializable;

public class VerifyMLResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String id;
	private String image;
	private boolean match_status;
	private String name;
	private String usertype;
	public VerifyMLResponse() {}
	
	public VerifyMLResponse(String id, String image, boolean match_status, String name, String usertype) {
		this.id = id;
		this.image = image;
		this.match_status = match_status;
		this.name = name;
		this.usertype = usertype;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isMatch_status() {
		return match_status;
	}
	public void setMatch_status(boolean match_status) {
		this.match_status = match_status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
}
