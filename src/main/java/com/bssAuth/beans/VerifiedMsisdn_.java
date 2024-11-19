package com.bssAuth.beans;

import java.io.Serializable;

import com.bssAuth.model.SimDetail;

public class VerifiedMsisdn_ implements Serializable{

	private static final long serialVersionUID = -6843237639060837259L;

	
	private String msisdn;
	private String token;
	private SimDetail simDetail;
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public SimDetail getSimDetail() {
		return simDetail;
	}
	public void setSimDetail(SimDetail simDetail) {
		this.simDetail = simDetail;
	}
	
}
