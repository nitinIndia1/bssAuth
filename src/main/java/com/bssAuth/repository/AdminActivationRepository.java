package com.bssAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bssAuth.model.AdminActivation;
import com.bssAuth.model.AgentActivation;

import java.util.*;
public interface AdminActivationRepository extends JpaRepository<AdminActivation, Integer> {

	List<AdminActivation> findByAdminId(String agentId);
	
	List<AdminActivation> findByEmployeeId(String customerId);
	
	
	
	
	
}
