package com.bssAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bssAuth.model.OtherDocRequiredCount;

public interface OtherDocRequiredCountRepository extends JpaRepository<OtherDocRequiredCount, Integer> {

	OtherDocRequiredCount findByUserType(String userType);
	
	
	
	
}
