package com.bssAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bssAuth.model.Employee;
import com.bssAuth.model.EmployeeOrganisationMsisdn;
import com.bssAuth.model.Organisation;

public interface EmployeeOrganisationMsisdnRepository extends JpaRepository<EmployeeOrganisationMsisdn, Integer> {

	
	
	EmployeeOrganisationMsisdn findByMsisdn(String msisdn);
	
	EmployeeOrganisationMsisdn findByEmployeeAndOrganisationAndMsisdn(Employee employee,Organisation organisation,String msisdn);
	
	EmployeeOrganisationMsisdn findByEmployeeAndOrganisation(Employee employee,Organisation organisation);
	
}
