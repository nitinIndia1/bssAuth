package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class OrganisationSaveDetail implements Serializable{


	private static final long serialVersionUID = 6330391234600915112L;

	@NotBlank(message="organisationName can not be blank")
	private String organisationName;
	@NotBlank(message="organisationAddress can not be blank")
	private String organisationAddress;
//	@NotBlank(message="incorporationLetter64 can not be blank")
//	private String incorporationLetter64;
//	@NotBlank(message="vat64 can not be blank")
//	private String vat64;
//	@NotBlank(message="brn64 can not be blank")
//	private String brn64;
//	@NotBlank(message="utilityBill64 can not be blank")
//	private String utilityBill64;
	//@NotBlank(message="adminToken can not be blank")
	private String adminToken;
	
	//@NotBlank(message="orgContact can not be blank")
	private String orgContact;
	
	//@NotBlank(message="orgEmail can not be blank")
	private String orgEmail;
	
	@NotBlank(message="acctId can not be blank")
	private String acctId;
	//@NotBlank(message="brn can not be blank")
	private String brn;
	//@NotBlank(message="vat can not be blank")
	private String vat;
	//@NotBlank(message="orgType can not be blank")
	private String orgType; // tourism,tourOperator
	
	private String certificateNumber;
	private String expiryDate;
	
	
	
	OrganisationSaveDetail(){}


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








	public String getBrn() {
		return brn;
	}


	public void setBrn(String brn) {
		this.brn = brn;
	}


	public String getVat() {
		return vat;
	}


	public void setVat(String vat) {
		this.vat = vat;
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


	public String getAcctId() {
		return acctId;
	}


	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}


	public String getOrgEmail() {
		return orgEmail;
	}


	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}


	public String getOrgType() {
		return orgType;
	}


	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}


	public String getCertificateNumber() {
		return certificateNumber;
	}


	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	@Override
	public String toString() {
		return "OrganisationSaveDetail [organisationName=" + organisationName + ", organisationAddress="
				+ organisationAddress + ", adminToken=" + adminToken + ", orgContact=" + orgContact + ", orgEmail="
				+ orgEmail + ", acctId=" + acctId + ", brn=" + brn + ", vat=" + vat + ", orgType=" + orgType + "]";
	}



	
	
	
	
}
