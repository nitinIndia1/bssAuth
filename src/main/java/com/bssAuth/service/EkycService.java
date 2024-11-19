package com.bssAuth.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.bssAuth.beans.AgentActivation_;
import com.bssAuth.beans.AgentLogin;
import com.bssAuth.beans.Agent_;
import com.bssAuth.beans.DocumentUpdateRequest;
import com.bssAuth.beans.ExtraInfo;
import com.bssAuth.beans.FetchResponse;
import com.bssAuth.beans.IdRequest;
import com.bssAuth.beans.IdRequest2;
import com.bssAuth.beans.IdRequest3;
import com.bssAuth.beans.MsisdnUpdate;
import com.bssAuth.beans.OcrAddress_;
import com.bssAuth.beans.OcrId;
import com.bssAuth.beans.SimCase;
import com.bssAuth.beans.SpecialMsisdns_;
import com.bssAuth.beans.StatusUpdate;
import com.bssAuth.beans.VerifiedMsisdn_;
import com.bssAuth.beans.VerifyMsisdnSpecial;
import com.bssAuth.model.SimLostDamageDetail;
import com.bssAuth.util.CoreResponseHandler;

public interface EkycService {

	
	ResponseEntity<CoreResponseHandler> callFirstOCR(IdRequest idRequest,String self);
	
	ResponseEntity<CoreResponseHandler> updateCustomerWithSelfie(OcrId ocrId,String type);
	
	
	
	

	ResponseEntity<CoreResponseHandler> callSecondOCR(IdRequest2 idRequest);
	ResponseEntity<CoreResponseHandler> updateAddress(OcrAddress_ ocrAddress);
	
	

	ResponseEntity<CoreResponseHandler> removeall();
	
	
	List<FetchResponse> fetchAll2(String applicationDate);
	
	
	ResponseEntity<CoreResponseHandler> savePermit(IdRequest3 idRequest,String value);
	
	
	ResponseEntity<CoreResponseHandler> saveVisa(IdRequest3 idRequest);
	ResponseEntity<CoreResponseHandler> saveWater(IdRequest3 idRequest);
	ResponseEntity<CoreResponseHandler> saveConsent(IdRequest3 idRequest);
	ResponseEntity<CoreResponseHandler> saveTelecom(IdRequest3 idRequest);
	ResponseEntity<CoreResponseHandler> updateDob(String token,String dob);
	
	
	
	ResponseEntity<CoreResponseHandler> saveUID(IdRequest3 idRequest);
	
	
	ResponseEntity<CoreResponseHandler> documentUpdate(DocumentUpdateRequest documentUpdateRequest);
	
	ResponseEntity<CoreResponseHandler> msisdnUpdate(MsisdnUpdate msisdnUpdate);
	ResponseEntity<CoreResponseHandler> statusUpdate(StatusUpdate statusUpdate);
	
	ResponseEntity<CoreResponseHandler> saveAgentActivation(AgentActivation_ agentActivation_);	
	ResponseEntity<CoreResponseHandler> specialMsisdnSave(SpecialMsisdns_ specialMsisdns_);	
	ResponseEntity<CoreResponseHandler> specialMsisdnVerify(VerifyMsisdnSpecial verifyMsisdnSpecial);	
	
	ResponseEntity<CoreResponseHandler> checkAgent(String msisdn);
	ResponseEntity<CoreResponseHandler> agentGet(String msisdn);	

	ResponseEntity<CoreResponseHandler> agentLogin(AgentLogin agentLogin);

	ResponseEntity<CoreResponseHandler> agentDealerGet(String type);	
	ResponseEntity<CoreResponseHandler> saveAgent(Agent_ agent);
	
	ResponseEntity<CoreResponseHandler> savePermitValue(String token,String permitValue);
	
	ResponseEntity<CoreResponseHandler> nicVerify(JSONObject obj);
	ResponseEntity<CoreResponseHandler> passportVerify(JSONObject obj);
	
	
	ResponseEntity<CoreResponseHandler> agentCustom();
	
	ResponseEntity<CoreResponseHandler> test();

	ResponseEntity<CoreResponseHandler> updateVerified(String token);
	
	ResponseEntity<CoreResponseHandler> checkbymsisdnnewcustomer(String msisdn,String newcustomer,String type);
	ResponseEntity<CoreResponseHandler> checkSimMsisdn(String msisdn);
	
	ResponseEntity<CoreResponseHandler> checkKyc(String msisdn,String flag);
	ResponseEntity<CoreResponseHandler> processbase64s(String docId);
	
	ResponseEntity<CoreResponseHandler> simLostDamageCase(SimCase simCase);
	
	ResponseEntity<CoreResponseHandler>  findByMsisdn(String msisdn);
	
	ResponseEntity<CoreResponseHandler>  findByToken(String token);
	
	ResponseEntity<CoreResponseHandler>  findByCase_(String case_);
	
	
	ResponseEntity<CoreResponseHandler>  findByDateRange(String from,String to);
	
	ResponseEntity<CoreResponseHandler>  checkVerifiedMsisdn(String msisdn);
	
	ResponseEntity<CoreResponseHandler>  findByDocId(String id);
	
	
	ResponseEntity<CoreResponseHandler>  ekycActivate(String token,ExtraInfo extraInfo);
	
	ResponseEntity<CoreResponseHandler>  collectCrmFields(String token,ExtraInfo extraInfo);
	
	
	
}
