package com.bssAuth.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class IdRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	@NotBlank(message = "idType can not be blank")
	private String idType;
	private String id64;// not mandatory
	@NotBlank(message = "residentType can not be blank")
	private String residentType;//tourist
	
	@NotBlank(message = "user type can not be blank")
	private String userType;
	
	
	
	
	
	
	
	
//	@NotBlank(message = "countryCode can not be blank")
//	private String countryCode;
//	@NotBlank(message = "dob can not be blank")
//	private String dob;
//	@NotBlank(message = "firstname can not be blank")
//	private String firstName;
//	@NotBlank(message = "gender can not be blank")
//	private String gender;
//	@NotBlank(message = "id can not be blank")
//	private String id;
//	private String lastName;
//	private String maidenName;
//	
//	@NotBlank(message = "address can not be blank")
//	private String address;
//	@NotBlank(message = "email can not be blank")
//	private String email;
//	//@NotBlank(message = "token can not be blank")
//	private String alternateNumber;
//
////	@NotBlank(message = "locality can not be blank")
////	private String locality;
////	
	
	
	
	
	
	
public IdRequest() {
	
}








public IdRequest(@NotBlank(message = "idType can not be blank") String idType,
		String id64,
		@NotBlank(message = "residentType can not be blank") String residentType,
		@NotBlank(message = "user type can not be blank") String userType) {
	this.idType = idType;
	this.id64 = id64;
	this.residentType = residentType;
	this.userType = userType;
}








public String getIdType() {
	return idType;
}








public void setIdType(String idType) {
	this.idType = idType;
}








public String getId64() {
	return id64;
}








public void setId64(String id64) {
	this.id64 = id64;
}








public String getResidentType() {
	return residentType;
}








public void setResidentType(String residentType) {
	this.residentType = residentType;
}








public String getUserType() {
	return userType;
}








public void setUserType(String userType) {
	this.userType = userType;
}

	
}
