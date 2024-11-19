package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the organisation database table.
 * 
 */

@Entity
@Table(name="organisation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Organisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	

	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name="create_date")	
	private Date createDate;

	
	@Column(name="org_pin")
	private String orgPin;

	@Column(name="org_token")
	private String orgToken;

	@Column(name="organisation_name")
	private String organisationName;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name="update_date")	
	private Date updateDate;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="admin")
	private CustomerDetail admin;
		
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="document")
	private Document document;
	
	
	
	
	private String active;
	
	@Column(name="acc_nbr")	
	private String contact;
	@Column(name="email")	
	private String email;

	@Column(name="acct_id")
	private String acctId;
	@Column(name="brn")
	private String brn;
	@Column(name="vat")
	private String vat;
	
	@Column(name="org_type")
	private String orgType;
	
	@Column(name="admin_user_name")
	
	private String adminUserName;
	@Column(name="admin_password")
	
	private String adminPassword;
	
	
	@Column(name="tourist_cert_number")
	
	private String touristCertificateNumber;
	@Column(name="expiry_date")
	
	private String expiryDate;
	public Organisation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getOrgPin() {
		return this.orgPin;
	}

	public void setOrgPin(String orgPin) {
		this.orgPin = orgPin;
	}

	public String getOrgToken() {
		return this.orgToken;
	}

	public void setOrgToken(String orgToken) {
		this.orgToken = orgToken;
	}

	public String getOrganisationName() {
		return this.organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	

	public CustomerDetail getAdmin() {
		return admin;
	}

	public void setAdmin(CustomerDetail admin) {
		this.admin = admin;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
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

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getTouristCertificateNumber() {
		return touristCertificateNumber;
	}

	public void setTouristCertificateNumber(String touristCertificateNumber) {
		this.touristCertificateNumber = touristCertificateNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Organisation [id=" + id + ", address=" + address + ", createDate=" + createDate + ", orgPin=" + orgPin
				+ ", orgToken=" + orgToken + ", organisationName=" + organisationName + ", status=" + status
				+ ", updateDate=" + updateDate + ", admin=" + admin + ", document=" + document + ", active=" + active
				+ ", contact=" + contact + ", email=" + email + ", acctId=" + acctId + ", brn=" + brn + ", vat=" + vat
				+ ", orgType=" + orgType + ", adminUserName=" + adminUserName + ", adminPassword=" + adminPassword
				+ ", touristCertificateNumber=" + touristCertificateNumber + ", expiryDate=" + expiryDate + "]";
	}





}