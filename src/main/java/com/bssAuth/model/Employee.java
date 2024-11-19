package com.bssAuth.model;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	@Column(name="alternate_number")
	private String alternateNumber;

	@Column(name="contingency_error_code")
	private String contingencyErrorCode;

	
	@Column(name="correlation_id")
	private String correlationId;

	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	
	@Column(name="id_type")
	private String idType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="create_date")	
	private Date createDate;

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

	@Column(name="new_customer")
	private String newCustomer;

	@Column(name="original_doc_id")
	private String originalDocId;

	@Column(name="other_doc_count")
	private String otherDocCount;

	@Column(name="permit_value")
	private String permitValue;

	private String pmUid;

	private String remarks;

	@Column(name="resident_type")
	private String residentType;

	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name="update_date")	
	private Date updateDate;

	//bi-directional many-to-one association to Document
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="document_id")
	private Document document;

	//bi-directional many-to-one association to Image
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="image_id")
	private Image image;

	//bi-directional many-to-one association to Organisation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="organisation_id")
	
	private Organisation organisation;

	//bi-directional many-to-one association to SimDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sim_id")
	private SimDetail simDetail;

	
	
	@Column(name="passport_date_issued")	
	
	private String passportDateIssued;

	@Column(name="passport_date_expired")
	private String passportDateExpired;

	@Column(name="passport_date_from")
	private String passportDateFrom;

	@Column(name="passport_date_to")
	private String passportDateTo;
	
	
	
	public Employee() {
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

	public String getAlternateNumber() {
		return this.alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getContingencyErrorCode() {
		return this.contingencyErrorCode;
	}

	public void setContingencyErrorCode(String contingencyErrorCode) {
		this.contingencyErrorCode = contingencyErrorCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public String getNewCustomer() {
		return this.newCustomer;
	}

	public void setNewCustomer(String newCustomer) {
		this.newCustomer = newCustomer;
	}

	public String getOriginalDocId() {
		return this.originalDocId;
	}

	public void setOriginalDocId(String originalDocId) {
		this.originalDocId = originalDocId;
	}

	public String getOtherDocCount() {
		return this.otherDocCount;
	}

	public void setOtherDocCount(String otherDocCount) {
		this.otherDocCount = otherDocCount;
	}

	public String getPermitValue() {
		return this.permitValue;
	}

	public void setPermitValue(String permitValue) {
		this.permitValue = permitValue;
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

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public SimDetail getSimDetail() {
		return this.simDetail;
	}

	public void setSimDetail(SimDetail simDetail) {
		this.simDetail = simDetail;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", address=" + address + ", alternateNumber=" + alternateNumber
				+ ", contingencyErrorCode=" + contingencyErrorCode + ", correlationId=" + correlationId + ", dob=" + dob
				+ ", idType=" + idType + ", createDate=" + createDate + ", email=" + email + ", firstName=" + firstName
				+ ", gender=" + gender + ", kycStatus=" + kycStatus + ", lastName=" + lastName + ", maidenName="
				+ maidenName + ", nationality=" + nationality + ", newCustomer=" + newCustomer + ", originalDocId="
				+ originalDocId + ", otherDocCount=" + otherDocCount + ", permitValue=" + permitValue + ", pmUid="
				+ pmUid + ", remarks=" + remarks + ", residentType=" + residentType + ", token=" + token
				+ ", updateDate=" + updateDate + ", document=" + document + ", image=" + image + ", organisation="
				+ organisation + ", simDetail=" + simDetail + "]";
	}
	
	
	

}