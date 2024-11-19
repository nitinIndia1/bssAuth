package com.bssAuth.model;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * OtpDetail generated by hbm2java
 */




@Entity
@Table(name="otp_detail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OtpDetail implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer id;
	private String msisdn;
	private String otp;
	private Date otpValidity;
	private String mpin;
	private String isActive;
	private String token;
	public OtpDetail() {
	}

	public OtpDetail(String msisdn, String otp, Date otpValidity, String isActive) {
		this.msisdn = msisdn;
		this.otp = otp;
		this.otpValidity = otpValidity;
		this.isActive = isActive;
	}

	public OtpDetail(String msisdn, String otp, Date otpValidity, String mpin, String isActive) {
		this.msisdn = msisdn;
		this.otp = otp;
		this.otpValidity = otpValidity;
		this.mpin = mpin;
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "msisdn", unique = true, nullable = false, length = 45)
	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	@Column(name = "otp", nullable = false, length = 45)
	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "otp_validity", nullable = false)
	
	//@Column(name = "otp_validity", columnDefinition = "TIMESTAMP")

	public Date getOtpValidity() {
		return this.otpValidity;
	}

	public void setOtpValidity(Date otpValidity) {
		this.otpValidity = otpValidity;
	}

	@Column(name = "mpin", length = 10)
	public String getMpin() {
		return this.mpin;
	}

	public void setMpin(String mpin) {
		this.mpin = mpin;
	}

	@Column(name = "isActive", nullable = false, length = 45)
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Column(name = "token")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "OtpDetail [id=" + id + ", msisdn=" + msisdn + ", otp=" + otp + ", otpValidity=" + otpValidity
				+ ", mpin=" + mpin + ", isActive=" + isActive + ", token=" + token + "]";
	}

	
	
}

