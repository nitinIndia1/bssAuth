package com.bssAuth.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class EkycActivate implements Serializable{


	private static final long serialVersionUID = 898414850912913372L;


	private String ekycId;
	private String idDocId;
	private String address;
	private String createTime;
	private String firstName;
	private String maidenName;
	private String lastName;
	private String gender;
	private String dob;
	private String nationality;
	private String rechargeType;
	private String userType;
	private String residentType;
	private String token;
	//private String kycPhotoUrl;
	private String originalPhotoUrl;
	//private String thumbPhotoUrl;
	//private String verifiedPhotoUrl;
	private String status;
	//private String[] allOtherDocumentUrls;
	private String msisdn;
	private String remark;
	private String email;
	//private String self;
	//===============================================================
private String city;
	
	private String countryCode;

	private int invoiceChild;
	
	private int isParent;
	
	private Double monthlyLimit;
	
	private int nextInvoiceDayOfPeriod;
	
	private LocalDate nextInoviceDate;
	
	private String invoiceDesign;
	
	private int notificationInclude;
	
	private int parentId;
	
	private String personInitial;
	
	private String personTitle;
	
	private Double rechargeThreshold;
	
	private int referralFeePaid;
	
	private int partnerId;
	
	private String electricityMeterId;
	
	
	private String serviceType;
	
	private String deviceId;
	
	//===============================================================
	public EkycActivate(String ekycId, String idDocId, String address, String createTime, String firstName,
			String maidenName, String lastName, String gender, String dob, String nationality, String rechargeType,
			String userType, String residentType, String token, String originalPhotoUrl, String msisdn,String remark,String status) {
		this.ekycId = ekycId;
		this.idDocId = idDocId;
		this.address = address;
		this.createTime = createTime;
		this.firstName = firstName;
		this.maidenName = maidenName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.nationality = nationality;
		this.rechargeType = rechargeType;
		this.userType = userType;
		this.residentType = residentType;
		this.token = token;
		this.originalPhotoUrl = originalPhotoUrl;
		this.msisdn = msisdn;
		this.remark=remark;
		this.status=status;
	}
	public EkycActivate() {
	}
	public String getEkycId() {
		return ekycId;
	}
	public void setEkycId(String ekycId) {
		this.ekycId = ekycId;
	}
	public String getIdDocId() {
		return idDocId;
	}
	public void setIdDocId(String idDocId) {
		this.idDocId = idDocId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMaidenName() {
		return maidenName;
	}
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
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
	public String getResidentType() {
		return residentType;
	}
	public void setResidentType(String residentType) {
		this.residentType = residentType;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOriginalPhotoUrl() {
		return originalPhotoUrl;
	}
	public void setOriginalPhotoUrl(String originalPhotoUrl) {
		this.originalPhotoUrl = originalPhotoUrl;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	
	
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getInvoiceChild() {
		return invoiceChild;
	}
	public void setInvoiceChild(int invoiceChild) {
		this.invoiceChild = invoiceChild;
	}
	public int getIsParent() {
		return isParent;
	}
	public void setIsParent(int isParent) {
		this.isParent = isParent;
	}
	public Double getMonthlyLimit() {
		return monthlyLimit;
	}
	public void setMonthlyLimit(Double monthlyLimit) {
		this.monthlyLimit = monthlyLimit;
	}
	public int getNextInvoiceDayOfPeriod() {
		return nextInvoiceDayOfPeriod;
	}
	public void setNextInvoiceDayOfPeriod(int nextInvoiceDayOfPeriod) {
		this.nextInvoiceDayOfPeriod = nextInvoiceDayOfPeriod;
	}
	public LocalDate getNextInoviceDate() {
		return nextInoviceDate;
	}
	public void setNextInoviceDate(LocalDate nextInoviceDate) {
		this.nextInoviceDate = nextInoviceDate;
	}
	public String getInvoiceDesign() {
		return invoiceDesign;
	}
	public void setInvoiceDesign(String invoiceDesign) {
		this.invoiceDesign = invoiceDesign;
	}
	public int getNotificationInclude() {
		return notificationInclude;
	}
	public void setNotificationInclude(int notificationInclude) {
		this.notificationInclude = notificationInclude;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getPersonInitial() {
		return personInitial;
	}
	public void setPersonInitial(String personInitial) {
		this.personInitial = personInitial;
	}
	public String getPersonTitle() {
		return personTitle;
	}
	public void setPersonTitle(String personTitle) {
		this.personTitle = personTitle;
	}
	public Double getRechargeThreshold() {
		return rechargeThreshold;
	}
	public void setRechargeThreshold(Double rechargeThreshold) {
		this.rechargeThreshold = rechargeThreshold;
	}
	public int getReferralFeePaid() {
		return referralFeePaid;
	}
	public void setReferralFeePaid(int referralFeePaid) {
		this.referralFeePaid = referralFeePaid;
	}
	public int getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	public String getElectricityMeterId() {
		return electricityMeterId;
	}
	public void setElectricityMeterId(String electricityMeterId) {
		this.electricityMeterId = electricityMeterId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	//	public String getSelf() {
//		return self;
//	}
//	public void setSelf(String self) {
//		this.self = self;
//	}
	@Override
	public String toString() {
		return "{\"ekycId\":\"" + ekycId + "\", \"idDocId\":\"" + idDocId + "\", \"address\":\"" + address
				+ "\", \"createTime\":\"" + createTime + "\", \"firstName\":\"" + firstName + "\", \"maidenName\":\""
				+ maidenName + "\", \"lastName\":\"" + lastName + "\", \"gender\":\"" + gender + "\", \"dob\":\"" + dob
				+ "\", \"nationality\":\"" + nationality + "\", \"rechargeType\":\"" + rechargeType
				+ "\", \"userType\":\"" + userType + "\", \"residentType\":\"" + residentType + "\", \"token\":\""
				+ token + "\", \"originalPhotoUrl\":\"" + originalPhotoUrl + "\", \"status\":\"" + status
				+ "\", \"msisdn\":\"" + msisdn + "\", \"remark\":\"" + remark + "\", \"email\":\"" + email
				+ "\", \"city\":\"" + city + "\", \"countryCode\":\"" + countryCode + "\", \"invoiceChild\":\""
				+ invoiceChild + "\", \"isParent\":\"" + isParent + "\", \"monthlyLimit\":\"" + monthlyLimit
				+ "\", \"nextInvoiceDayOfPeriod\":\"" + nextInvoiceDayOfPeriod + "\", \"nextInoviceDate\":\""
				+ nextInoviceDate + "\", \"invoiceDesign\":\"" + invoiceDesign + "\", \"notificationInclude\":\""
				+ notificationInclude + "\", \"parentId\":\"" + parentId + "\", \"personInitial\":\"" + personInitial
				+ "\", \"personTitle\":\"" + personTitle + "\", \"rechargeThreshold\":\"" + rechargeThreshold
				+ "\", \"referralFeePaid\":\"" + referralFeePaid + "\", \"partnerId\":\"" + partnerId
				+ "\", \"electricityMeterId\":\"" + electricityMeterId + "\", \"serviceType\":\"" + serviceType
				+ "\", \"deviceId\":\"" + deviceId + "\"}";
	}

	

	
	
	
	


	
	
	

}
