package com.bssAuth.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bssAuth.beans.CustomCustomerDTO;
import com.bssAuth.beans.CustomerObject;
import com.bssAuth.model.CustomerDetail;
import com.bssAuth.model.Document;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Integer>{

	
	
	@Query(value = "SELECT * FROM nauruekycservice.customer_details where create_date like %?1% ;",nativeQuery = true)
	List<CustomerDetail> findByCreateDatess(String date);
	
	
	
	@Query(value = "SELECT * FROM nauruekycservice.customer_details where create_date BETWEEN ?1 AND ?2 ;", nativeQuery = true)
	List<CustomerDetail> findByCreateDatess(String date, String date2);

	
	
	
	CustomerDetail findByToken(String token);
	
	@Query(value = "select * from customer_details where id = ?1 order by customerId desc limit 1;",nativeQuery = true)
	
	CustomerDetail findByID(String id);
	
	@Query(value = "select * from customer_details where kyc_status like '%contingency%' limit 5;", nativeQuery = true)
	  List<CustomerDetail> findTest();
	
	CustomerDetail findByDocument(Document document);

	
	@Query(value = "SELECT first_name as firstName,maiden_name as maidenName,last_name as lastName,token, update_date as updateDate, id,kyc_status as kycStatus,gender,dob FROM nauruekycservice.customer_details where id=?1 order by customerId desc limit 1;", nativeQuery = true)
	Optional<CustomerObject> findById2(String id);


	
//	@Query(value = "SELECT first_name as firstName, last_name as lastName FROM customer_details where id=?1 order by customerId desc limit 1", nativeQuery = true)
//	CustomerObject findById2(String id);

	
	
	
	
}
