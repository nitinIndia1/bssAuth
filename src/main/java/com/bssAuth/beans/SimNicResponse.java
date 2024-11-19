package com.bssAuth.beans;

import java.io.Serializable;

public class SimNicResponse implements Serializable{


	private static final long serialVersionUID = 1L;

	
	private String correlationId;
	private String firstName;
	private String maidenName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String nicNum;
	private String photograph;
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
	public String getNicNum() {
		return nicNum;
	}
	public void setNicNum(String nicNum) {
		this.nicNum = nicNum;
	}
	public String getPhotograph() {
		return photograph;
	}
	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}
	@Override
	public String toString() {
		return "SimNicResponse [correlationId=" + correlationId + ", firstName=" + firstName + ", maidenName="
				+ maidenName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", nicNum=" + nicNum + ", photograph=" + photograph + "]";
	}




}
