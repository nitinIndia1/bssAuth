package com.bssAuth.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class ExtraInfo implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -441139257026491429L;

private String city;
	
	private String countryCode;

	private int invoiceChild;
	
	private int isParent;
	
	private Double monthlyLimit;
	
	private int nextInvoiceDayOfPeriod;
	
	//private LocalDate nextInoviceDate;
	
	private String invoiceDesign;
	
	private int notificationInclude;
	
	private int parentId;
	
	private String personInitial;
	
	private String personTitle;
	
	private Double rechargeThreshold;
	
	private int referralFeePaid;
	
	private int partnerId;
	
	private String electricityMeterId;

	private String msisdn;
	private String rechargeType;
	
	private String serviceType;
	
	private String deviceId;
	
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

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "{\"city\":\"" + city + "\", \"countryCode\":\"" + countryCode + "\", \"invoiceChild\":\"" + invoiceChild
				+ "\", \"isParent\":\"" + isParent + "\", \"monthlyLimit\":\"" + monthlyLimit
				+ "\", \"nextInvoiceDayOfPeriod\":\"" + nextInvoiceDayOfPeriod + "\", \"invoiceDesign\":\""
				+ invoiceDesign + "\", \"notificationInclude\":\"" + notificationInclude + "\", \"parentId\":\""
				+ parentId + "\", \"personInitial\":\"" + personInitial + "\", \"personTitle\":\"" + personTitle
				+ "\", \"rechargeThreshold\":\"" + rechargeThreshold + "\", \"referralFeePaid\":\"" + referralFeePaid
				+ "\", \"partnerId\":\"" + partnerId + "\", \"electricityMeterId\":\"" + electricityMeterId
				+ "\", \"msisdn\":\"" + msisdn + "\", \"rechargeType\":\"" + rechargeType + "\", \"serviceType\":\""
				+ serviceType + "\", \"deviceId\":\"" + deviceId + "\"}";
	}

	



	
	
	
	
}
