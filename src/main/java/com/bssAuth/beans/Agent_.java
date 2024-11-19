package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

//import javax.validation.constraints.NotBlank;

public class Agent_ implements Serializable{


	private static final long serialVersionUID = 7873714074568375457L;

	@NotBlank(message="agentId can not be blank")
	private String agentId;
	@NotBlank(message="agentName can not be blank")
	private String agentName;
	@NotBlank(message="businessName can not be blank")
	private String businessName;
	@NotBlank(message="type can not be blank")
	private String type;
	@NotBlank(message="userName can not be blank")
	private String userName;
	@NotBlank(message="password can not be blank")
	private String password;
	
	@NotBlank(message="msisdn can not be blank")
	private String msisdn;
	
	
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Agent_() {}
	
	@Override
	public String toString() {
		return "Agent_ [agentId=" + agentId + ", agentName=" + agentName + ", businessName=" + businessName + ", type="
				+ type + ", userName=" + userName + ", password=" + password + ", msisdn=" + msisdn + "]";
	}
	
	
	
	
}
