package com.bssAuth.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="agent")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Agent implements Serializable{
	private static final long serialVersionUID = -3782308232772973625L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="agent_Name",nullable = false)
	private String agentName;
	@Column(nullable = false)
	private String msisdn;
	@Column(name="agent_ID", nullable = false)
	private String agentID;
	@Column(name="agent_type",nullable = false)
	private String agentType;
	@Column(name="agent_business_name", nullable = false)
	private String agentBusinessName;
	@Column(nullable = false)
	private String otp;
	@Column(nullable = false)
	private String mpin;
	@Column(name="is_otpconsumed",nullable = false)
	
	private String isOtpconsumed;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name="otp_createdate", nullable = false)
	private Date otpCreatedate;

	@Column(name="user_name",unique = true)
	private String userName;
	private String password;
	
	public Agent() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getAgentBusinessName() {
		return agentBusinessName;
	}

	public void setAgentBusinessName(String agentBusinessName) {
		this.agentBusinessName = agentBusinessName;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getMpin() {
		return mpin;
	}

	public void setMpin(String mpin) {
		this.mpin = mpin;
	}

	public String getIsOtpconsumed() {
		return isOtpconsumed;
	}

	public void setIsOtpconsumed(String isOtpconsumed) {
		this.isOtpconsumed = isOtpconsumed;
	}

	public Date getOtpCreatedate() {
		return otpCreatedate;
	}

	public void setOtpCreatedate(Date otpCreatedate) {
		this.otpCreatedate = otpCreatedate;
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

	public Agent(int id, String agentName, String msisdn, String agentID, String agentType, String agentBusinessName,
			String otp, String mpin, String isOtpconsumed, Date otpCreatedate, String userName, String password) {
		this.id = id;
		this.agentName = agentName;
		this.msisdn = msisdn;
		this.agentID = agentID;
		this.agentType = agentType;
		this.agentBusinessName = agentBusinessName;
		this.otp = otp;
		this.mpin = mpin;
		this.isOtpconsumed = isOtpconsumed;
		this.otpCreatedate = otpCreatedate;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", agentName=" + agentName + ", msisdn=" + msisdn + ", agentID=" + agentID
				+ ", agentType=" + agentType + ", agentBusinessName=" + agentBusinessName + ", otp=" + otp + ", mpin="
				+ mpin + ", isOtpconsumed=" + isOtpconsumed + ", otpCreatedate=" + otpCreatedate + ", userName="
				+ userName + ", password=" + password + "]";
	}





}
