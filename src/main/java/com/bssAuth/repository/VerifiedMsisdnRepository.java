package com.bssAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bssAuth.model.VerifiedMsisdn;

import java.util.*;



public interface VerifiedMsisdnRepository extends JpaRepository<VerifiedMsisdn, Integer> {
List<VerifiedMsisdn> findByMsisdn(String msisdn);
}
