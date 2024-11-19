package com.bssAuth.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SIMDetails implements Serializable{

	
	private static final long serialVersionUID = 337781759535740431L;

//	 "MSISDN": "218961239",
//     "IMSI": "23712381231293",
//     "Status": "Activated"

	
	private String MSISDN;
	private String IMSI;
	private String Status;
	
	public SIMDetails() {}

	public SIMDetails(String mSISDN, String iMSI, String status) {
		MSISDN = mSISDN;
		IMSI = iMSI;
		Status = status;
	}


	@JsonProperty("MSISDN")
	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	@JsonProperty("IMSI")
	public String getIMSI() {
		return IMSI;
	}

	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "SIMDetails [MSISDN=" + MSISDN + ", IMSI=" + IMSI + ", Status=" + Status + "]";
	}
	
}
