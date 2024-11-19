package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;

public class EmployeeOrganisationMsisdn_ implements Serializable{


	private static final long serialVersionUID = -6285100132107609094L;

	//@NotBlank(message="empId can not be blank")
	@NotNull(message = "empToken can not be null")
	
	private String empToken;
	//@NotBlank(message="orgId can not be blank")
	@NotNull(message = "orgToken can not be null")
	
	private String orgToken;
	@NotBlank(message="msisdn can not be blank")
	
	private String msisdn;
	public String getEmpToken() {
		return empToken;
	}
	public void setEmpToken(String empToken) {
		this.empToken = empToken;
	}
	public String getOrgToken() {
		return orgToken;
	}
	public void setOrgToken(String orgToken) {
		this.orgToken = orgToken;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	
	
	
}
