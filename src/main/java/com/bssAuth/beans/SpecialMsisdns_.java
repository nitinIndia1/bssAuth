package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class SpecialMsisdns_ implements Serializable{

	private static final long serialVersionUID = -7133990940120663216L;
	@NotBlank(message = "msisdnPrefix can not be blank")
	private String msisdnPrefix;
	@NotBlank(message = "msisdnLength can not be blank")
	private String msisdnLength;
	public SpecialMsisdns_() {}
	public SpecialMsisdns_(String msisdnPrefix, String msisdnLength) {
		this.msisdnPrefix = msisdnPrefix;
		this.msisdnLength = msisdnLength;
	}
	public String getMsisdnPrefix() {
		return msisdnPrefix;
	}
	public void setMsisdnPrefix(String msisdnPrefix) {
		this.msisdnPrefix = msisdnPrefix;
	}
	public String getMsisdnLength() {
		return msisdnLength;
	}
	public void setMsisdnLength(String msisdnLength) {
		this.msisdnLength = msisdnLength;
	}
	@Override
	public String toString() {
		return "SpecialMsisdns_ [msisdnPrefix=" + msisdnPrefix + ", msisdnLength=" + msisdnLength + "]";
	}
	
	
}
