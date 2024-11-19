package com.bssAuth.beans;

import java.io.Serializable;
import java.util.List;

import com.bssAuth.model.CustomerDetail;
import com.bssAuth.model.Employee;

public class AdminActivationData_ implements Serializable{

	private static final long serialVersionUID = -7024546341521812410L;
	private String activationStatus;
	private String adminType;
	private String adminMsisdn;
	private String adminName;
	private String employeeAlternate;
	private String employeeMsisdn;
	private Employee employee;
	private String activationDate;
	private List<DocumentDetail> documentList;
	private String documentId;
	private String otpStatus;
	private String employeeType;
	private String employeeIDType;
	private String passportIssueDate;
	private String passportExpiryDate;
	private String passportFromDate;
	private String passportToDate;
	public AdminActivationData_() {
		
	}
	public String getActivationStatus() {
		return activationStatus;
	}
	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}
	public String getAdminType() {
		return adminType;
	}
	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}
	public String getAdminMsisdn() {
		return adminMsisdn;
	}
	public void setAdminMsisdn(String adminMsisdn) {
		this.adminMsisdn = adminMsisdn;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getEmployeeAlternate() {
		return employeeAlternate;
	}
	public void setEmployeeAlternate(String employeeAlternate) {
		this.employeeAlternate = employeeAlternate;
	}
	public String getEmployeeMsisdn() {
		return employeeMsisdn;
	}
	public void setEmployeeMsisdn(String employeeMsisdn) {
		this.employeeMsisdn = employeeMsisdn;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getActivationDate() {
		return activationDate;
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
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getEmployeeIDType() {
		return employeeIDType;
	}
	public void setEmployeeIDType(String employeeIDType) {
		this.employeeIDType = employeeIDType;
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


	
}
