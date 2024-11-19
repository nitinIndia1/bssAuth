package com.bssAuth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bssAuth.model.SimLostDamageDetail;

public interface SimLostDamageDetailRepository extends JpaRepository<SimLostDamageDetail, Integer> {

	SimLostDamageDetail findByMsisdn(String msisdn);
	
	SimLostDamageDetail findByToken(String token);
	
	@Query(value = "select * from sim_lost_damage_detail where case_=?1",nativeQuery = true)
	List<SimLostDamageDetail> findByCase_(String case_);
	
	
	
	@Query(value = "SELECT * FROM nauruekycservice.sim_lost_damage_detail where create_date BETWEEN ?1 AND ?2 ;", nativeQuery = true)
	List<SimLostDamageDetail> findByDateRange(String from,String to);
	
	
}
