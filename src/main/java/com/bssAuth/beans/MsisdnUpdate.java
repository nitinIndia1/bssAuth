package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class MsisdnUpdate implements Serializable{


	private static final long serialVersionUID = -2894727132533567128L;
	@NotBlank(message="msisdn can not be blank")
	private String msisdn;
	@NotBlank(message="token can not be blank")
	private String token;
	
	@NotBlank(message="newCustomer can not be blank")
	private String newCustomer;
	
	@NotBlank(message="recharge type can not be blank")
	private String rechargeType;
	
	//@NotBlank(message="iccid can not be blank")
	private String iccid;
	
	
	
	public MsisdnUpdate() {}

	public MsisdnUpdate(String msisdn, String token,String newCustomer) {
		this.msisdn = msisdn;
		this.token = token;
		this.newCustomer=newCustomer;
	}

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

	
	
	public String getNewCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(String newCustomer) {
		this.newCustomer = newCustomer;
	}
	

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	@Override
	public String toString() {
		return "MsisdnUpdate [msisdn=" + msisdn + ", token=" + token + ", newCustomer=" + newCustomer
				+ ", rechargeType=" + rechargeType + ", iccid=" + iccid + "]";
	}


	
	
	
	
}
