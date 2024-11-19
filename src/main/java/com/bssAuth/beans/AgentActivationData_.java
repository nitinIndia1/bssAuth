package com.bssAuth.beans;

import java.io.Serializable;
import java.util.List;

import com.bssAuth.model.CustomerDetail;
import com.bssAuth.model.Employee;

public class AgentActivationData_ implements Serializable{

	private static final long serialVersionUID = -7024546341521812410L;
	private String activationStatus;
	private String dealerType;
	private String dealerMsisdn;
	private String dealerName;
	private String customerAlternate;
	private String customerMsisdn;
	private CustomerDetail customerDetail;
	private String activationDate;
	private List<DocumentDetail> documentList;
	private String documentId;
	private String otpStatus;
	private String customerType;
	private String customerIDType;
	private String passportIssueDate;
	private String passportExpiryDate;
	private String passportFromDate;
	private String passportToDate;
	public AgentActivationData_() {
		
	}


	public AgentActivationData_(String activationStatus, String dealerType, String dealerMsisdn, String dealerName,
			String customerAlternate, String customerMsisdn) {
		this.activationStatus = activationStatus;
		this.dealerType = dealerType;
		this.dealerMsisdn = dealerMsisdn;
		this.dealerName = dealerName;
		this.customerAlternate = customerAlternate;
		this.customerMsisdn = customerMsisdn;
	}


	public String getActivationDate() {
		return activationDate;
	}


	public String getCustomerType() {
		return customerType;
	}


	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}


	public String getCustomerIDType() {
		return customerIDType;
	}


	public void setCustomerIDType(String customerIDType) {
		this.customerIDType = customerIDType;
	}


	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}


	public List<DocumentDetail> getDocumentList() {
		return documentList;
	}


	public void setDocumentList(List<DocumentDetail> documentList) {
		this.documentList = documentList;
	}


	public String getDocumentId() {
		return documentId;
	}


	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}


	public String getOtpStatus() {
		return otpStatus;
	}


	public void setOtpStatus(String otpStatus) {
		this.otpStatus = otpStatus;
	}


	public String getActivationStatus() {
		return activationStatus;
	}


	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}


	public String getDealerType() {
		return dealerType;
	}


	public void setDealerType(String dealerType) {
		this.dealerType = dealerType;
	}


	public String getDealerMsisdn() {
		return dealerMsisdn;
	}


	public void setDealerMsisdn(String dealerMsisdn) {
		this.dealerMsisdn = dealerMsisdn;
	}


	public String getDealerName() {
		return dealerName;
	}


	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}


	public String getCustomerAlternate() {
		return customerAlternate;
	}


	public void setCustomerAlternate(String customerAlternate) {
		this.customerAlternate = customerAlternate;
	}


	public String getCustomerMsisdn() {
		return customerMsisdn;
	}


	public void setCustomerMsisdn(String customerMsisdn) {
		this.customerMsisdn = customerMsisdn;
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


	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}


	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}


	@Override
	public String toString() {
		return "AgentActivationData_ [activationStatus=" + activationStatus + ", dealerType=" + dealerType
				+ ", dealerMsisdn=" + dealerMsisdn + ", dealerName=" + dealerName + ", customerAlternate="
				+ customerAlternate + ", customerMsisdn=" + customerMsisdn + ", customerDetail=" + customerDetail
				+ ", activationDate=" + activationDate + ", documentList=" + documentList + ", documentId=" + documentId
				+ ", otpStatus=" + otpStatus + ", customerType=" + customerType + ", customerIDType=" + customerIDType
				+ ", passportIssueDate=" + passportIssueDate + ", passportExpiryDate=" + passportExpiryDate
				+ ", passportFromDate=" + passportFromDate + ", passportToDate=" + passportToDate + "]";
	}
	
	
	
	
}
