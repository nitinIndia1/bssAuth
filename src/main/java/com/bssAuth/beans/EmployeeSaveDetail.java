package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class EmployeeSaveDetail implements Serializable{


	private static final long serialVersionUID = 6330391234600915112L;

	@NotBlank(message="organisationName can not be blank")
	private String organisationName;
	@NotBlank(message="organisationAddress can not be blank")
	private String organisationAddress;
	@NotBlank(message="incorporationLetter64 can not be blank")
	private String incorporationLetter64;
	@NotBlank(message="vat64 can not be blank")
	private String vat64;
	@NotBlank(message="brn64 can not be blank")
	private String brn64;
	@NotBlank(message="utilityBill64 can not be blank")
	private String utilityBill64;
	@NotBlank(message="adminToken can not be blank")
	private String adminToken;
	
	@NotBlank(message="orgContact can not be blank")
	private String orgContact;
	
	@NotBlank(message="orgEmail can not be blank")
	private String orgEmail;
	
	
	
	EmployeeSaveDetail(){}


	public String getOrganisationName() {
		return organisationName;
	}


	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}


	public String getOrganisationAddress() {
		return organisationAddress;
	}


	public void setOrganisationAddress(String organisationAddress) {
		this.organisationAddress = organisationAddress;
	}





	public String getIncorporationLetter64() {
		return incorporationLetter64;
	}


	public void setIncorporationLetter64(String incorporationLetter64) {
		this.incorporationLetter64 = incorporationLetter64;
	}


	public String getVat64() {
		return vat64;
	}


	public void setVat64(String vat64) {
		this.vat64 = vat64;
	}


	public String getBrn64() {
		return brn64;
	}


	public void setBrn64(String brn64) {
		this.brn64 = brn64;
	}


	public String getUtilityBill64() {
		return utilityBill64;
	}


	public void setUtilityBill64(String utilityBill64) {
		this.utilityBill64 = utilityBill64;
	}


	public String getAdminToken() {
		return adminToken;
	}


	public void setAdminToken(String adminToken) {
		this.adminToken = adminToken;
	}


	public String getOrgContact() {
		return orgContact;
	}


	public void setOrgContact(String orgContact) {
		this.orgContact = orgContact;
	}


	public String getOrgEmail() {
		return orgEmail;
	}


	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}


	@Override
	public String toString() {
		return "OrganisationSaveDetail [organisationName=" + organisationName + ", organisationAddress="
				+ organisationAddress + ", incorporationLetter64=" + incorporationLetter64 + ", vat64=" + vat64
				+ ", brn64=" + brn64 + ", utilityBill64=" + utilityBill64 + ", adminToken=" + adminToken
				+ ", orgContact=" + orgContact + ", orgEmail=" + orgEmail + "]";
	}
	
	
	
	
}
