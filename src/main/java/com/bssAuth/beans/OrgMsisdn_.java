package com.bssAuth.beans;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;

public class OrgMsisdn_ implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@NotBlank(message="acctId can not be blank")
	
	private String acctId;
	@NotNull(message="msisdns can not be blank")
	
	private List<String> msisdns;
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public List<String> getMsisdns() {
		return msisdns;
	}
	public void setMsisdns(List<String> msisdns) {
		this.msisdns = msisdns;
	}
	
	
	
	
}
