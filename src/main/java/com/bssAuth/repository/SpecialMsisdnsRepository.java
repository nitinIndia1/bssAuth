package com.bssAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bssAuth.model.SpecialMsisdns;

import java.util.List;


public interface SpecialMsisdnsRepository extends JpaRepository<SpecialMsisdns, Integer>{

	
	SpecialMsisdns findByMsisdnPrefix(String msisdnPrefix);
}
