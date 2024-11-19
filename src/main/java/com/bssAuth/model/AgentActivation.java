package com.bssAuth.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="agent_activation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AgentActivation implements Serializable{

	private static final long serialVersionUID = -1063681769561911527L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "agent_id" , nullable = false)
	private String agentId;

	@Column(name="customer_id",nullable = false)
	
	private String customerId;

	@Column(name="activation_status", nullable = false)
	
	private String activationStatus;

	@Column(name="activation_date", nullable = false)
	private String activationDate;

	@Column(name="kyc_status", nullable = false)
	private String kycStatus;

	private String Remarks;
	
	public AgentActivation() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public AgentActivation(int id, String agentId, String customerId, String activationStatus, String activationDate,
			String kycStatus, String remarks) {
		this.id = id;
		this.agentId = agentId;
		this.customerId = customerId;
		this.activationStatus = activationStatus;
		this.activationDate = activationDate;
		this.kycStatus = kycStatus;
		Remarks = remarks;
	}

	@Override
	public String toString() {
		return "AgentActivation [id=" + id + ", agentId=" + agentId + ", customerId=" + customerId
				+ ", activationStatus=" + activationStatus + ", activationDate=" + activationDate + ", kycStatus="
				+ kycStatus + ", Remarks=" + Remarks + "]";
	}


	
}
