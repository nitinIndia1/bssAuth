package com.bssAuth.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomCustomerDTO implements Serializable{
	private static final long serialVersionUID = 1334840937329153773L;

	private String firstName;

	private String lastName;

	public CustomCustomerDTO(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName=lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
