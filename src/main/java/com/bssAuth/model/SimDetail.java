package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the sim_details database table.
 * 
 */
@Entity
@Table(name="sim_details")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SimDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	public SimDetail() {
	}

	public SimDetail(int simId, String crmResponse, String imsi, String isCrmUpdated, String isSimProvisioned,
			String isActive, String msisdn, String simProvResponse) {
		this.simId = simId;
		this.crmResponse = crmResponse;
		this.imsi = imsi;
		this.isCrmUpdated = isCrmUpdated;
		this.isSimProvisioned = isSimProvisioned;
		this.isActive = isActive;
		this.msisdn = msisdn;
		this.simProvResponse = simProvResponse;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sim_id")
	private int simId;

	@Column(name="crm_response")
	private String crmResponse;

	private String imsi;

	@Column(name="is_crm_updated")
	private String isCrmUpdated;

	@Column(name="is_sim_provisioned")
	private String isSimProvisioned;

	private String isActive;

	private String msisdn;

	@Column(name="sim_prov_response")
	private String simProvResponse;



	public int getSimId() {
		return this.simId;
	}

	public void setSimId(int simId) {
		this.simId = simId;
	}

	public String getCrmResponse() {
		return this.crmResponse;
	}

	public void setCrmResponse(String crmResponse) {
		this.crmResponse = crmResponse;
	}

	public String getImsi() {
		return this.imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getIsCrmUpdated() {
		return this.isCrmUpdated;
	}

	public void setIsCrmUpdated(String isCrmUpdated) {
		this.isCrmUpdated = isCrmUpdated;
	}

	public String getIsSimProvisioned() {
		return this.isSimProvisioned;
	}

	public void setIsSimProvisioned(String isSimProvisioned) {
		this.isSimProvisioned = isSimProvisioned;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getSimProvResponse() {
		return this.simProvResponse;
	}

	public void setSimProvResponse(String simProvResponse) {
		this.simProvResponse = simProvResponse;
	}

	@Override
	public String toString() {
		return "SimDetail [simId=" + simId + ", crmResponse=" + crmResponse + ", imsi=" + imsi + ", isCrmUpdated="
				+ isCrmUpdated + ", isSimProvisioned=" + isSimProvisioned + ", isActive=" + isActive + ", msisdn="
				+ msisdn + ", simProvResponse=" + simProvResponse + "]";
	}

	

}