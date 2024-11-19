package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class AgentActivation_ implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7566771475657654990L;
	@NotBlank(message = "token can not be blank")
	private String token;
	@NotBlank(message = "agentnumber can not be blank")
	private String agentnumber;
	@NotBlank(message = "date can not be blank")
	
	private String date;
	@NotBlank(message = "kyc_status can not be blank")
	
	private String kyc_status;
	@NotBlank(message = "activation_status can not be blank")
	
	private String activation_status;
	
	private String type;
	
	public AgentActivation_() {
		
	}


	public AgentActivation_(String token, String agentnumber, String date, String kyc_status,
			String activation_status) {
		this.token = token;
		this.agentnumber = agentnumber;
		this.date = date;
		this.kyc_status = kyc_status;
		this.activation_status = activation_status;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getAgentnumber() {
		return agentnumber;
	}


	public void setAgentnumber(String agentnumber) {
		this.agentnumber = agentnumber;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getKyc_status() {
		return kyc_status;
	}


	public void setKyc_status(String kyc_status) {
		this.kyc_status = kyc_status;
	}


	public String getActivation_status() {
		return activation_status;
	}


	public void setActivation_status(String activation_status) {
		this.activation_status = activation_status;
	}


	@Override
	public String toString() {
		return "AgentActivation_ [token=" + token + ", agentnumber=" + agentnumber + ", date=" + date + ", kyc_status="
				+ kyc_status + ", activation_status=" + activation_status + "]";
	}


	
	
	
}
