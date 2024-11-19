package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the customer_details database table.
 * 
 */
@Entity
@Table(name="customer_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerDetail implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	public CustomerDetail() {}


	public CustomerDetail(String firstName,  String lastName, String token, 
			String id, String kycStatus) {
		this.firstName = firstName;
		//this.maidenName = maidenName;
		this.lastName = lastName;
		this.token = token;
	//	this.updateDate = updateDate;
		this.id = id;
		this.kycStatus = kycStatus;
	}

	public CustomerDetail(int customerId, Date applicationDate, String correlationId, String customerActiveStatus,
			Date dob, String email, String firstName, String gender, String kycStatus, String lastName,
			String maidenName, String nationality, String pmUid, String remarks, String residentType, Document document,
			Image image, SimDetail simDetail, String token, String id, Date createDate, Date updateDate, String address,
			String otherDocCount, String newCustomer, String alternateNumber) {
		this.customerId = customerId;
		this.applicationDate = applicationDate;
		this.correlationId = correlationId;
		this.customerActiveStatus = customerActiveStatus;
		this.dob = dob;
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.kycStatus = kycStatus;
		this.lastName = lastName;
		this.maidenName = maidenName;
		this.nationality = nationality;
		this.pmUid = pmUid;
		this.remarks = remarks;
		this.residentType = residentType;
		this.document = document;
		this.image = image;
		this.simDetail = simDetail;
		this.token = token;
		this.id = id;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.address = address;
		this.otherDocCount = otherDocCount;
		this.newCustomer = newCustomer;
		this.alternateNumber = alternateNumber;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name="application_date")
	private Date applicationDate;

	@Column(name="correlation_id")
	private String correlationId;

	@Column(name="customer_active_status")
	private String customerActiveStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dob;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="kyc_status")
	private String kycStatus;

	@Column(name="last_name")
	private String lastName;

	@Column(name="maiden_name")
	private String maidenName;

	private String nationality;

	private String pmUid;

	private String remarks;

	@Column(name="resident_type")
	private String residentType;

	
	@Column(name="recharge_type")
	private String rechargeType;

	
	@Column(name="user_type")
	private String userType;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="document_id")
//	@Column(name="document_id")
	private Document document;


	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="image_id")
//	@Column(name="image_id")
	private Image image;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sim_id")
//	@Column(name="sim_id")
	private SimDetail simDetail;


	
	private String token;
	private String id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="create_date")	
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="update_date")
	private Date updateDate;
	
	private String address;
	
	@Column(name="other_doc_count")
	private String otherDocCount;
	
	@Column(name="new_customer")
	private String newCustomer;
	@Column(name="alternate_number")	
	private String alternateNumber;
	@Column(name="permit_value")	
	private String permitValue;
	
	@Column(name="contingency_error_code")	
	private String contingencyErrorCode;
	
	
	@Column(name="passport_date_issued")	
	
	private String passportDateIssued;

	@Column(name="passport_date_expired")
	private String passportDateExpired;

	@Column(name="passport_date_from")
	private String passportDateFrom;

	@Column(name="passport_date_to")
	private String passportDateTo;
	
	
	@Column(name="crm_info")
	private String crmInfo;
	
	@Column(name="self")
	private String self;
	//===================================
	@Column(name="id_type")
	private String idType;
	
	@Column(name="locality")
	private String locality;
	
	public Date getCreateDate() {
		return createDate;
	}




	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}




	public Date getUpdateDate() {
		return updateDate;
	}




	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}




	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getCorrelationId() {
		return this.correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getCustomerActiveStatus() {
		return this.customerActiveStatus;
	}

	public void setCustomerActiveStatus(String customerActiveStatus) {
		this.customerActiveStatus = customerActiveStatus;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getKycStatus() {
		return this.kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaidenName() {
		return this.maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPmUid() {
		return this.pmUid;
	}

	public void setPmUid(String pmUid) {
		this.pmUid = pmUid;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getResidentType() {
		return this.residentType;
	}

	public void setResidentType(String residentType) {
		this.residentType = residentType;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public SimDetail getSimDetail() {
		return this.simDetail;
	}

	public void setSimDetail(SimDetail simDetail) {
		this.simDetail = simDetail;
	}

	
	
	
	
	public String getAlternateNumber() {
		return alternateNumber;
	}




	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}




	public String getToken() {
		return token;
	}




	public void setToken(String token) {
		this.token = token;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}


	public String getOtherDocCount() {
		return otherDocCount;
	}




	public void setOtherDocCount(String otherDocCount) {
		this.otherDocCount = otherDocCount;
	}










	public String getNewCustomer() {
		return newCustomer;
	}




	public void setNewCustomer(String newCustomer) {
		this.newCustomer = newCustomer;
	}




	public String getPermitValue() {
		return permitValue;
	}






	public void setPermitValue(String permitValue) {
		this.permitValue = permitValue;
	}






	public String getContingencyErrorCode() {
		return contingencyErrorCode;
	}






	public void setContingencyErrorCode(String contingencyErrorCode) {
		this.contingencyErrorCode = contingencyErrorCode;
	}






	public String getPassportDateIssued() {
		return passportDateIssued;
	}






	public void setPassportDateIssued(String passportDateIssued) {
		this.passportDateIssued = passportDateIssued;
	}






	public String getPassportDateExpired() {
		return passportDateExpired;
	}






	public void setPassportDateExpired(String passportDateExpired) {
		this.passportDateExpired = passportDateExpired;
	}






	public String getPassportDateFrom() {
		return passportDateFrom;
	}






	public void setPassportDateFrom(String passportDateFrom) {
		this.passportDateFrom = passportDateFrom;
	}






	public String getPassportDateTo() {
		return passportDateTo;
	}






	public void setPassportDateTo(String passportDateTo) {
		this.passportDateTo = passportDateTo;
	}






	public String getCrmInfo() {
		return crmInfo;
	}


	public void setCrmInfo(String crmInfo) {
		this.crmInfo = crmInfo;
	}


	public String getRechargeType() {
		return rechargeType;
	}


	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getSelf() {
		return self;
	}


	public void setSelf(String self) {
		this.self = self;
	}


	public String getIdType() {
		return idType;
	}


	public void setIdType(String idType) {
		this.idType = idType;
	}


	public String getLocality() {
		return locality;
	}


	public void setLocality(String locality) {
		this.locality = locality;
	}


	@Override
	public String toString() {
		return "CustomerDetail [customerId=" + customerId + ", applicationDate=" + applicationDate + ", correlationId="
				+ correlationId + ", customerActiveStatus=" + customerActiveStatus + ", dob=" + dob + ", email=" + email
				+ ", firstName=" + firstName + ", gender=" + gender + ", kycStatus=" + kycStatus + ", lastName="
				+ lastName + ", maidenName=" + maidenName + ", nationality=" + nationality + ", pmUid=" + pmUid
				+ ", remarks=" + remarks + ", residentType=" + residentType + ", rechargeType=" + rechargeType
				+ ", userType=" + userType + ", document=" + document + ", image=" + image + ", simDetail=" + simDetail
				+ ", token=" + token + ", id=" + id + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", address=" + address + ", otherDocCount=" + otherDocCount + ", newCustomer=" + newCustomer
				+ ", alternateNumber=" + alternateNumber + ", permitValue=" + permitValue + ", contingencyErrorCode="
				+ contingencyErrorCode + ", passportDateIssued=" + passportDateIssued + ", passportDateExpired="
				+ passportDateExpired + ", passportDateFrom=" + passportDateFrom + ", passportDateTo=" + passportDateTo
				+ ", crmInfo=" + crmInfo + ", self=" + self + "]";
	}





	











	

}