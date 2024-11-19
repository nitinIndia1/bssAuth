package com.bssAuth.beans;

import java.io.Serializable;

public class DocumentDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5888214208275588529L;

	
	private String docName;
	private String docImage;
	private String docImage_url;
	
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocImage() {
		return docImage;
	}
	public void setDocImage(String docImage) {
		this.docImage = docImage;
	}
	
	public DocumentDetail() {}
	public DocumentDetail(String docName, String docImage) {
		this.docName = docName;
		this.docImage = docImage;
	}
	public String getDocImage_url() {
		return docImage_url;
	}
	public void setDocImage_url(String docImage_url) {
		this.docImage_url = docImage_url;
	}
	
	
	
	
	
}
