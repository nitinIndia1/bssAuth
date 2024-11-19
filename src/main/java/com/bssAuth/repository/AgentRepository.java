package com.bssAuth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bssAuth.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

	
	Agent findByMsisdn(String msisdn);
	
	Agent findByUserNameAndPassword(String userName,String password);
	
	List<Agent> findByAgentType(String type);
	
	@Query(value = "SELECT * FROM nauruekycservice.agent where agent_type='Dealer' or (id=5570 or agent_name='CHiLi Call Center');",nativeQuery = true)
	List<Agent> findAgentCustom();
	
}
