package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class VerifyMsisdnSpecial implements Serializable{


	private static final long serialVersionUID = -5804967026465636114L;

	@NotBlank(message = "msisdn can not be blank")
	
	private String msisdn;
	
	public VerifyMsisdnSpecial() {}
	
	public VerifyMsisdnSpecial(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Override
	public String toString() {
		return "VerifyMsisdnSpecial [msisdn=" + msisdn + "]";
	}
	
}
