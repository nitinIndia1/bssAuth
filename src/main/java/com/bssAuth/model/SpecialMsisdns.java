package com.bssAuth.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="special_msisdns")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SpecialMsisdns implements Serializable{

	private static final long serialVersionUID = 634149458723514309L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "msisdn_prefix", unique = true)
	private String msisdnPrefix;
	private String msisdn_length;
	
	
	public SpecialMsisdns() {}


	public SpecialMsisdns(int id, String msisdnPrefix, String msisdn_length) {
		this.id = id;
		this.msisdnPrefix = msisdnPrefix;
		this.msisdn_length = msisdn_length;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMsisdnPrefix() {
		return msisdnPrefix;
	}


	public void setMsisdnPrefix(String msisdnPrefix) {
		this.msisdnPrefix = msisdnPrefix;
	}


	public String getMsisdn_length() {
		return msisdn_length;
	}


	public void setMsisdn_length(String msisdn_length) {
		this.msisdn_length = msisdn_length;
	}


	@Override
	public String toString() {
		return "SpecialMsisdns [id=" + id + ", msisdnPrefix=" + msisdnPrefix + ", msisdn_length=" + msisdn_length
				+ "]";
	}
	
	
	
}
