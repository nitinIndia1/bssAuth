package com.bssAuth.model;

import java.io.Serializable;

//import jakarta.persistence.*;
//import jakarta.persistence.*;
//import jakarta.persistence.*;
//import jakarta.persistence.*;
//import jakarta.persistence.*;
//import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="admin_activation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdminActivation implements Serializable{

	private static final long serialVersionUID = -1062681769561911527L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "admin_id" , nullable = false)
	private String adminId;

	@Column(name="employee_id",nullable = false)
	
	private String employeeId;

	@Column(name="activation_status", nullable = false)
	
	private String activationStatus;

	@Column(name="activation_date", nullable = false)
	private String activationDate;

	@Column(name="kyc_status", nullable = false)
	private String kycStatus;

	
	private String Remarks;
	
	public AdminActivation() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}

	public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

	public String getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	@Override
	public String toString() {
		return "AdminActivation [id=" + id + ", adminId=" + adminId + ", employeeId=" + employeeId
				+ ", activationStatus=" + activationStatus + ", activationDate=" + activationDate + ", kycStatus="
				+ kycStatus + ", Remarks=" + Remarks + "]";
	}

	
}
