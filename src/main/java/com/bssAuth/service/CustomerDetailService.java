package com.bssAuth.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bssAuth.beans.IdRequest;
import com.bssAuth.beans.OcrId;
import com.bssAuth.model.CustomerDetail;
import com.bssAuth.util.CoreResponseHandler;

public interface CustomerDetailService {

	
	ResponseEntity<CoreResponseHandler> saveCustomer(OcrId ocrId,IdRequest idRequest,String self);
	CustomerDetail updateCustomer(CustomerDetail customerDetail,String strDate);
	
	CustomerDetail findByToken(String token);
	
	CustomerDetail findByID(String id);
	
	void deleteDuplicateCustomer(CustomerDetail customerDetail);
	
	
	List<CustomerDetail> fetchByDate(String date);
	
	
}
