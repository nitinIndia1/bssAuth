package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class OcrId implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "countryCode can not be blank")
	private String countryCode;
	@NotBlank(message = "dob can not be blank")
	private String dob;
	//@NotBlank(message = "firstname can not be blank")
	private String firstName;
	@NotBlank(message = "gender can not be blank")
	private String gender;
	@NotBlank(message = "id can not be blank")
	private String id;
	private String lastName;
//	@NotBlank(message = "selfie64 can not be blank")
//	private String selfie64;
	
	
	@NotBlank(message = "address can not be blank")
	private String address;
	@NotBlank(message = "email can not be blank")
	private String email;
	//@NotBlank(message = "token can not be blank")
	private String alternateNumber;

	@NotBlank(message = "token can not be blank")
	private String token;
	
	
	public OcrId() {}

//	public OcrId(String countryCode, String dob, String firstName, String gender, String id, String lastName,String token) {
//		this.countryCode = countryCode;
//		this.dob = dob;
//		this.firstName = firstName;
//		this.gender = gender;
//		this.id = id;
//		this.lastName = lastName;
//		this.token=token;
//		//this.selfie64=selfie64;
//	//	this.thumbImpression=thumbImpression;
//	}

	
	
	
	
	public String getCountryCode() {
		return countryCode;
	}

public OcrId(
		@NotBlank(message = "countryCode can not be blank") String countryCode,
		@NotBlank(message = "dob can not be blank") String dob,
		String firstName,
		@NotBlank(message = "gender can not be blank") String gender,
		@NotBlank(message = "id can not be blank") String id, String lastName,
		@NotBlank(message = "address can not be blank") String address,
		@NotBlank(message = "email can not be blank") String email,
		String alternateNumber,
		@NotBlank(message = "token can not be blank") String token) {
	this.countryCode = countryCode;
	this.dob = dob;
	this.firstName = firstName;
	this.gender = gender;
	this.id = id;
	this.lastName = lastName;
	this.address = address;
	this.email = email;
	this.alternateNumber = alternateNumber;
	this.token = token;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
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

public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}


	
}
