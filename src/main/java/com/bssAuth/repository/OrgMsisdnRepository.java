package com.bssAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bssAuth.model.OrgMsisdn;
import com.bssAuth.model.Organisation;

import java.util.*;

public interface OrgMsisdnRepository extends JpaRepository<OrgMsisdn, Integer> {

	
	List<OrgMsisdn> findByOrganisation(Organisation organisation);
	
	OrgMsisdn findByOrganisationAndMsisdn(Organisation organisation,String msisdn);
}
