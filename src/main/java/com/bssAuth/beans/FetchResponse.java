package com.bssAuth.beans;

import java.io.Serializable;
import java.util.List;

import org.json.simple.JSONObject;

import com.bssAuth.model.Agent;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchResponse implements Serializable{

	private static final long serialVersionUID = 6588856400248094301L;

	private String ApplicationId;
	private String FullName;
	
	private String Nationality;
	
	private String UserType;
	
	private String DocumentType;
	private String DocumentId;
	private String DateOfBirth;
	private String Gender;
	private String OriginalPhoto;
	private String eKYCPhoto;
	private String verifiedPhoto;
	
	private String OriginalPhoto_url;
	private String eKYCPhoto_url;
	private String verifiedPhoto_url;
	private String thumb_impression_url;
	
	private String pmUid;
	
	private SIMDetails SIMDetails;
	
	// S I M   D E T A I L S   o b j     I S    S T A T I C    R I G H T    N O W
//    "SIMDetails": {
//        "MSISDN": "218961239",
//        "IMSI": "23712381231293",
//        "Status": "Activated"
//    }
	
	
	private String ApplicationDate;
	private String ApplicationMode;
	private String Status;
	private String correlation_id;
	private String token;
	
	private String email;
	private String alternateNumber;
	private String newCustomer;
	private String permitValue;
	private String address;
	private Agent agent;
	private String agentMsisdn;
	private List<DocumentDetail> documentDetailList;
	
	
	private String passportIssueDate;
	private String passportExpiryDate;
	private String passportFromDate;
	private String passportToDate;
	
	private String rechargeType;
	
	
	private String customerOrAgent;
	
	
	private JSONObject crmInfo;
	
	public String getCustomerOrAgent() {
		return customerOrAgent;
	}


















	public void setCustomerOrAgent(String customerOrAgent) {
		this.customerOrAgent = customerOrAgent;
	}


















	public FetchResponse() {}


















	public FetchResponse(String applicationId, String fullName, String nationality, String userType,
			String documentType, String documentId, String dateOfBirth, String gender, String originalPhoto,
			String eKYCPhoto, String verifiedPhoto, com.bssAuth.beans.SIMDetails sIMDetails, String applicationDate,
			String applicationMode, String status, String correlation_id, String token,
			List<DocumentDetail> documentDetailList) {
		ApplicationId = applicationId;
		FullName = fullName;
		Nationality = nationality;
		UserType = userType;
		DocumentType = documentType;
		DocumentId = documentId;
		DateOfBirth = dateOfBirth;
		Gender = gender;
		OriginalPhoto = originalPhoto;
		this.eKYCPhoto = eKYCPhoto;
		this.verifiedPhoto = verifiedPhoto;
		SIMDetails = sIMDetails;
		ApplicationDate = applicationDate;
		ApplicationMode = applicationMode;
		Status = status;
		this.correlation_id = correlation_id;
		this.token = token;
		this.documentDetailList = documentDetailList;
	}


















	public String getRechargeType() {
		return rechargeType;
	}


















	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}


















	public String getPmUid() {
		return pmUid;
	}


















	public void setPmUid(String pmUid) {
		this.pmUid = pmUid;
	}


















	@JsonProperty("ApplicationId")
	
	public String getApplicationId() {
		return ApplicationId;
	}


	public void setApplicationId(String applicationId) {
		ApplicationId = applicationId;
	}

	@JsonProperty("FullName")
	
	public String getFullName() {
		return FullName;
	}


	public void setFullName(String fullName) {
		FullName = fullName;
	}


	@JsonProperty("Nationality")
	public String getNationality() {
		return Nationality;
	}


	public void setNationality(String nationality) {
		Nationality = nationality;
	}


	@JsonProperty("UserType")
	public String getUserType() {
		return UserType;
	}


	public void setUserType(String userType) {
		UserType = userType;
	}


	@JsonProperty("DocumentType")
	public String getDocumentType() {
		return DocumentType;
	}


	public void setDocumentType(String documentType) {
		DocumentType = documentType;
	}

	@JsonProperty("DocumentId")
	
	public String getDocumentId() {
		return DocumentId;
	}


	public void setDocumentId(String documentId) {
		DocumentId = documentId;
	}

	@JsonProperty("Date Of Birth")
	
	public String getDateOfBirth() {
		return DateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	@JsonProperty("Gender")
	

	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}

	@JsonProperty("OriginalPhoto")
	

	public String getOriginalPhoto() {
		return OriginalPhoto;
	}


	public void setOriginalPhoto(String originalPhoto) {
		OriginalPhoto = originalPhoto;
	}


	@JsonProperty("eKYCPhoto")
	
	public String geteKYCPhoto() {
		return eKYCPhoto;
	}


	public void seteKYCPhoto(String eKYCPhoto) {
		this.eKYCPhoto = eKYCPhoto;
	}

	@JsonProperty("ApplicationDate")
	
	public String getApplicationDate() {
		return ApplicationDate;
	}


	public void setApplicationDate(String applicationDate) {
		ApplicationDate = applicationDate;
	}


	@JsonProperty("ApplicationMode")
	public String getApplicationMode() {
		return ApplicationMode;
	}


	public void setApplicationMode(String applicationMode) {
		ApplicationMode = applicationMode;
	}


	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	@JsonProperty("SIMDetails")
	public SIMDetails getSIMDetails() {
		return SIMDetails;
	}





	public void setSIMDetails(SIMDetails sIMDetails) {
		SIMDetails = sIMDetails;
	}





	public String getVerifiedPhoto() {
		return verifiedPhoto;
	}









	public void setVerifiedPhoto(String verifiedPhoto) {
		this.verifiedPhoto = verifiedPhoto;
	}









	public String getCorrelation_id() {
		return correlation_id;
	}









	public void setCorrelation_id(String correlation_id) {
		this.correlation_id = correlation_id;
	}









	public String getToken() {
		return token;
	}









	public void setToken(String token) {
		this.token = token;
	}









	public List<DocumentDetail> getDocumentDetailList() {
		return documentDetailList;
	}


















	public void setDocumentDetailList(List<DocumentDetail> documentDetailList) {
		this.documentDetailList = documentDetailList;
	}


















	public String getEmail() {
		return email;
	}


















	public void setEmail(String email) {
		this.email = email;
	}


















	public String getAgentMsisdn() {
		return agentMsisdn;
	}


















	public String getPassportIssueDate() {
		return passportIssueDate;
	}


















	public void setPassportIssueDate(String passportIssueDate) {
		this.passportIssueDate = passportIssueDate;
	}


















	public String getPassportExpiryDate() {
		return passportExpiryDate;
	}


















	public void setPassportExpiryDate(String passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}


















	public String getPassportFromDate() {
		return passportFromDate;
	}


















	public void setPassportFromDate(String passportFromDate) {
		this.passportFromDate = passportFromDate;
	}


















	public String getPassportToDate() {
		return passportToDate;
	}


















	public void setPassportToDate(String passportToDate) {
		this.passportToDate = passportToDate;
	}


















	public void setAgentMsisdn(String agentMsisdn) {
		this.agentMsisdn = agentMsisdn;
	}


















	public String getAlternateNumber() {
		return alternateNumber;
	}


















	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}


















	public String getNewCustomer() {
		return newCustomer;
	}


















	public void setNewCustomer(String newCustomer) {
		this.newCustomer = newCustomer;
	}


















	public Agent getAgent() {
		return agent;
	}


















	public void setAgent(Agent agent) {
		this.agent = agent;
	}


















	public String getPermitValue() {
		return permitValue;
	}


















	public void setPermitValue(String permitValue) {
		this.permitValue = permitValue;
	}


















	public String getAddress() {
		return address;
	}


















	public void setAddress(String address) {
		this.address = address;
	}


















	public String getOriginalPhoto_url() {
		return OriginalPhoto_url;
	}


















	public void setOriginalPhoto_url(String originalPhoto_url) {
		OriginalPhoto_url = originalPhoto_url;
	}


















	public String geteKYCPhoto_url() {
		return eKYCPhoto_url;
	}


















	public void seteKYCPhoto_url(String eKYCPhoto_url) {
		this.eKYCPhoto_url = eKYCPhoto_url;
	}


















	public String getVerifiedPhoto_url() {
		return verifiedPhoto_url;
	}


















	public void setVerifiedPhoto_url(String verifiedPhoto_url) {
		this.verifiedPhoto_url = verifiedPhoto_url;
	}


















	public String getThumb_impression_url() {
		return thumb_impression_url;
	}


















	public void setThumb_impression_url(String thumb_impression_url) {
		this.thumb_impression_url = thumb_impression_url;
	}


















	public JSONObject getCrmInfo() {
		return crmInfo;
	}


















	public void setCrmInfo(JSONObject crmInfo) {
		this.crmInfo = crmInfo;
	}


















	@Override
	public String toString() {
		return "FetchResponse [ApplicationId=" + ApplicationId + ", FullName=" + FullName + ", Nationality="
				+ Nationality + ", UserType=" + UserType + ", DocumentType=" + DocumentType + ", DocumentId="
				+ DocumentId + ", DateOfBirth=" + DateOfBirth + ", Gender=" + Gender + ", OriginalPhoto="
				+ OriginalPhoto + ", eKYCPhoto=" + eKYCPhoto + ", verifiedPhoto=" + verifiedPhoto
				+ ", OriginalPhoto_url=" + OriginalPhoto_url + ", eKYCPhoto_url=" + eKYCPhoto_url
				+ ", verifiedPhoto_url=" + verifiedPhoto_url + ", thumb_impression_url=" + thumb_impression_url
				+ ", pmUid=" + pmUid + ", SIMDetails=" + SIMDetails + ", ApplicationDate=" + ApplicationDate
				+ ", ApplicationMode=" + ApplicationMode + ", Status=" + Status + ", correlation_id=" + correlation_id
				+ ", token=" + token + ", email=" + email + ", alternateNumber=" + alternateNumber + ", newCustomer="
				+ newCustomer + ", permitValue=" + permitValue + ", address=" + address + ", agent=" + agent
				+ ", agentMsisdn=" + agentMsisdn + ", documentDetailList=" + documentDetailList + ", passportIssueDate="
				+ passportIssueDate + ", passportExpiryDate=" + passportExpiryDate + ", passportFromDate="
				+ passportFromDate + ", passportToDate=" + passportToDate + ", rechargeType=" + rechargeType
				+ ", customerOrAgent=" + customerOrAgent + ", crmInfo=" + crmInfo + "]";
	}





















		
}
