package com.bssAuth.beans;

import java.io.Serializable;

public class SimPassportResponse implements Serializable{


	private static final long serialVersionUID = 1L;

	
	private String correlationId;
	private String firstName;
	private String maidenName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String passportNum;
	private String nationalityCode;
	private String dateIssued;
	private String dateExpired;
	private String dateFrom;
	private String dateTo;
	private String pmUid;
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassportNum() {
		return passportNum;
	}
	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}
	public String getNationalityCode() {
		return nationalityCode;
	}
	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}
	public String getDateIssued() {
		return dateIssued;
	}
	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}
	public String getDateExpired() {
		return dateExpired;
	}
	public void setDateExpired(String dateExpired) {
		this.dateExpired = dateExpired;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getPmUid() {
		return pmUid;
	}
	public void setPmUid(String pmUid) {
		this.pmUid = pmUid;
	}
	@Override
	public String toString() {
		return "SimPassportResponse [correlationId=" + correlationId + ", firstName=" + firstName + ", maidenName="
				+ maidenName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", passportNum=" + passportNum + ", nationalityCode=" + nationalityCode + ", dateIssued=" + dateIssued
				+ ", dateExpired=" + dateExpired + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", pmUid=" + pmUid
				+ "]";
	}

	
	


}
