package com.bssAuth.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bssAuth.model.OtpDetail;

import jakarta.transaction.Transactional;


public interface OtpDetailRepository extends JpaRepository<OtpDetail, Integer>{

	String findMsisdn = "select * from otp_detail where msisdn = ?1";
	@Query(value= findMsisdn,nativeQuery=true)
	List<OtpDetail> findMsisdn(String msisdn);
	
	

	OtpDetail findByMsisdn(String msisdn);
	
	String updateStatus = "update otp_detail set isActive='false' where msisdn=?1";
	@Transactional
	@org.springframework.transaction.annotation.Transactional
	@Modifying
	@Query(value= updateStatus,nativeQuery=true)
	int updateStatus(String msisdn);
	

//	String findMsisdn2 = "select * from otp_detail where msisdn = ?1";
//	@Query(value= findMsisdn2,nativeQuery=true)
//	OtpDetail findByMsisdn(String msisdn);
	
	String mpinUpdate = "update otp_detail set mpin=?1 where msisdn=?2";
	@Transactional
	@org.springframework.transaction.annotation.Transactional
	@Modifying
	@Query(value= mpinUpdate,nativeQuery=true)
	int updateMpin(String mpin,String msisdn);
	
	
	
	String otpUpdate = "update otp_detail set msisdn=?1,otp=?2,otp_validity=?3,isActive=?4, token=?5 where msisdn=?1";
	@Transactional
	@org.springframework.transaction.annotation.Transactional
	@Modifying
	@Query(value= otpUpdate,nativeQuery=true)
	int updateOtp(String msisdn,String otp,String strDate,String isActive,String token);
	
	
	
	
	String otpUpdate2 = "update otp_detail set msisdn=?1,otp=?2,otp_validity=?3,isActive=?4 where msisdn=?1";
	@Transactional
	@org.springframework.transaction.annotation.Transactional
	@Modifying
	@Query(value= otpUpdate2,nativeQuery=true)
	int updateOtp2(String msisdn,String otp,String strDate,String isActive);
	
	
	
	
	
	String otpInsert = "insert into otp_detail(msisdn,otp,otp_validity,isActive,token) values(?1,?2,?3,?4,?5);";
	@Transactional
	@org.springframework.transaction.annotation.Transactional
	@Modifying
	@Query(value= otpInsert,nativeQuery=true)
	int insertOtp(String msisdn,String otp,String strDate,String isActive,String token);
	
	
	
	String otpInsert2 = "insert into otp_detail(msisdn,otp,otp_validity,isActive) values(?1,?2,?3,?4);";
	@Transactional
	@org.springframework.transaction.annotation.Transactional
	@Modifying
	@Query(value= otpInsert2,nativeQuery=true)
	int insertOtp2(String msisdn,String otp,String strDate,String isActive);
	
	
	
	
	
	String verifyMpin = "select * from otp_detail where msisdn = ?1 and mpin=?2";
	@Query(value= verifyMpin,nativeQuery=true)
	List<OtpDetail> verifyMpin(String msisdn,String mpin);
	
	
	
	String updateIsActive = "update otp_detail set isActive='true' where msisdn=?1 and token=?2";
	@Transactional
	@org.springframework.transaction.annotation.Transactional
	@Modifying
	@Query(value= updateIsActive,nativeQuery=true)
	int updateIsActive(String msisdn,String token);
	
	
	
	String updateIsActive2 = "update otp_detail set isActive='true' where msisdn=?1";
	@Transactional
	@org.springframework.transaction.annotation.Transactional
	@Modifying
	@Query(value= updateIsActive2,nativeQuery=true)
	int updateIsActive2(String msisdn);
		
	
	
	
	
	String verifyOtp = "select * from otp_detail where msisdn = ?1 and otp=?2 and isActive = 'false' and token=?3";
	@Query(value= verifyOtp,nativeQuery=true)
	List<OtpDetail> verifyOtp(String msisdn,String otp,String token);
	
	
	
	String verifyOtp2 = "select * from otp_detail where msisdn = ?1 and otp=?2 and isActive = 'false'";
	@Query(value= verifyOtp2,nativeQuery=true)
	List<OtpDetail> verifyOtp2(String msisdn,String otp);
	
	
	
	String fetchLatestToken = "select * from otp_detail where token = ?1 order by otp_validity desc limit 1";
	@Query(value= fetchLatestToken,nativeQuery=true)
	OtpDetail fetchOtpByToken(String token);
	
	
	
	
}
