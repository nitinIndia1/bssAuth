package com.bssAuth.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.bssAuth.beans.AgentActivationData_;
import com.bssAuth.beans.AgentActivation_;
import com.bssAuth.beans.AgentLogin;
import com.bssAuth.beans.Agent_;
import com.bssAuth.beans.CustomCustomerDTO;
import com.bssAuth.beans.CustomerObject;
import com.bssAuth.beans.DocumentDetail;
import com.bssAuth.beans.DocumentUpdateRequest;
import com.bssAuth.beans.Document_;
import com.bssAuth.beans.EkycActivate;
import com.bssAuth.beans.ExtraInfo;
import com.bssAuth.beans.FetchResponse;
import com.bssAuth.beans.IdRequest;
import com.bssAuth.beans.IdRequest2;
import com.bssAuth.beans.IdRequest3;
import com.bssAuth.beans.Image_;
import com.bssAuth.beans.MsisdnUpdate;
import com.bssAuth.beans.OcrAddress;
import com.bssAuth.beans.OcrAddress_;
import com.bssAuth.beans.OcrId;
import com.bssAuth.beans.SIMDetails;
import com.bssAuth.beans.SimAccessToken;
import com.bssAuth.beans.SimCase;
import com.bssAuth.beans.SimNicResponse;
import com.bssAuth.beans.SimPassportResponse;
import com.bssAuth.beans.SpecialMsisdns_;
import com.bssAuth.beans.StatusUpdate;
import com.bssAuth.beans.VerifiedMsisdn_;
import com.bssAuth.beans.VerifyMLRequest;
import com.bssAuth.beans.VerifyMLResponse;
import com.bssAuth.beans.VerifyMsisdnSpecial;
import com.bssAuth.model.Agent;
import com.bssAuth.model.AgentActivation;
import com.bssAuth.model.CustomerDetail;
import com.bssAuth.model.Document;
import com.bssAuth.model.Employee;
import com.bssAuth.model.Image;
import com.bssAuth.model.OtherDocRequiredCount;
import com.bssAuth.model.OtpDetail;
import com.bssAuth.model.SimDetail;
import com.bssAuth.model.SimLostDamageDetail;
import com.bssAuth.model.SpecialMsisdns;
import com.bssAuth.model.VerifiedMsisdn;
import com.bssAuth.repository.AgentActivationRepository;
import com.bssAuth.repository.AgentRepository;
import com.bssAuth.repository.CustomerDetailRepository;
import com.bssAuth.repository.DocumentRepository;
import com.bssAuth.repository.EmployeeRepository;
import com.bssAuth.repository.ImageRepository;
import com.bssAuth.repository.OtherDocRequiredCountRepository;
import com.bssAuth.repository.OtpDetailRepository;
import com.bssAuth.repository.SimDetailRepository;
import com.bssAuth.repository.SimLostDamageDetailRepository;
import com.bssAuth.repository.SpecialMsisdnsRepository;
import com.bssAuth.repository.VerifiedMsisdnRepository;
import com.bssAuth.util.ApplicationResponse;
import com.bssAuth.util.CommonUtilityFunctions;
import com.bssAuth.util.CoreResponseHandler;
import com.bssAuth.util.ResponseStatusEnum;
import com.bssAuth.util.SuccessResponseBeanRefined;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EkycServiceImpl implements EkycService {

	@Autowired
	private CommonUtilityFunctions commonUtilityFunctions;

	@Autowired
	private CustomerDetailService custService;
	@Autowired
	private CustomerDetailRepository custRepo;

	@Autowired
	private ImageService imgService;
	@Autowired
	private ImageRepository imgRepo;

	@Autowired
	private DocumentService docService;
	@Autowired
	private SimDetailService simService;
	@Autowired
	private SimDetailRepository simRepo;

	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private AgentActivationRepository agentActivationRepo;

//	@Autowired
//	private RestTemplate restTemplate0;

	@Autowired
	private DocumentRepository docRepo;

	@Autowired
	private OtpDetailRepository otpRepo;

	@Autowired
	private OtherDocRequiredCountRepository otherDocRepo;
@Autowired
private VerifiedMsisdnRepository vRepo;
	@Override
	public ResponseEntity<CoreResponseHandler> callFirstOCR(IdRequest idRequest,String self) {
		long l_time_start = System.currentTimeMillis();


//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
//
//		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
//		String requestId = commonUtilityFunctions.getRandomNumber(9);
//		requestBody.add("doctype", "idproof");
//		requestBody.add("category", "identity");
//		requestBody.add("docname", idRequest.getIdType());
//		requestBody.add("image", idRequest.getId64());
//		requestBody.add("requestId", requestId);

		//		ResponseEntity<OcrId> response = null;
		//		HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
		//		try {
		//			response = restTemplate.exchange("http://182.74.113.62:9001/ekyc/ocr/id", HttpMethod.POST,
		//					formEntity, OcrId.class);
		//		} catch (Exception ex) {
		//			System.out.println("Exception...");
		//			ex.printStackTrace();
		//			long l_time_end = System.currentTimeMillis();
		//			long l_diff = l_time_end - l_time_start;
		//			ex.printStackTrace();
		//			long l_end_time = System.currentTimeMillis();
		//			l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
		//		}
		//		OcrId obj = response.getBody();
		OcrId obj = new OcrId();
		long l_time_end = System.currentTimeMillis();
		long l_diff = l_time_end - l_time_start;

		//if(obj!=null) {
		ResponseEntity<CoreResponseHandler> ocrId =  custService.saveCustomer(obj,idRequest,self);
			return ocrId;

		//}

//		long l_end_time = System.currentTimeMillis();
//		l_diff = l_end_time-l_time_start;
//		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);








	}

	@Override
	public ResponseEntity<CoreResponseHandler> updateCustomerWithSelfie(OcrId ocrId,String type) {
		// TODO Auto-generated method stub
		long l_diff = 0;
		long l_time_start = System.currentTimeMillis();
		try {
			CustomerDetail customerDetail0 = custService.findByID(ocrId.getId());
			//System.out.println("0"+customerDetail0.getCustomerId());



//			if(customerDetail0!=null && customerDetail0.getToken()!=null && !customerDetail0.getKycStatus().equals("verified") && !customerDetail0.getKycStatus().equals("verification failed") && !customerDetail0.getKycStatus().equals("verified. Other doc proof also needed.") ) {
//				CustomerDetail customerDetail  =  custService.findByToken(ocrId.getToken());
//				if(customerDetail==null) {
//					long l_end_time = System.currentTimeMillis();
//					l_diff = l_end_time-l_time_start;
//					System.out.println("1111");
//					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"detail already there with token :"+customerDetail0.getToken()+" kyc status : "+customerDetail0.getKycStatus(),l_diff+" ms") ,HttpStatus.OK);												
//
//				}

				//				if(customerDetail.getKycStatus().equals("id proof submitted")) {
				//					Image image = customerDetail.getImage();
				//					custService.deleteDuplicateCustomer(customerDetail);
				//					imgService.deleteDuplicateCustomerImage(image);
				//					long l_end_time = System.currentTimeMillis();
				//					l_diff = l_end_time-l_time_start;
				//					System.out.println("1");
				//					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"detail already there with token :"+customerDetail0.getToken()+" kyc status : "+customerDetail0.getKycStatus(),l_diff+" ms") ,HttpStatus.OK);												
				//						
				//				}
				//				else {
				//					long l_end_time = System.currentTimeMillis();
				//					l_diff = l_end_time-l_time_start;
				//					System.out.println("###");
				//					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"detail already there with token :"+customerDetail0.getToken()+" kyc status : "+customerDetail0.getKycStatus(),l_diff+" ms") ,HttpStatus.OK);
				//				}


			//}
			System.out.println("2");
			CustomerDetail customerDetail  =  custService.findByToken(ocrId.getToken());
			System.out.println("3");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+ ocrId.getToken());
			customerDetail.setId(ocrId.getId()==null||ocrId.getId().equals("")?"":ocrId.getId());
			customerDetail.setFirstName(ocrId.getFirstName()==null||ocrId.getFirstName().equals("")?"":ocrId.getFirstName());
			customerDetail.setLastName(ocrId.getLastName()==null||ocrId.getLastName().equals("")?"":ocrId.getLastName());
			customerDetail.setAddress(ocrId.getAddress()==null||ocrId.getAddress().equals("")?"":ocrId.getAddress());
			customerDetail.setEmail(ocrId.getEmail()==null||ocrId.getEmail().equals("")?"":ocrId.getEmail());
			customerDetail.setAlternateNumber(ocrId.getAlternateNumber()==null || ocrId.getAlternateNumber().equals("")?"":ocrId.getAlternateNumber());
			
			if(ocrId.getDob()==null) {
				customerDetail.setDob(null);
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"dob can not be null",null) ,HttpStatus.BAD_REQUEST);												
		
				
			}
			else {
				Date dob = null;
				try {
					dob = sdf.parse(ocrId.getDob());
					customerDetail.setDob(dob);
				}catch(Exception ex) {
					customerDetail.setDob(null);
					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"incorrect format of dob",null) ,HttpStatus.BAD_REQUEST);												
								
				}
			}

			customerDetail.setNationality(ocrId.getCountryCode()==null||ocrId.getCountryCode().equals("")?"":ocrId.getCountryCode());
			customerDetail.setGender(ocrId.getGender()==null||ocrId.getGender().equals("")?"":ocrId.getGender());


			Image image = customerDetail.getImage();


//			Image_ image_ = new Image_();
//			image_.setBase64(ocrId.getSelfie64());
//			image_.setImgType(type);
//			image_.setToken(ocrId.getToken());
//			Image image2  = imgService.updateImageWithSelfie(image, image_);
//			
			
			
			customerDetail.setUpdateDate(new Date());
			//customerDetail.setImage(image2);
			if(customerDetail.getKycStatus()!=null && !customerDetail.getKycStatus().equals("verified")) {
				customerDetail.setKycStatus("verified. Other doc proof also needed.");				
			}

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			CustomerDetail customerDetail2 = custService.updateCustomer(customerDetail,sdf2.format(customerDetail.getCreateDate()));
			if(customerDetail2!=null) {
				long l_end_time = System.currentTimeMillis();
				l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"saved",l_diff+" ms") ,HttpStatus.OK);												

			}
			//if (image2 != null) {
				
				
				
				//DO BIOMETRIC HERE.. MATCH THUMB... API CALL LATER
				
				
				
				/*
				 * customerDetail.setUpdateDate(new Date()); SimpleDateFormat sdf2 = new
				 * SimpleDateFormat("yyyy-MM-dd"); CustomerDetail customerDetail2 =
				 * custService.updateCustomer(customerDetail,sdf2.format(customerDetail.
				 * getCreateDate()));
				 * 
				 * RestTemplate restTemplate = new RestTemplate();
				 * 
				 * HttpHeaders headers = new HttpHeaders(); headers.add("Content-Type",
				 * MediaType.APPLICATION_JSON_VALUE);
				 * 
				 * JSONObject obj =new JSONObject(); obj.put("password", "1s84jBiV6ZpHO6VR5B");
				 * obj.put("username", "mtml");
				 * 
				 * ResponseEntity<SimAccessToken> response = null; HttpEntity formEntity = new
				 * HttpEntity(obj, headers); try { response =
				 * restTemplate0.exchange("https://simapi.icta.mu/icta/auth/login",
				 * HttpMethod.POST, formEntity, SimAccessToken.class); if(response==null) { long
				 * l_end_time = System.currentTimeMillis(); l_diff = l_end_time-l_time_start;
				 * return new ResponseEntity<CoreResponseHandler>(new
				 * SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR,
				 * ResponseStatusEnum.FAILED,
				 * ApplicationResponse.Failed,"sim api access token null",l_diff+" ms"),
				 * HttpStatus.INTERNAL_SERVER_ERROR); } if(response!=null) {
				 * 
				 * SimAccessToken simAccessToken = response.getBody(); if(simAccessToken==null)
				 * { long l_end_time = System.currentTimeMillis(); l_diff =
				 * l_end_time-l_time_start; return new ResponseEntity<CoreResponseHandler>(new
				 * SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR,
				 * ResponseStatusEnum.FAILED,
				 * ApplicationResponse.Failed,"sim api access token null",l_diff+" ms"),
				 * HttpStatus.INTERNAL_SERVER_ERROR); } return
				 * callSimApi(simAccessToken.getAccessToken(),customerDetail2); } } catch
				 * (HttpStatusCodeException ex) { System.out.println("Exception...");
				 * ex.printStackTrace(); int statusCode = ex.getStatusCode().value(); String
				 * abcObj =ex.getResponseBodyAsString(); JSONParser parser = new JSONParser();
				 * JSONObject obj2 = (JSONObject)parser.parse(abcObj);
				 * System.out.println(obj2.toJSONString()); long l_end_time =
				 * System.currentTimeMillis(); l_diff = l_end_time-l_time_start; return new
				 * ResponseEntity<CoreResponseHandler>(new
				 * SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR,
				 * ResponseStatusEnum.FAILED,
				 * ApplicationResponse.Failed,obj2,l_diff+" ms"),HttpStatus.
				 * INTERNAL_SERVER_ERROR); } catch(Exception ex22) {
				 * System.out.println("###########################"); ex22.printStackTrace(); }
				 * 
				 * 
				 */
//			}
//			else {
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"unable to upload selfie image",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//			}










		}catch(Exception ex) {
			ex.printStackTrace();
			long l_end_time = System.currentTimeMillis();
			l_diff = l_end_time-l_time_start;
			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"error",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
		}

		long l_end_time = System.currentTimeMillis();
		l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"error",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
	}



	private ResponseEntity<CoreResponseHandler> callSimApi(String accessToken,CustomerDetail customerDetail) {
//		String residentType = customerDetail.getResidentType();
//		if(residentType.equals("citizen")) {
//			return  callVerifyNic(accessToken,customerDetail);
//		}
//		else {
//			return callVerifyPassportNumber(accessToken,customerDetail);
//		}
//
//	
		return null;
	}

//	private ResponseEntity<CoreResponseHandler> callVerifyPassportNumber(String accessToken,CustomerDetail customerDetail) {
//		long l_diff = 0;
//		long l_time_start = System.currentTimeMillis();
//		boolean test = false;
//		CustomerDetail customerDetail_ =null;
//		SimPassportResponse simPassportResponse = null;
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//		headers.add("Authorization", "Bearer "+accessToken);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		JSONObject obj =new JSONObject();
//		obj.put("passportNumber", customerDetail.getId());
//		if(customerDetail.getDob()==null ) {
//			long l_end_time = System.currentTimeMillis();
//			l_diff = l_end_time-l_time_start;
//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"dob of customer is NULL during passport verification",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		obj.put("dateOfBirth",  sdf.format(customerDetail.getDob()));
//		obj.put("gender", customerDetail.getGender().substring(0, 1).toUpperCase());
//		if(customerDetail.getResidentType().toUpperCase().startsWith("TOU")) {
//			obj.put("userType", "TOURIST");
//		}
//		else {
//			obj.put("userType", "RESIDENT");
//		}
//		obj.put("nationalityCode", customerDetail.getNationality());
//
//		ResponseEntity<SimPassportResponse> response = null;
//		HttpEntity formEntity = new HttpEntity(obj, headers);
//		try {
//			response = restTemplate0.exchange("https://simapi.icta.mu/icta/verifyPassportNumber", HttpMethod.POST,
//					formEntity, SimPassportResponse.class);
//			if(response==null) {
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//			if(response!=null) {
//				simPassportResponse = response.getBody();
//				if(simPassportResponse==null) {
//					long l_end_time = System.currentTimeMillis();
//					l_diff = l_end_time-l_time_start;
//					return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//				}
//				
//				customerDetail.setPassportDateIssued(simPassportResponse.getDateIssued());
//				customerDetail.setPassportDateExpired(simPassportResponse.getDateExpired());
//				customerDetail.setPassportDateFrom(simPassportResponse.getDateFrom());
//				customerDetail.setPassportDateTo(simPassportResponse.getDateTo());
//				//CustomerDetail customerDetail2 =  custService.updateCustomer(customerDetail, "");
//				
////				customerDetail_ = custService.findByID(simPassportResponse.getPassportNum());
////				if(customerDetail_==null) {
////					long l_end_time = System.currentTimeMillis();
////					l_diff = l_end_time-l_time_start;
////					return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no such customer in records",l_diff+" ms"),HttpStatus.NOT_FOUND);
////
////				}
//				System.out.println(simPassportResponse);
//
//			}
//		} catch (HttpStatusCodeException ex) {
//			test = true;
//			System.out.println("Exception...");
//			//ex.printStackTrace();
//			int statusCode = ex.getStatusCode().value();
//			String abcObj =ex.getResponseBodyAsString();
//			JSONParser parser = new JSONParser();
//			JSONObject obj2 =null;
//			try {
//				obj2 = (JSONObject)parser.parse(abcObj);
//			}catch(Exception ex2){
//				ex2.printStackTrace();
//			}
//			if(obj2!=null) {
//				
//				System.out.println("@@@@ "+obj2.toJSONString());
////				String errorCode = (String) obj2.get("errorCode");
//
////				customerDetail.setContingencyErrorCode(errorCode);
////				if(errorCode.equals("0100")) {
////					customerDetail.setKycStatus("contingency not verified");
////					customerDetail.setUpdateDate(new Date());
////					
////				}
////				custService.updateCustomer(customerDetail, "");
//			}
//			else
//			{
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				//return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//			}
//			
//			long l_end_time = System.currentTimeMillis();
//			l_diff = l_end_time-l_time_start;
//			//return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,obj2,l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		String firstName=null;
//		String maidenName =null;
//		String lastName = null;
//		if(test==false) {
//			customerDetail.setCorrelationId(simPassportResponse.getCorrelationId());
//		customerDetail.setPmUid(simPassportResponse.getPmUid());
//		firstName = simPassportResponse.getFirstName()==null?"":simPassportResponse.getFirstName();
//		maidenName = simPassportResponse.getMaidenName()==null?"":simPassportResponse.getMaidenName();
//		lastName = simPassportResponse.getLastName()==null?"":simPassportResponse.getLastName();
//
//		//customerDetail = custService.updateCustomer(customerDetail, "");
//		}
//		Image image = customerDetail.getImage();
//		String img64Orignal= image.getOriginalPhotoBase64();
//		String passportImage = image.getKycPhotoBase64();
//
//		String name = firstName+" "+maidenName+" "+lastName;
//		name=name.trim();
//		name=name.replace("  ", " ");
//		VerifyMLRequest verifyMLRequest = new VerifyMLRequest();
//		verifyMLRequest.setImage(img64Orignal);
//		verifyMLRequest.setNimage(passportImage);
//		verifyMLRequest.setName(name);
//		verifyMLRequest.setId(customerDetail.getId());
//		verifyMLRequest.setUtype(customerDetail.getResidentType());
//
//		try {
//			VerifyMLResponse verifyMLResponse =  callVerifyML(verifyMLRequest);
//			if(verifyMLResponse==null) {
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"no response from verify ML ",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//			}
//			String verifiedImage = verifyMLResponse.getImage();
//			verifiedImage = verifiedImage.replace("b'", "");
//			image.setVerifiedPhotoBase64(verifiedImage);
//			Image_ image_ = new Image_();
//			image_.setBase64(verifiedImage);
//			image_.setImgType("verified");
//			image_.setToken(customerDetail.getToken());
//			Image img = imgService.updateImageWithSelfie(image,image_);
//			if(img==null) {
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"verified image not saved",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);											
//			}
//			customerDetail.setUpdateDate(new Date());
//			if(verifyMLResponse.isMatch_status()==false || verifyMLResponse.isMatch_status()==true) {
//				//customerDetail.setKycStatus("verified"); // yahan not verified tha
//			}
//			else if(!customerDetail.getKycStatus().equals("contingency not verified")){
//				customerDetail.setKycStatus("verified. Other doc proof also needed.");
//			}
//			custRepo.saveAndFlush(customerDetail);
//			long l_end_time = System.currentTimeMillis();
//			l_diff = l_end_time-l_time_start;
//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,verifyMLResponse,l_diff+" ms") ,HttpStatus.OK);												
//
//		}catch(Exception ex) {
//			long l_end_time = System.currentTimeMillis();
//			l_diff = l_end_time-l_time_start;
//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"no response from verify ML ",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);							
//		}
//
//
//
//		//long l_end_time = System.currentTimeMillis();
//		//l_diff = l_end_time-l_time_start;
//		//return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//	
//	}



	private ResponseEntity<CoreResponseHandler> callVerifyNic(String accessToken,CustomerDetail customerDetail) {
//		long l_diff = 0;
//		long l_time_start = System.currentTimeMillis();
//		//CustomerDetail customerDetail_ =null;
//		SimNicResponse simNicResponse = null;
//		RestTemplate restTemplate = new RestTemplate();
//		boolean test = false;
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//		headers.add("Authorization", "Bearer "+accessToken);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		JSONObject obj =new JSONObject();
//		obj.put("nicNum", customerDetail.getId());
//		obj.put("dateOfBirth",  sdf.format(customerDetail.getDob()));
//		obj.put("gender", customerDetail.getGender().substring(0, 1).toUpperCase());
//		obj.put("userType", "SELF");
//		ResponseEntity<SimNicResponse> response = null;
//		HttpEntity formEntity = new HttpEntity(obj, headers);
//		try {
//			response = restTemplate0.exchange("https://simapi.icta.mu/icta/verifyNIC", HttpMethod.POST,
//					formEntity, SimNicResponse.class);
//			if(response==null) {
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//			if(response!=null) {
//				simNicResponse = response.getBody();
//				if(simNicResponse==null) {
//					long l_end_time = System.currentTimeMillis();
//					l_diff = l_end_time-l_time_start;
//					return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//				}
//
////				customerDetail_ = custService.findByID(simNicResponse.getNicNum());
////				if(customerDetail_==null) {
////					long l_end_time = System.currentTimeMillis();
////					l_diff = l_end_time-l_time_start;
////					return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no such customer in records",l_diff+" ms"),HttpStatus.NOT_FOUND);
////
////				}
//				System.out.println(simNicResponse);
//
//			}
//		} catch (HttpStatusCodeException ex) {
//			test=true;
//			System.out.println("Exception...");
//			ex.printStackTrace();
//			int statusCode = ex.getStatusCode().value();
//			String abcObj =ex.getResponseBodyAsString();
//			JSONParser parser = new JSONParser();
//			JSONObject obj2 =null;
//			try {
//				obj2 = (JSONObject)parser.parse(abcObj);
//			}catch(Exception ex2){
//
//			}
//			if(obj2!=null)
//				System.out.println(obj2.toJSONString());
//			else
//			{
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				//return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//			}
//			long l_end_time = System.currentTimeMillis();
//			l_diff = l_end_time-l_time_start;
//			//return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,obj2,l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//
//		if(test==false) {
//		customerDetail.setCorrelationId(simNicResponse.getCorrelationId());
//		//customerDetail = custService.updateCustomer(customerDetail, "");
//		}
//		
//		Image image = customerDetail.getImage();
//		String img64Orignal= image.getOriginalPhotoBase64();
//		VerifyMLRequest verifyMLRequest = null;
//		if(test==false) {
//		String simImage = simNicResponse.getPhotograph();
//		String firstName = simNicResponse.getFirstName()==null?"":simNicResponse.getFirstName();
//		String maidenName = simNicResponse.getMaidenName()==null?"":simNicResponse.getMaidenName();
//		String lastName = simNicResponse.getLastName()==null?"":simNicResponse.getLastName();
//		
//		String name = firstName+" "+maidenName+" "+lastName;
//		name=name.trim();
//		name=name.replace("  ", " ");
//		verifyMLRequest = new VerifyMLRequest();
//		verifyMLRequest.setImage(img64Orignal);
//		verifyMLRequest.setNimage(simImage);
//		verifyMLRequest.setName(name);
//		verifyMLRequest.setId(customerDetail.getId());
//		verifyMLRequest.setUtype(customerDetail.getResidentType());
//		}
//		
//		if(verifyMLRequest!=null) {
//		try {
//			VerifyMLResponse verifyMLResponse =  callVerifyML(verifyMLRequest);
//			if(verifyMLResponse==null) {
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"no response from verify ML ",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//			}
//			String verifiedImage = verifyMLResponse.getImage();
//			verifiedImage = verifiedImage.replace("b'", "");
//			image.setVerifiedPhotoBase64(verifiedImage);
//			Image_ image_ = new Image_();
//			image_.setBase64(verifiedImage);
//			image_.setImgType("verified");
//			image_.setToken(customerDetail.getToken());
//			Image img = imgService.updateImageWithSelfie(image,image_);
//			if(img==null) {
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"verified image not saved",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);											
//			}
//			customerDetail.setUpdateDate(new Date());
//			if(verifyMLResponse.isMatch_status()==false) {
//				customerDetail.setKycStatus("verification failed");
//			}
//			else if(!customerDetail.getKycStatus().equals("contingency not verified")){
//				customerDetail.setKycStatus("verified. Other doc proof also needed.");
//			}
//			custRepo.saveAndFlush(customerDetail);
//			long l_end_time = System.currentTimeMillis();
//			l_diff = l_end_time-l_time_start;
//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,verifyMLResponse,l_diff+" ms") ,HttpStatus.OK);												
//
//		}catch(Exception ex) {
//			long l_end_time = System.currentTimeMillis();
//			l_diff = l_end_time-l_time_start;
//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"no response from verify ML ",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);							
//		}
//		}
//		else {
//			long l_end_time = System.currentTimeMillis();
//			l_diff = l_end_time-l_time_start;
//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ML api not called because sim api failed for nic ",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);										
//		}
//
//
//
//		//long l_end_time = System.currentTimeMillis();
//		//l_diff = l_end_time-l_time_start;
//		//return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//	
//	
		return null;
	}






	private VerifyMLResponse callVerifyML(VerifyMLRequest verifyMLRequest) {

		VerifyMLResponse verifyMLResponse = null;

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();

		requestBody.add("image", verifyMLRequest.getImage());
		requestBody.add("nimage", verifyMLRequest.getNimage());
		requestBody.add("name", verifyMLRequest.getName());
		requestBody.add("id", verifyMLRequest.getId());
		requestBody.add("utype", verifyMLRequest.getUtype());

		ResponseEntity<VerifyMLResponse> response = null;
		HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
		try {
			
			//http://192.168.0.14:8000/ekyc/verify
//			response = restTemplate.exchange("http://192.168.0.14:8000/ekyc/verify", HttpMethod.POST,
//					formEntity, VerifyMLResponse.class);//http://192.168.29.89:8000/ekyc/verify
			//response = restTemplate.exchange("http://182.71.12.123:8000/ekyc/verify", HttpMethod.POST,
				//	formEntity, VerifyMLResponse.class);
			//http://192.168.29.89:8000/ekyc/verify
//			response = restTemplate.exchange("http://192.168.29.89:8000/ekyc/verify", HttpMethod.POST,
//				formEntity, VerifyMLResponse.class);
			response = restTemplate.exchange("http://192.168.3.2:8000/ekyc/verify", HttpMethod.POST,
					formEntity, VerifyMLResponse.class);
				
			verifyMLResponse = response.getBody();

		} catch (Exception ex) {
			ex.printStackTrace();
			verifyMLResponse=null;
		}
		return verifyMLResponse;
	}

	@Override
	public ResponseEntity<CoreResponseHandler> removeall() {
		// TODO Auto-generated method stub
		custRepo.deleteAll();
		imgRepo.deleteAll();
		docRepo.deleteAll();
		return null;
	}

	@Override
	public ResponseEntity<CoreResponseHandler> callSecondOCR(IdRequest2 idRequest) {

		long l_time_start = System.currentTimeMillis();

		String token = idRequest.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}

		if(customerDetail.getKycStatus().equals("verified")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"already verified with token: "+customerDetail.getToken(),l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
		}
		if(customerDetail.getKycStatus().equals("verification failed") && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}
		if(!customerDetail.getKycStatus().equals("verified. Other doc proof also needed.") && !customerDetail.getKycStatus().equals("contingency not verified") && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"	. Status found : "+customerDetail.getKycStatus(),l_diff+" ms") ,HttpStatus.BAD_REQUEST);
		}

		//		RestTemplate restTemplate = new RestTemplate();
		//
		//		HttpHeaders headers = new HttpHeaders();
		//		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
		//
		//		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		//		String requestId = commonUtilityFunctions.getRandomNumber(9);
		//		requestBody.add("doctype", "addressproof");
		//		requestBody.add("category", "address");
		//		requestBody.add("docname", idRequest.getDocname());
		//		requestBody.add("image", idRequest.getImage());
		//		requestBody.add("requestId", requestId);
		//
		//		ResponseEntity<OcrAddress> response = null;
		//		HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
		//		try {
		//			response = restTemplate.exchange("http://182.74.113.62:9001/ekyc/ocr/document", HttpMethod.POST,
		//					formEntity, OcrAddress.class);
		//		} catch (Exception ex) {
		//			System.out.println("Exception...");
		//			ex.printStackTrace();
		//			long l_time_end = System.currentTimeMillis();
		//			long l_diff = l_time_end - l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
		//		}
		//		OcrAddress obj = response.getBody();

		OcrAddress obj = new OcrAddress();
		obj.setAddress("");
		if(obj!=null) {

			Document document = customerDetail.getDocument();
			if(document==null) {
				document=new Document();
			}
			Document_ d_ = new Document_();
			d_.setBase64(idRequest.getImage());
			d_.setImgType(idRequest.getDocname());
			d_.setToken(idRequest.getToken());

			Document document0 = null;
			
			document0 = docService.saveDocument(document, d_);

			if(document0!=null) {
			String userType = customerDetail.getResidentType();
			OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);


			if(customerDetail.getOtherDocCount()==null || Integer.parseInt(customerDetail.getOtherDocCount())==0) {
				customerDetail.setOtherDocCount("1");
			}
			if(customerDetail.getOtherDocCount()!=null && otherDocRequiredCount!=null && customerDetail.getOtherDocCount().equals(otherDocRequiredCount.getCounts())) {
				
	
				
					customerDetail.setKycStatus("verified");	
				
			
			
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			else{

				int count = Integer.parseInt(customerDetail.getOtherDocCount());
				customerDetail.setOtherDocCount(count+1+"");
			}
			}
			customerDetail.setDocument(document0);
			customerDetail.setUpdateDate(new Date());

			CustomerDetail customerDetail0= custRepo.saveAndFlush(customerDetail);

			if(customerDetail0!=null && customerDetail0.getCustomerId()>0) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,obj,l_diff+" ms") ,HttpStatus.OK);												

			}
		}

		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);



	}

	@Override
	public ResponseEntity<CoreResponseHandler> updateAddress(OcrAddress_ ocrAddress) {
		// TODO Auto-generated method stub
		long l_time_start = System.currentTimeMillis();


		if(ocrAddress.getAddress()==null || ocrAddress.getAddress().trim().equals("")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"address can not be blank",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}


		CustomerDetail customerDetail = custService.findByToken(ocrAddress.getToken());
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}

//		if(customerDetail.getKycStatus().equals("verified")) {
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"already verified",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
//
//		}
//		if(!customerDetail.getKycStatus().equals("verified. Other doc proof also needed.") && !customerDetail.getKycStatus().equals("contingency not verified") && customerDetail.getResidentType().equals("citizen")) {
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"not yet verified",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
//
//		} 
		customerDetail.setAddress(ocrAddress.getAddress());
		customerDetail.setAlternateNumber(ocrAddress.getAlternateNumber());
		customerDetail.setEmail(ocrAddress.getEmail());
		String userType = customerDetail.getResidentType();
		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);
		if(otherDocRequiredCount.getCounts().equals(customerDetail.getOtherDocCount())) {
			if(!customerDetail.getKycStatus().equals("contingency not verified")) {
//				VerifiedMsisdn_ vm = new VerifiedMsisdn_();
//				vm.setToken(customerDetail.getToken());
//				SimDetail simDetail =  customerDetail.getSimDetail();
//				if(simDetail!=null)
//				vm.setMsisdn(simDetail.getMsisdn());
//				else
//					vm.setMsisdn(null);
//				vm.setSimDetail(simDetail);
//				boolean b = saveToVerifiedMsisdn(vm);
				customerDetail.setKycStatus("verified");	
			}
						
		}
		//customerDetail.setKycStatus("verified");
		customerDetail.setUpdateDate(new Date());
		CustomerDetail customerDetail2 =  custRepo.saveAndFlush(customerDetail);
		if(customerDetail2!=null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			if(customerDetail2.getKycStatus().equals("verified")) {
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected. verified.",l_diff+" ms") ,HttpStatus.OK);																
			}
			else
			{
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected",l_diff+" ms") ,HttpStatus.OK);												
			}															
		}
		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);

	}




	@Override
	public List<FetchResponse> fetchAll2(String newApplicationDate) {
		long l_time_start = System.currentTimeMillis();


		//2023-10-25 09:31:28
		List<FetchResponse> lsRes = null;
		//		Date dt = null;
		//		try {
		//		dt = new SimpleDateFormat("yyyy-MM-dd").parse(newApplicationDate);
		//		}catch(Exception ex) {
		//			ex.printStackTrace();
		//		}
		List<CustomerDetail> lsCustomerDeatils =  custService.fetchByDate(newApplicationDate);
		if(lsCustomerDeatils!=null && lsCustomerDeatils.size()>0) {
			lsRes = new ArrayList<FetchResponse>();
			for(CustomerDetail cust:lsCustomerDeatils) {
				try {
				FetchResponse res = new FetchResponse();

				String ApplicationId = cust.getCustomerId()+"";
				String firstName = cust.getFirstName()==null?"":cust.getFirstName();
				String maidenName = cust.getMaidenName()==null?"":cust.getMaidenName();
				String lastName = cust.getLastName()==null?"":cust.getLastName();
				String FullName = firstName+" "+maidenName+" "+lastName;
				String Nationality = cust.getNationality()==null || cust.getNationality().equals("")?"":cust.getNationality();
				String resType = cust.getResidentType()==null || cust.getResidentType().equals("")?"":cust.getResidentType();
				String pmUid = cust.getPmUid()==null || cust.getPmUid().equals("")?"":cust.getPmUid();
				String rechargeType = cust.getRechargeType()==null || cust.getRechargeType().equals("")?"":cust.getRechargeType();
				String customerOrAgent = cust.getUserType()==null || cust.getUserType().equals("")?"":cust.getUserType();
				String crmInfo = cust.getCrmInfo()==null || cust.getCrmInfo().equals("")?"":cust.getCrmInfo();
				String UserType = null;
				if(resType!=null && !resType.equals("")&& resType.equals("citizen")) {
					UserType = "CITIZEN";
				}
				else if(resType!=null && !resType.equals("")&& resType.equals("tourist")) {
					UserType = "TOURIST";
				}
				else if(resType!=null && !resType.equals("")&& resType.equals("resident")) {
					UserType = "RESIDENT";
				}
				else {
					UserType = "";
				}
				String DocumentType = null;
				if(UserType.equals("CITIZEN")) {
					DocumentType = "National ID";
				}
				else {
					DocumentType = "Passport";
				}
				String DocumentId =  cust.getId()==null || cust.getId().equals("")?"":cust.getId();

				String email=cust.getEmail()==null?"":cust.getEmail();
				String alternateNumber = cust.getAlternateNumber()==null?"":cust.getAlternateNumber();
				String newCustomer = cust.getNewCustomer()==null?"no":cust.getNewCustomer();
				String permitValue = cust.getPermitValue()==null?"":cust.getPermitValue();
				String address = cust.getAddress()==null?"":cust.getAddress();

				String Date_Of_Birth = cust.getDob()==null?"": new SimpleDateFormat("dd-MM-yyyy").format(cust.getDob());
				String gender_ = cust.getGender()==null || cust.getGender().equals("")?null:cust.getGender();
				//String Gender = gender_==null?"":gender_.equals("F")?"Female":"Male";

				Image img = cust.getImage()==null?null:cust.getImage();
				String OriginalPhoto = null;
				String eKYCPhoto = null;
				String verifiedPhoto = null;
				String OriginalPhoto_url = null;
				String eKYCPhoto_url = null;
				String verifiedPhoto_url = null;
				String thumb_impression_url = null;
				
				if(img!=null) {
//					OriginalPhoto = img.getOriginalPhotoBase64();
//					eKYCPhoto = img.getKycPhotoBase64();
//					verifiedPhoto = img.getVerifiedPhotoBase64();
//					
					OriginalPhoto = null;
					eKYCPhoto = null;
					verifiedPhoto =null;
					
					
					OriginalPhoto_url=img.getOriginalPhotoUrl();
					eKYCPhoto_url = img.getKycPhotoUrl();
					verifiedPhoto_url=img.getVerifiedPhotoUrl();
					thumb_impression_url = img.getThumbImpressionUrl();
				}

				Document document =cust.getDocument();
				List<DocumentDetail> documentList = null;
				if(document!=null) {
					documentList = new ArrayList<DocumentDetail>();

//					String bank =  document.getDocument1Type();
//					String electricity = document.getDocument2Type();
//					String permit = document.getDocument3Type();
//					String visa = document.getDocument4Type();
//					String uid = document.getDocument5Type();
//					String water = document.getDocument6Type();
//					String telecom = document.getDocument7Type();
//					String consent = document.getDocument8Type();
					
					String bank =  null;
					String electricity = null;
					String permit = null;
					String visa = null;
					String uid = null;
					String water = null;
					String telecom = null;
					String consent = null;
					String incorporationLetter = null;
					String vat=null;
					String brn=null;
					String utility=null;
					String authorizationLetter=null;
					String emp_utility_org=null;
					String touristCert=null;
					String authorizationLetter_part2=null;
					String workPermit=null;
					
					
					
					
					
					
					String bank_url =  document.getDocumentUrl();
					String electricity_url = document.getDocument2Url();
					String permit_url = document.getDocument3Url();
					String visa_url = document.getDocument4Url();
					String uid_url = document.getDocument5Url();
					String water_url = document.getDocument6Url();
					String telecom_url = document.getDocument7Url();
					String consent_url = document.getDocument8Url();
					String incorporationLetter_url = document.getDocument9Url();
					String vat_url= document.getDocument10Url();
					String brn_url= document.getDocument11Url();
					String utility_url= document.getDocument12Url();
					String authorizationLetter_url= document.getDocument13Url();
					String emp_utility_org_url= document.getDocument14Url();
					String touristCert_url= document.getDocument15Url();
					String authorizationLetter_part2_url= document.getDocument16Url();
					String workPermit_url= document.getDocument17Url();
					
					
					
					if(bank_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("bank");
						documentDetail.setDocImage(bank);
						documentDetail.setDocImage_url(bank_url);
						documentList.add(documentDetail);
					}
					if(electricity_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("electricity");
						documentDetail.setDocImage(electricity);
						documentDetail.setDocImage_url(electricity_url);
						documentList.add(documentDetail);
					}
					if(permit_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("permit");
						documentDetail.setDocImage(permit);
						documentDetail.setDocImage_url(permit_url);
						documentList.add(documentDetail);
					}
					if(visa_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("visa");
						documentDetail.setDocImage(visa);
						documentDetail.setDocImage_url(visa_url);
						documentList.add(documentDetail);
					}
					if(uid_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("uid");
						documentDetail.setDocImage(uid);
						documentDetail.setDocImage_url(uid_url);
						documentList.add(documentDetail);
					}
					if(water_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("water");
						documentDetail.setDocImage(water);
						documentDetail.setDocImage_url(water_url);
						documentList.add(documentDetail);
					}
					if(telecom_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("telecom");
						documentDetail.setDocImage(telecom);
						documentDetail.setDocImage_url(telecom_url);
						documentList.add(documentDetail);
					}
					if(consent_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("consent");
						documentDetail.setDocImage(consent);
						documentDetail.setDocImage_url(consent_url);
						documentList.add(documentDetail);
					}
					
					
					
					if(incorporationLetter_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("incorporationLetter");
						documentDetail.setDocImage(incorporationLetter);
						documentDetail.setDocImage_url(incorporationLetter_url);
						documentList.add(documentDetail);
					}
					
					

					if(vat_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("vat");
						documentDetail.setDocImage(vat);
						documentDetail.setDocImage_url(vat_url);
						documentList.add(documentDetail);
					}
					
					

					if(brn_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("brn");
						documentDetail.setDocImage(brn);
						documentDetail.setDocImage_url(brn_url);
						documentList.add(documentDetail);
					}
					
					

					if(authorizationLetter_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("authorizationLetter");
						documentDetail.setDocImage(authorizationLetter);
						documentDetail.setDocImage_url(authorizationLetter_url);
						documentList.add(documentDetail);
					}
					
					

					if(emp_utility_org_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("emp_utility_org");
						documentDetail.setDocImage(emp_utility_org);
						documentDetail.setDocImage_url(emp_utility_org_url);
						documentList.add(documentDetail);
					}
					
					

					if(touristCert_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("touristCert");
						documentDetail.setDocImage(touristCert);
						documentDetail.setDocImage_url(touristCert_url);
						documentList.add(documentDetail);
					}
					
					

					if(authorizationLetter_part2_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("authorizationLetter_part2");
						documentDetail.setDocImage(authorizationLetter_part2);
						documentDetail.setDocImage_url(authorizationLetter_part2_url);
						documentList.add(documentDetail);
					}
					
					

					if(workPermit_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("workPermit");
						documentDetail.setDocImage(workPermit);
						documentDetail.setDocImage_url(workPermit_url);
						documentList.add(documentDetail);
					}
					
									
					
					
					
					
					
					
					
					
				}

				OtpDetail otpDetail = otpRepo.fetchOtpByToken(cust.getToken());
				SimDetail simDetail = cust.getSimDetail();
				SIMDetails simDetails = null;
				if(simDetail!=null) {
					simDetails = new SIMDetails();
					simDetails.setMSISDN(simDetail.getMsisdn());
					simDetails.setIMSI("");

					if(otpDetail!=null && otpDetail.getIsActive().equals("true")) {
						simDetails.setStatus("Otp verified");
					}
					else if(otpDetail!=null && otpDetail.getIsActive().equals("false")) {
						simDetails.setStatus("Otp sent");
					}
					else if(otpDetail==null) {
						simDetails.setStatus("Otp not sent");
					}
				}
				else {
					simDetails = new SIMDetails();
					simDetails.setMSISDN("");
					simDetails.setIMSI("");
					simDetails.setStatus("");
				}

				String ApplicationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cust.getCreateDate());

				//String ApplicationMode = "Self";
				String Status = cust.getKycStatus();
				String correlation_id = cust.getCorrelationId();
				String token = cust.getToken();

				Agent agent = null;
				List<AgentActivation> listActivation = agentActivationRepo.findByCustomerId(cust.getCustomerId()+"");
				if(listActivation!=null && listActivation.size()>0) {
					AgentActivation agentActivation =  listActivation.get(0);
					String agentId = agentActivation.getAgentId()==null || agentActivation.getAgentId().trim().equals("")?null:agentActivation.getAgentId();
					if(agentId!=null) {
						int intagentd = Integer.parseInt(agentId);
						//agent =  agentRepository.findOne(intagentd);
						agent =  agentRepository.getOne(intagentd);
						
						if(agent==null) {
							agent=null;
						}
					}
					else {agent=null;}

					//Agent agent =  agentRepository.getOne(Integer.parseInt(listActivation.get(0).getCustomerId()));
				}else {
					agent=null;
				}


				res.setPassportIssueDate(cust.getPassportDateIssued());
				res.setPassportExpiryDate(cust.getPassportDateExpired());
				res.setPassportFromDate(cust.getPassportDateFrom());
				res.setPassportToDate(cust.getPassportDateTo());
				res.setApplicationId(ApplicationId);
				res.setDateOfBirth(Date_Of_Birth);
				res.setDocumentId(DocumentId);
				res.setDocumentType(DocumentType);
				FullName = FullName.replace("null", "");
				res.setFullName(FullName);
				res.setGender(gender_);
				res.setNationality(Nationality);
				res.setRechargeType(rechargeType);
				res.setCustomerOrAgent(customerOrAgent);
				res.setUserType(UserType);
				res.setOriginalPhoto(OriginalPhoto);
				res.seteKYCPhoto(eKYCPhoto);
				res.setOriginalPhoto_url(OriginalPhoto_url);
				res.seteKYCPhoto_url(eKYCPhoto_url);
				res.setVerifiedPhoto_url(verifiedPhoto_url);
				res.setThumb_impression_url(thumb_impression_url);
				res.setSIMDetails(simDetails);
				res.setApplicationDate(ApplicationDate);
				res.setStatus(Status);
				res.setCorrelation_id(correlation_id);
				res.setVerifiedPhoto(verifiedPhoto);
				res.setToken(token);
				res.setDocumentDetailList(documentList);
				res.setAlternateNumber(alternateNumber);
				res.setNewCustomer(newCustomer);
				res.setEmail(email);
				res.setAgent(agent);
				res.setPmUid(pmUid);
				JSONObject crmInfoObj = null;
				JSONParser parser  = new JSONParser();
				crmInfoObj = (JSONObject)parser.parse(crmInfo);
				res.setCrmInfo(crmInfoObj);
				if(agent!=null) {

					res.setApplicationMode(agent.getAgentType());
					res.setAgentMsisdn(agent.getMsisdn());
					
				}
				else {
					res.setApplicationMode("Self");
					res.setAgentMsisdn(null);
				}
				res.setAddress(address);
				res.setPermitValue(permitValue);
				lsRes.add(res);
			}catch(Exception ex) {
				ex.printStackTrace();
				continue;
			}

			}
		}


		return lsRes;


	}



	@Override
	public ResponseEntity<CoreResponseHandler> savePermit(IdRequest3 idRequest,String value) {


		long l_time_start = System.currentTimeMillis();

		String token = idRequest.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
		if(customerDetail.getKycStatus().equals("verified")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"already verified",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
		}
		if(customerDetail.getKycStatus().equals("verification failed")  && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}
//verification failed
		if(!customerDetail.getKycStatus().equals("verified. Other doc proof also needed.") && !customerDetail.getKycStatus().equals("contingency not verified") && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"	. Status found : "+customerDetail.getKycStatus(),l_diff+" ms") ,HttpStatus.BAD_REQUEST);
		}

		String userType = customerDetail.getResidentType();
		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);


		if(customerDetail.getOtherDocCount()!=null && otherDocRequiredCount!=null && customerDetail.getOtherDocCount().equals(otherDocRequiredCount.getCounts())) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"documents already uploaded",l_diff+" ms") ,HttpStatus.OK);												
		}


		Document document = customerDetail.getDocument();
		if(document==null) {
			document=new Document();
		}
		Document_ d_ = new Document_();
		d_.setBase64(idRequest.getImage());
		d_.setImgType(value);
		d_.setToken(idRequest.getToken());

		Document document0 = null;
		
		document0 = docService.saveDocument(document, d_);

		if(document0!=null) {

		if(customerDetail.getOtherDocCount()==null || Integer.parseInt(customerDetail.getOtherDocCount())==0) {
			customerDetail.setOtherDocCount("1");
		}
		else {
			int count = Integer.parseInt(customerDetail.getOtherDocCount());
			customerDetail.setOtherDocCount(count+1+"");
		}


		//		String userType = customerDetail.getResidentType();
		//		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);
		if(otherDocRequiredCount.getCounts().equals(customerDetail.getOtherDocCount())) {
//			VerifiedMsisdn_ vm = new VerifiedMsisdn_();
//			vm.setToken(customerDetail.getToken());
//			SimDetail simDetail =  customerDetail.getSimDetail();
//			if(simDetail!=null)
//			vm.setMsisdn(simDetail.getMsisdn());
//			else
//				vm.setMsisdn(null);
//			vm.setSimDetail(simDetail);
//			boolean b = saveToVerifiedMsisdn(vm);
			customerDetail.setKycStatus("verified");			
		}

		}

		//customerDetail.setKycStatus("verified");
		customerDetail.setDocument(document0);
		customerDetail.setUpdateDate(new Date());

		CustomerDetail customerDetail0= custRepo.saveAndFlush(customerDetail);

		if(customerDetail0!=null && customerDetail0.getCustomerId()>0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			if(customerDetail0.getKycStatus().equals("verified")) {
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected. verified.",l_diff+" ms") ,HttpStatus.OK);																
			}
			else
			{
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected",l_diff+" ms") ,HttpStatus.OK);												
			}


		}


		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);




	}



	@Override
	public ResponseEntity<CoreResponseHandler> saveVisa(IdRequest3 idRequest) {


		long l_time_start = System.currentTimeMillis();

		String token = idRequest.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
		if(customerDetail.getKycStatus().equals("verified")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"already verified",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
		}
		if(customerDetail.getKycStatus().equals("verification failed") && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}
		if(!customerDetail.getKycStatus().equals("verified. Other doc proof also needed.") && !customerDetail.getKycStatus().equals("contingency not verified")  && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"	. Status found : "+customerDetail.getKycStatus(),l_diff+" ms") ,HttpStatus.BAD_REQUEST);
		}
		
		
		
		String userType = customerDetail.getResidentType();
		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);


		if(customerDetail.getOtherDocCount()!=null && otherDocRequiredCount!=null && customerDetail.getOtherDocCount().equals(otherDocRequiredCount.getCounts())) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"documents already uploaded.",l_diff+" ms") ,HttpStatus.OK);												
		}


		Document document = customerDetail.getDocument();
		if(document==null) {
			document=new Document();
		}
		Document_ d_ = new Document_();
		d_.setBase64(idRequest.getImage());
		d_.setImgType("other");
		d_.setToken(idRequest.getToken());

		Document document0 = null;
		
		document0 = docService.saveDocument(document, d_);

		if(document0!=null) {

		if(customerDetail.getOtherDocCount()==null || Integer.parseInt(customerDetail.getOtherDocCount())==0) {
			customerDetail.setOtherDocCount("1");
		}
		else {
			int count = Integer.parseInt(customerDetail.getOtherDocCount());
			customerDetail.setOtherDocCount(count+1+"");
		}


		//		String userType = customerDetail.getResidentType();
		//		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);
		if(otherDocRequiredCount.getCounts().equals(customerDetail.getOtherDocCount())) {
//			VerifiedMsisdn_ vm = new VerifiedMsisdn_();
//			vm.setToken(customerDetail.getToken());
//			SimDetail simDetail =  customerDetail.getSimDetail();
//			if(simDetail!=null)
//			vm.setMsisdn(simDetail.getMsisdn());
//			else
//				vm.setMsisdn(null);
//			vm.setSimDetail(simDetail);
//			boolean b = saveToVerifiedMsisdn(vm);
			customerDetail.setKycStatus("verified");			
		}

		}

		//customerDetail.setKycStatus("verified");
		customerDetail.setDocument(document0);
		customerDetail.setUpdateDate(new Date());

		CustomerDetail customerDetail0= custRepo.saveAndFlush(customerDetail);

		if(customerDetail0!=null && customerDetail0.getCustomerId()>0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			if(customerDetail0.getKycStatus().equals("verified")) {
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected. verified.",l_diff+" ms") ,HttpStatus.OK);																
			}
			else
			{
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected",l_diff+" ms") ,HttpStatus.OK);												
			}
		}


		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);




	}

	@Override
	public ResponseEntity<CoreResponseHandler> documentUpdate(DocumentUpdateRequest documentUpdateRequest) {

		long l_time_start = System.currentTimeMillis();

//		if(!documentUpdateRequest.getDocumentName().equals("bank") && !documentUpdateRequest.getDocumentName().equals("electricity") && !documentUpdateRequest.getDocumentName().equals("permit") && !documentUpdateRequest.getDocumentName().equals("other") && !documentUpdateRequest.getDocumentName().equalsIgnoreCase("uid") ) {
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"allowed documentName : bank,electricity,permit,visa",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
//		}

		String token = documentUpdateRequest.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
//		if(!customerDetail.getKycStatus().equals("verified")) {
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"not verified. can not update document",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
//		}

		Document document = customerDetail.getDocument();

//		if(document==null) {
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no document detail found against this token",l_diff+" ms"),HttpStatus.NOT_FOUND);
//
//		}
		//		switch (documentUpdateRequest.getDocumentName()) {
		//		case "bank":
		//			
		//				String bank = document.getDocument1Type();
		//				if(bank==null) {
		//					long l_end_time = System.currentTimeMillis();
		//					long l_diff = l_end_time-l_time_start;
		//					return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "there is no bank document in your records to update",l_diff+" ms"),HttpStatus.NOT_FOUND);
		//
		//				}
		//			
		//			
		//			break;
		//
		//		default:
		//			break;
		//		}

		Document_ d_ = new Document_();
		d_.setBase64(documentUpdateRequest.getImage());
		d_.setImgType(documentUpdateRequest.getDocumentName());
		d_.setToken(documentUpdateRequest.getToken());

		Document document0 = docService.saveDocument(document, d_);

		if(document0!=null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;

			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document updated",l_diff+" ms") ,HttpStatus.OK);
		}

		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<CoreResponseHandler> msisdnUpdate(MsisdnUpdate msisdnUpdate) {
		long l_time_start = System.currentTimeMillis();

		if(!msisdnUpdate.getNewCustomer().equals("yes")&& !msisdnUpdate.getNewCustomer().equals("no")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"newCustomer value only 'yes' or 'no' allowed",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}

		String token = msisdnUpdate.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}

		SimDetail simDetail =  customerDetail.getSimDetail();
		customerDetail.setRechargeType(msisdnUpdate.getRechargeType());
		if(simDetail==null) {
			System.out.println("msisdnUpdate CASE: SIM DETAIL NULL ____1");
			customerDetail.setNewCustomer(msisdnUpdate.getNewCustomer());
			if(msisdnUpdate.getNewCustomer().equals("yes")) {
				System.out.println("msisdnUpdate CASE :YES: SIM DETAIL NULL ");
				simDetail = new SimDetail();
				simDetail.setMsisdn(msisdnUpdate.getMsisdn());
				simDetail.setImsi(msisdnUpdate.getIccid());
				SimDetail simDetail2 = simRepo.saveAndFlush(simDetail);
				customerDetail.setSimDetail(simDetail2);
				customerDetail.setUpdateDate(new Date());
				customerDetail.setNewCustomer("yes");
				custService.updateCustomer(customerDetail, "");
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;

				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"updated",l_diff+" ms") ,HttpStatus.OK);

			}
			else {
				System.out.println("msisdnUpdate CASE :NO: SIM DETAIL NULL ");
				simDetail = new SimDetail();
				simDetail.setMsisdn(msisdnUpdate.getMsisdn());
				simDetail.setImsi(msisdnUpdate.getIccid());
				SimDetail simDetail2 = simRepo.saveAndFlush(simDetail);
				customerDetail.setSimDetail(simDetail2);
				customerDetail.setUpdateDate(new Date());
				customerDetail.setNewCustomer("no");
				custService.updateCustomer(customerDetail, "");
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;

				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"updated",l_diff+" ms") ,HttpStatus.OK);

			}


		}
		else if(simDetail!=null){
			System.out.println("msisdnUpdate CASE: SIM DETAIL NOT NULL ___2 ");
			String msisdn = msisdnUpdate.getMsisdn();
			if(simDetail.getMsisdn().contains(msisdn)) {
				System.out.println("SAME MSISDN CASE");
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;

				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"updated",l_diff+" ms") ,HttpStatus.OK);

			}
			else {
				System.out.println("msisdnUpdate CASE: SIM DETAIL COMMA CASE");
				customerDetail.setNewCustomer(msisdnUpdate.getNewCustomer());
				customerDetail.setUpdateDate(new Date());
				custService.updateCustomer(customerDetail, "");
				String msisdnSim =  simDetail.getMsisdn();
				msisdnSim = msisdnSim+","+msisdn;
				simDetail.setMsisdn(msisdnSim);

				simRepo.saveAndFlush(simDetail);
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;

				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"updated",l_diff+" ms") ,HttpStatus.OK);
			}
		}

		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);


	}




	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public ResponseEntity<CoreResponseHandler> statusUpdate(StatusUpdate statusUpdate) {
		long l_time_start = System.currentTimeMillis();

		if(statusUpdate.getType().equalsIgnoreCase("customer")) {
		
		String token = statusUpdate.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}

//		if(!statusUpdate.getStatus().equals("verification failed") && !statusUpdate.getStatus().equals("verified. Other doc proof also needed.") && !statusUpdate.getStatus().equals("id proof submitted")
//				&&	!statusUpdate.getStatus().equals("verified")) {
//
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"allowed status are : id proof submitted,verification failed,verified. Other doc proof also needed.,verified",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
//
//		}

		if(statusUpdate.getStatus().equals("verified")) {
//			VerifiedMsisdn_ vm = new VerifiedMsisdn_();
//			vm.setToken(customerDetail.getToken());
//			SimDetail simDetail =  customerDetail.getSimDetail();
//			if(simDetail!=null)
//			vm.setMsisdn(simDetail.getMsisdn());
//			else
//				vm.setMsisdn(null);
//			vm.setSimDetail(simDetail);
//			boolean b = saveToVerifiedMsisdn(vm);
		}
		if(statusUpdate.getStatus().equalsIgnoreCase("Activated") || statusUpdate.getStatus().equalsIgnoreCase("Activate") || statusUpdate.getStatus().equalsIgnoreCase("Active")) {
			VerifiedMsisdn_ vm = new VerifiedMsisdn_();
			vm.setToken(customerDetail.getToken());
			SimDetail simDetail =  customerDetail.getSimDetail();
			if(simDetail!=null)
			vm.setMsisdn(simDetail.getMsisdn());
			else
				vm.setMsisdn(null);
			vm.setSimDetail(simDetail);
			boolean b = saveToVerifiedMsisdn(vm);
		}
		
		
		
		
		customerDetail.setKycStatus(statusUpdate.getStatus());
		customerDetail.setUpdateDate(new Date());

		CustomerDetail cust0 =  custService.updateCustomer(customerDetail, "");

		if(cust0!=null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;

			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"updated",l_diff+" ms") ,HttpStatus.OK);

		}
		}
		else if(statusUpdate.getType().equalsIgnoreCase("employee")) {
			String token = statusUpdate.getToken();
			Employee customerDetail = empRepo.findByToken(token);
			if(customerDetail==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no employee in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);
				
			}
			if(statusUpdate.getStatus().equals("verified")) {
//				VerifiedMsisdn_ vm = new VerifiedMsisdn_();
//				vm.setToken(customerDetail.getToken());
//				SimDetail simDetail =  customerDetail.getSimDetail();
//				if(simDetail!=null)
//				vm.setMsisdn(simDetail.getMsisdn());
//				else
//					vm.setMsisdn(null);
//				vm.setSimDetail(simDetail);
//				boolean b = saveToVerifiedMsisdn(vm);
			}
			customerDetail.setKycStatus(statusUpdate.getStatus());
			customerDetail.setUpdateDate(new Date());
			Employee cust0 = empRepo.save(customerDetail);
			if(cust0!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;

				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"updated",l_diff+" ms") ,HttpStatus.OK);

			}
		}
		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<CoreResponseHandler> saveAgentActivation(AgentActivation_ agentActivation_) {
		long l_time_start = System.currentTimeMillis();

		String token = agentActivation_.getToken();
		
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
		String agentNumber = agentActivation_.getAgentnumber();
		Agent agent = agentRepository.findByMsisdn(agentNumber);
		if(agent==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no agent found",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
		String agentId = agent.getId()+"";
		String strCustomerId = customerDetail.getCustomerId()+"";
		AgentActivation agentActivation = new AgentActivation();
		agentActivation.setActivationDate(agentActivation_.getDate());
		agentActivation.setActivationStatus(agentActivation_.getActivation_status());
		agentActivation.setAgentId(agentId);
		agentActivation.setCustomerId(strCustomerId);
		agentActivation.setKycStatus(agentActivation_.getKyc_status());
		agentActivation.setRemarks(null);

		AgentActivation agentActivation2 =  agentActivationRepo.saveAndFlush(agentActivation);

		if(agentActivation2!=null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;

			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"saved",l_diff+" ms") ,HttpStatus.OK);

		}


		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Autowired
	private SpecialMsisdnsRepository specialMsisdnsRepo;

	@Override
	public ResponseEntity<CoreResponseHandler> specialMsisdnSave(SpecialMsisdns_ specialMsisdns_) {
		// TODO Auto-generated method stub
		long l_time_start = System.currentTimeMillis();

		String prefix = specialMsisdns_.getMsisdnPrefix();
		SpecialMsisdns specialMsisdns =  specialMsisdnsRepo.findByMsisdnPrefix(prefix);

		if(specialMsisdns!=null && specialMsisdns.getId()>0) {

			specialMsisdns.setMsisdn_length(specialMsisdns_.getMsisdnLength());
			specialMsisdnsRepo.saveAndFlush(specialMsisdns);
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;

			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already there with this prefix, updated with length.",l_diff+" ms") ,HttpStatus.OK);

		}
		else {
			specialMsisdns = new SpecialMsisdns();
			specialMsisdns.setMsisdnPrefix(specialMsisdns_.getMsisdnPrefix());
			specialMsisdns.setMsisdn_length(specialMsisdns_.getMsisdnLength());
			specialMsisdnsRepo.saveAndFlush(specialMsisdns);
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;

			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"saved",l_diff+" ms") ,HttpStatus.OK);

		}

	}



	@Override
	public ResponseEntity<CoreResponseHandler> specialMsisdnVerify(VerifyMsisdnSpecial verifyMsisdnSpecial) {
		long l_time_start = System.currentTimeMillis();


		List<SpecialMsisdns> list =  specialMsisdnsRepo.findAll();
		if(list==null || list.size()==0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "prefixes empty",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
		String found = "not found";

		for(SpecialMsisdns specialMsisdns:list) {
			if(verifyMsisdnSpecial.getMsisdn().startsWith(specialMsisdns.getMsisdnPrefix())) {
				found = "found";
				break;
			}
		}

		JSONObject obj = new JSONObject();
		if(found.equals("found")) {
			obj.put("found", true);
		}
		else {
			obj.put("found", false);
		}
		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;

		return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,obj,l_diff+" ms") ,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CoreResponseHandler> checkAgent(String msisdn) {
		long l_time_start = System.currentTimeMillis();

		Agent agent =  agentRepository.findByMsisdn(msisdn);
		if(agent==null || agent.getId()<=0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "agent not found",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}

		String agentType = agent.getAgentType()==null||agent.getAgentType().equals("")?"no agent type found":agent.getAgentType();

		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;

		return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,agentType,l_diff+" ms") ,HttpStatus.OK);			

	}

	@Override
	public ResponseEntity<CoreResponseHandler> agentLogin(AgentLogin agentLogin){
		long l_time_start = System.currentTimeMillis();


		Agent agent =  agentRepository.findByUserNameAndPassword(agentLogin.getUserName(), agentLogin.getPassword());
		if(agent==null || agent.getId()<=0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "invalid username or password",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}

		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;

		return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,agent,l_diff+" ms") ,HttpStatus.OK);			

	}
	@Autowired
	private AgentActivationRepository activationRepo;
	@Override
	public ResponseEntity<CoreResponseHandler> agentGet(String msisdn) {
		long l_time_start = System.currentTimeMillis();

		Agent agent =  agentRepository.findByMsisdn(msisdn);

		if(agent==null || agent.getId()<=0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "agent not found",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}

		List<AgentActivation> listActivation = activationRepo.findByAgentId(agent.getId()+"");
		if(listActivation==null || listActivation.size()==0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "agent activation not found",l_diff+" ms"),HttpStatus.NOT_FOUND);			
		}
		List<AgentActivationData_> listAgentActivationData_ = new ArrayList<AgentActivationData_>();
		for(AgentActivation agentActivation:listActivation) {
			AgentActivationData_  agentActivationData_ = new AgentActivationData_();
			String activationStatus =  agentActivation.getActivationStatus();
			String dealerType = agent.getAgentType();
			String agentMsisdn = msisdn;
			String name = agent.getAgentName();
			agentActivationData_.setActivationStatus(activationStatus);
			agentActivationData_.setDealerType(dealerType);
			agentActivationData_.setDealerMsisdn(agentMsisdn);
			agentActivationData_.setDealerName(name);
			String strCustId =  agentActivation.getCustomerId();
			if(strCustId!=null && !strCustId.equals("")) {
				int custId  = Integer.parseInt(strCustId);
				CustomerDetail customerDetail=  custRepo.getOne(custId);
				agentActivationData_.setPassportIssueDate(customerDetail.getPassportDateIssued());
				agentActivationData_.setPassportExpiryDate(customerDetail.getPassportDateExpired());
				agentActivationData_.setPassportToDate(customerDetail.getPassportDateTo());
				agentActivationData_.setPassportFromDate(customerDetail.getPassportDateFrom());
				
				Document document =customerDetail.getDocument();
				List<DocumentDetail> documentList = null;
				if(document!=null) {
					documentList = new ArrayList<DocumentDetail>();

//					String bank =  document.getDocument1Type();
//					String electricity = document.getDocument2Type();
//					String permit = document.getDocument3Type();
//					String visa = document.getDocument4Type();
//					String uid = document.getDocument5Type();
					
					
					String bank =  null;
					String electricity = null;
					String permit = null;
					String visa = null;
					String uid = null;
					String water = null;
					String telecom = null;
					String consent = null;
					
					String bank_url =  document.getDocumentUrl();
					String electricity_url = document.getDocument2Url();
					String permit_url = document.getDocument3Url();
					String visa_url = document.getDocument4Url();
					String uid_url = document.getDocument5Url();
					String water_url = document.getDocument6Url();
					String telecom_url = document.getDocument7Url();
					String consent_url = document.getDocument8Url();
					
					
					
					
					
//					if(bank!=null) {
//						DocumentDetail documentDetail = new DocumentDetail();
//						documentDetail.setDocName("bank");
//						documentDetail.setDocImage(bank);
//						documentList.add(documentDetail);
//					}
//					if(electricity!=null) {
//						DocumentDetail documentDetail = new DocumentDetail();
//						documentDetail.setDocName("electricity");
//						documentDetail.setDocImage(electricity);
//
//						documentList.add(documentDetail);
//					}
//					if(permit!=null) {
//						DocumentDetail documentDetail = new DocumentDetail();
//						documentDetail.setDocName("permit");
//						documentDetail.setDocImage(permit);
//
//						documentList.add(documentDetail);
//					}
//					if(visa!=null) {
//						DocumentDetail documentDetail = new DocumentDetail();
//						documentDetail.setDocName("visa");
//						documentDetail.setDocImage(visa);
//
//						documentList.add(documentDetail);
//					}
//					if(uid!=null) {
//						DocumentDetail documentDetail = new DocumentDetail();
//						documentDetail.setDocName("uid");
//						documentDetail.setDocImage(uid);
//
//						documentList.add(documentDetail);
//					}
					
					
					
					
					
					
					
					
					
					
					
					

					
					if(bank_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("bank");
						documentDetail.setDocImage(bank);
						documentDetail.setDocImage_url(bank_url);
						documentList.add(documentDetail);
					}
					if(electricity_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("electricity");
						documentDetail.setDocImage(electricity);
						documentDetail.setDocImage_url(electricity_url);
						documentList.add(documentDetail);
					}
					if(permit_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("permit");
						documentDetail.setDocImage(permit);
						documentDetail.setDocImage_url(permit_url);
						documentList.add(documentDetail);
					}
					if(visa_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("visa");
						documentDetail.setDocImage(visa);
						documentDetail.setDocImage_url(visa_url);
						documentList.add(documentDetail);
					}
					if(uid_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("uid");
						documentDetail.setDocImage(uid);
						documentDetail.setDocImage_url(uid_url);
						documentList.add(documentDetail);
					}
					if(water_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("water");
						documentDetail.setDocImage(water);
						documentDetail.setDocImage_url(water_url);
						documentList.add(documentDetail);
					}
					if(telecom_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("telecom");
						documentDetail.setDocImage(telecom);
						documentDetail.setDocImage_url(telecom_url);
						documentList.add(documentDetail);
					}
					if(consent_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("consent");
						documentDetail.setDocImage(consent);
						documentDetail.setDocImage_url(consent_url);
						documentList.add(documentDetail);
					}
					
					
				}
				
				
				
				agentActivationData_.setDocumentList(documentList);
				String docId = null;
				if(document!=null) {
					docId = document.getDocumentId()+"";
				}
				agentActivationData_.setDocumentId(docId);
				agentActivationData_.setActivationDate(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(customerDetail.getCreateDate()));
				
				
				
				
				String customerMsisdn = null;
				String alternateNumber = customerDetail.getAlternateNumber()==null||customerDetail.getAlternateNumber().equals("")?"":customerDetail.getAlternateNumber();
				agentActivationData_.setCustomerAlternate(alternateNumber);
				agentActivationData_.setCustomerDetail(customerDetail);
				SimDetail simDetail = customerDetail.getSimDetail();
				if(simDetail!=null) {
					customerMsisdn = simDetail.getMsisdn();
					agentActivationData_.setCustomerMsisdn(customerMsisdn);
				}
				
				
				
				if(customerMsisdn!=null && !customerMsisdn.contains(",")) {
					
				
				List<OtpDetail> otpDetailList = otpRepo.findMsisdn(customerMsisdn);
				OtpDetail otpDetail = null;
				if(otpDetailList!=null && otpDetailList.size()>0) {
					otpDetail = otpDetailList.get(0);					
				}


					if(otpDetail!=null && otpDetail.getIsActive().equals("true")) {
						agentActivationData_.setOtpStatus("Otp verified");
					}
					else if(otpDetail!=null && otpDetail.getIsActive().equals("false")) {
						agentActivationData_.setOtpStatus("Otp sent");
					}
					else if(otpDetail==null) {
						agentActivationData_.setOtpStatus("Otp not sent");
					}
				
				
				
				
				}
				
				if(customerDetail!=null) {
				String resType = customerDetail.getResidentType()==null || customerDetail.getResidentType().equals("")?"":customerDetail.getResidentType();
				String UserType = null;
				if(resType!=null && !resType.equals("")&& resType.equals("citizen")) {
					UserType = "CITIZEN";
				}
				else if(resType!=null && !resType.equals("")&& resType.equals("tourist")) {
					UserType = "TOURIST";
				}
				else if(resType!=null && !resType.equals("")&& resType.equals("resident")) {
					UserType = "RESIDENT";
				}
				else {
					UserType = "";
				}
				String DocumentType = null;
				if(UserType.equals("CITIZEN")) {
					DocumentType = "National ID";
				}
				else {
					DocumentType = "Passport";
				}
				
				agentActivationData_.setCustomerType(UserType);
				agentActivationData_.setCustomerIDType(DocumentType);
				}
			}
			
			listAgentActivationData_.add(agentActivationData_);
		}


		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;

		return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,listAgentActivationData_,l_diff+" ms") ,HttpStatus.OK);			

	}

	@Override
	public ResponseEntity<CoreResponseHandler> saveUID(IdRequest3 idRequest) {



		long l_time_start = System.currentTimeMillis();

		String token = idRequest.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
		if(customerDetail.getKycStatus().equals("verified")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"already verified",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
		}
		if(customerDetail.getKycStatus().equals("verification failed")  && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}
		if(!customerDetail.getKycStatus().equals("verified. Other doc proof also needed.") && !customerDetail.getKycStatus().equals("contingency not verified") && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"	. Status found : "+customerDetail.getKycStatus(),l_diff+" ms") ,HttpStatus.BAD_REQUEST);
		}

		String userType = customerDetail.getResidentType();
		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);


		if(customerDetail.getOtherDocCount()!=null && otherDocRequiredCount!=null && customerDetail.getOtherDocCount().equals(otherDocRequiredCount.getCounts())) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"documents already uploaded.",l_diff+" ms") ,HttpStatus.OK);												
		}


		Document document = customerDetail.getDocument();
		if(document==null) {
			document=new Document();
		}
		Document_ d_ = new Document_();
		d_.setBase64(idRequest.getImage());
		d_.setImgType("UID");
		d_.setToken(idRequest.getToken());

Document document0 = null;
		
		document0 = docService.saveDocument(document, d_);

		if(document0!=null) {

		if(customerDetail.getOtherDocCount()==null || Integer.parseInt(customerDetail.getOtherDocCount())==0) {
			customerDetail.setOtherDocCount("1");
		}
		else {
			int count = Integer.parseInt(customerDetail.getOtherDocCount());
			customerDetail.setOtherDocCount(count+1+"");
		}


		//		String userType = customerDetail.getResidentType();
		//		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);
		if(otherDocRequiredCount.getCounts().equals(customerDetail.getOtherDocCount())) {
//			VerifiedMsisdn_ vm = new VerifiedMsisdn_();
//			vm.setToken(customerDetail.getToken());
//			SimDetail simDetail =  customerDetail.getSimDetail();
//			if(simDetail!=null)
//			vm.setMsisdn(simDetail.getMsisdn());
//			else
//				vm.setMsisdn(null);
//			vm.setSimDetail(simDetail);
//			boolean b = saveToVerifiedMsisdn(vm);
			customerDetail.setKycStatus("verified");			
		}

		}

		//customerDetail.setKycStatus("verified");
		customerDetail.setDocument(document0);
		customerDetail.setUpdateDate(new Date());

		CustomerDetail customerDetail0= custRepo.saveAndFlush(customerDetail);

		if(customerDetail0!=null && customerDetail0.getCustomerId()>0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			if(customerDetail0.getKycStatus().equals("verified")) {
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected. verified.",l_diff+" ms") ,HttpStatus.OK);																
			}
			else
			{
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected",l_diff+" ms") ,HttpStatus.OK);												
			}
		}


		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);





	}

	@Override
	public ResponseEntity<CoreResponseHandler> agentDealerGet(String type) {
		long l_time_start = System.currentTimeMillis();

		List<Agent> agent =  agentRepository.findByAgentType(type);
		if(agent==null || agent.size() <=0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "agent not found",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}


		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;

		return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,agent,l_diff+" ms") ,HttpStatus.OK);			

	}



	@Override
	public ResponseEntity<CoreResponseHandler> saveAgent(Agent_ agent_) {
		long l_time_start = System.currentTimeMillis();

		String agentId = agent_.getAgentId();
		String agentName = agent_.getAgentName();
		String businessName = agent_.getBusinessName();
		String type = agent_.getType();
		String password = agent_.getPassword();
		String userName = agent_.getUserName();
		String msisdn = agent_.getMsisdn();
		Agent agent = new Agent();

		agent.setAgentID(agentId);
		agent.setAgentName(agentName);
		agent.setAgentType(type);
		agent.setPassword(password);
		agent.setUserName(userName);
		agent.setAgentBusinessName(businessName);
		agent.setOtp("0");
		agent.setIsOtpconsumed("0");
		agent.setMpin("0");
		agent.setMsisdn(msisdn);
		agent.setOtpCreatedate(new Date());
		Agent agent2 =  agentRepository.saveAndFlush(agent);
		if(agent2!=null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;

			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,agent,l_diff+" ms") ,HttpStatus.OK);			

		}
		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);


	}

	@Override
	public ResponseEntity<CoreResponseHandler> savePermitValue(String token, String permitValue) {
		long l_time_start = System.currentTimeMillis();

		CustomerDetail customerDetail = custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "customer not found",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}

		customerDetail.setPermitValue(permitValue);
		customerDetail.setUpdateDate(new Date());
		
		CustomerDetail custDetail =  custService.updateCustomer(customerDetail, "");
		if(custDetail!=null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;

			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"updated",l_diff+" ms") ,HttpStatus.OK);			

		}
		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<CoreResponseHandler> saveWater(IdRequest3 idRequest) {


		long l_time_start = System.currentTimeMillis();

		String token = idRequest.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
		if(customerDetail.getKycStatus().equals("verified")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"already verified",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
		}
		if(customerDetail.getKycStatus().equals("verification failed")  && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}
		if(!customerDetail.getKycStatus().equals("verified. Other doc proof also needed.") && !customerDetail.getKycStatus().equals("contingency not verified") && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"	. Status found : "+customerDetail.getKycStatus(),l_diff+" ms") ,HttpStatus.BAD_REQUEST);
		}
		
		
		
		String userType = customerDetail.getResidentType();
		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);


		if(customerDetail.getOtherDocCount()!=null && otherDocRequiredCount!=null && customerDetail.getOtherDocCount().equals(otherDocRequiredCount.getCounts())) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"documents already uploaded.",l_diff+" ms") ,HttpStatus.OK);												
		}


		Document document = customerDetail.getDocument();
		if(document==null) {
			document=new Document();
		}
		Document_ d_ = new Document_();
		d_.setBase64(idRequest.getImage());
		d_.setImgType("water");
		d_.setToken(idRequest.getToken());

		Document document0 = null;
		
		document0 = docService.saveDocument(document, d_);

		if(document0!=null) {

		if(customerDetail.getOtherDocCount()==null || Integer.parseInt(customerDetail.getOtherDocCount())==0) {
			customerDetail.setOtherDocCount("1");
		}
		else {
			int count = Integer.parseInt(customerDetail.getOtherDocCount());
			customerDetail.setOtherDocCount(count+1+"");
		}


		//		String userType = customerDetail.getResidentType();
		//		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);
		if(otherDocRequiredCount.getCounts().equals(customerDetail.getOtherDocCount())) {
//			VerifiedMsisdn_ vm = new VerifiedMsisdn_();
//			vm.setToken(customerDetail.getToken());
//			SimDetail simDetail =  customerDetail.getSimDetail();
//			if(simDetail!=null)
//			vm.setMsisdn(simDetail.getMsisdn());
//			else
//				vm.setMsisdn(null);
//			vm.setSimDetail(simDetail);
//			boolean b = saveToVerifiedMsisdn(vm);
			customerDetail.setKycStatus("verified");			
		}

		}

		//customerDetail.setKycStatus("verified");
		customerDetail.setDocument(document0);
		customerDetail.setUpdateDate(new Date());

		CustomerDetail customerDetail0= custRepo.saveAndFlush(customerDetail);

		if(customerDetail0!=null && customerDetail0.getCustomerId()>0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			if(customerDetail0.getKycStatus().equals("verified")) {
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected. verified.",l_diff+" ms") ,HttpStatus.OK);																
			}
			else
			{
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected",l_diff+" ms") ,HttpStatus.OK);												
			}
		}


		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);




	}

	@Override
	public ResponseEntity<CoreResponseHandler> saveConsent(IdRequest3 idRequest) {


		long l_time_start = System.currentTimeMillis();

		String token = idRequest.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
		if(customerDetail.getKycStatus().equals("verified")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"already verified",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
		}
		if(customerDetail.getKycStatus().equals("verification failed")  && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}
		if(!customerDetail.getKycStatus().equals("verified. Other doc proof also needed.") && !customerDetail.getKycStatus().equals("contingency not verified") && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"	. Status found : "+customerDetail.getKycStatus(),l_diff+" ms") ,HttpStatus.BAD_REQUEST);
		}
		
		
		
		String userType = customerDetail.getResidentType();
		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);


		if(customerDetail.getOtherDocCount()!=null && otherDocRequiredCount!=null && customerDetail.getOtherDocCount().equals(otherDocRequiredCount.getCounts())) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"documents already uploaded.",l_diff+" ms") ,HttpStatus.OK);												
		}


		Document document = customerDetail.getDocument();
		if(document==null) {
			document=new Document();
		}
		Document_ d_ = new Document_();
		d_.setBase64(idRequest.getImage());
		d_.setImgType("consent");
		d_.setToken(idRequest.getToken());

Document document0 = null;
		
		document0 = docService.saveDocument(document, d_);

		if(document0!=null) {

		if(customerDetail.getOtherDocCount()==null || Integer.parseInt(customerDetail.getOtherDocCount())==0) {
			customerDetail.setOtherDocCount("1");
		}
		else {
			int count = Integer.parseInt(customerDetail.getOtherDocCount());
			customerDetail.setOtherDocCount(count+1+"");
		}


		//		String userType = customerDetail.getResidentType();
		//		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);
		if(otherDocRequiredCount.getCounts().equals(customerDetail.getOtherDocCount())) {
//			VerifiedMsisdn_ vm = new VerifiedMsisdn_();
//			vm.setToken(customerDetail.getToken());
//			SimDetail simDetail =  customerDetail.getSimDetail();
//			if(simDetail!=null)
//			vm.setMsisdn(simDetail.getMsisdn());
//			else
//				vm.setMsisdn(null);
//			vm.setSimDetail(simDetail);
//			boolean b = saveToVerifiedMsisdn(vm);
			customerDetail.setKycStatus("verified");			
		}

		}

		//customerDetail.setKycStatus("verified");
		customerDetail.setDocument(document0);
		customerDetail.setUpdateDate(new Date());

		CustomerDetail customerDetail0= custRepo.saveAndFlush(customerDetail);

		if(customerDetail0!=null && customerDetail0.getCustomerId()>0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			if(customerDetail0.getKycStatus().equals("verified")) {
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected. verified.",l_diff+" ms") ,HttpStatus.OK);																
			}
			else
			{
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected",l_diff+" ms") ,HttpStatus.OK);												
			}
		}


		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);




	}

	@Override
	public ResponseEntity<CoreResponseHandler> saveTelecom(IdRequest3 idRequest) {


		long l_time_start = System.currentTimeMillis();

		String token = idRequest.getToken();
		CustomerDetail customerDetail =  custService.findByToken(token);
		if(customerDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}
		if(customerDetail.getKycStatus().equals("verified")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"already verified",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
		}
		if(customerDetail.getKycStatus().equals("verification failed")  && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"verification failed last time, first verify yourself. Then, try again later with this document.",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}
		if(!customerDetail.getKycStatus().equals("verified. Other doc proof also needed.") && !customerDetail.getKycStatus().equals("contingency not verified") && customerDetail.getResidentType().equals("citizen")) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already verified",l_diff+" ms") ,HttpStatus.OK);												
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"	. Status found : "+customerDetail.getKycStatus(),l_diff+" ms") ,HttpStatus.BAD_REQUEST);
		}
		
		
		
		String userType = customerDetail.getResidentType();
		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);


		if(customerDetail.getOtherDocCount()!=null && otherDocRequiredCount!=null && customerDetail.getOtherDocCount().equals(otherDocRequiredCount.getCounts())) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"documents already uploaded.",l_diff+" ms") ,HttpStatus.OK);												
		}


		Document document = customerDetail.getDocument();
		if(document==null) {
			document=new Document();
		}
		Document_ d_ = new Document_();
		d_.setBase64(idRequest.getImage());
		d_.setImgType("telecom");
		d_.setToken(idRequest.getToken());

Document document0 = null;
		
		document0 = docService.saveDocument(document, d_);

		if(document0!=null) {

		if(customerDetail.getOtherDocCount()==null || Integer.parseInt(customerDetail.getOtherDocCount())==0) {
			customerDetail.setOtherDocCount("1");
		}
		else {
			int count = Integer.parseInt(customerDetail.getOtherDocCount());
			customerDetail.setOtherDocCount(count+1+"");
		}


		//		String userType = customerDetail.getResidentType();
		//		OtherDocRequiredCount otherDocRequiredCount = otherDocRepo.findByUserType(userType);
		if(otherDocRequiredCount.getCounts().equals(customerDetail.getOtherDocCount())) {
//			VerifiedMsisdn_ vm = new VerifiedMsisdn_();
//			vm.setToken(customerDetail.getToken());
//			SimDetail simDetail =  customerDetail.getSimDetail();
//			if(simDetail!=null)
//			vm.setMsisdn(simDetail.getMsisdn());
//			else
//				vm.setMsisdn(null);
//			vm.setSimDetail(simDetail);
//			boolean b = saveToVerifiedMsisdn(vm);
			customerDetail.setKycStatus("verified");			
		}

		}

		//customerDetail.setKycStatus("verified");
		customerDetail.setDocument(document0);
		customerDetail.setUpdateDate(new Date());

		CustomerDetail customerDetail0= custRepo.saveAndFlush(customerDetail);

		if(customerDetail0!=null && customerDetail0.getCustomerId()>0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			if(customerDetail0.getKycStatus().equals("verified")) {
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected. verified.",l_diff+" ms") ,HttpStatus.OK);																
			}
			else
			{
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"document collected",l_diff+" ms") ,HttpStatus.OK);												
			}
		}


		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);




	}
	
	private String getAccessToken() {
//		
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//
//		JSONObject obj =new JSONObject();
//		obj.put("password", "1s84jBiV6ZpHO6VR5B");
//		obj.put("username", "mtml");
//
//		ResponseEntity<SimAccessToken> response = null;
//		HttpEntity formEntity = new HttpEntity(obj, headers);
//		try {
//			response = restTemplate0.exchange("https://simapi.icta.mu/icta/auth/login", HttpMethod.POST,
//					formEntity, SimAccessToken.class);
//			if(response==null) {
//				
//				return	null;
//			}
//			if(response!=null) {
//
//				SimAccessToken simAccessToken = response.getBody();
//				if(simAccessToken==null) {
//					return null;
//				}
//				return simAccessToken.getAccessToken();
//				//return callSimApi(simAccessToken.getAccessToken(),customerDetail2);
//			}
//		} catch (HttpStatusCodeException ex) {
//			System.out.println("Exception...");
//			ex.printStackTrace();
//			}
//		catch(Exception ex22) {
//			System.out.println("###########################");
//			ex22.printStackTrace();
//		}
		return null;
	}

	@Override
	public ResponseEntity<CoreResponseHandler> nicVerify(JSONObject obj) {
//		
//		// TODO Auto-generated method stub
//		 String accessToken =  getAccessToken();
//
//			long l_diff = 0;
//			long l_time_start = System.currentTimeMillis();
//			CustomerDetail customerDetail_ =null;
//			SimNicResponse simNicResponse = null;
//			RestTemplate restTemplate = new RestTemplate();
//
//			HttpHeaders headers = new HttpHeaders();
//			headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//			headers.add("Authorization", "Bearer "+accessToken);
//			ResponseEntity<SimNicResponse> response = null;
//			HttpEntity formEntity = new HttpEntity(obj, headers);
//			
//			String token =(String) obj.get("token");
//			String newCustomer = (String)obj.get("newCustomer");
//			CustomerDetail customerDetail =  custService.findByToken(token);
//			
//			
//			try {
//				response = restTemplate0.exchange("https://simapi.icta.mu/icta/verifyNIC", HttpMethod.POST,
//						formEntity, SimNicResponse.class);
//				if(response==null) {
//					long l_end_time = System.currentTimeMillis();
//					l_diff = l_end_time-l_time_start;
//					return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//				}
//				if(response!=null) {
//					simNicResponse = response.getBody();
//					if(simNicResponse==null) {
//						long l_end_time = System.currentTimeMillis();
//						l_diff = l_end_time-l_time_start;
//						return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//					}
//
//					System.out.println(simNicResponse);
//					if(!customerDetail.getKycStatus().equals("contingency not verified")) {
//					//customerDetail.setKycStatus("verified. Other doc proof also needed.");
//					
//					}
//					customerDetail.setCorrelationId(simNicResponse.getCorrelationId());
//					customerDetail.setUpdateDate(new Date());
//					CustomerDetail customerDetail2 =  custService.updateCustomer(customerDetail, "");
//					
//					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,simNicResponse,null) ,HttpStatus.OK);
////					customerDetail_ = custService.findByID(simNicResponse.getNicNum());
////					if(customerDetail_==null) {
////						long l_end_time = System.currentTimeMillis();
////						l_diff = l_end_time-l_time_start;
////						return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no such customer in records",l_diff+" ms"),HttpStatus.NOT_FOUND);
////
////					}
////					System.out.println(simNicResponse);
//
//				}
//			} catch (HttpStatusCodeException ex) {
//				System.out.println("Exception...");
//				ex.printStackTrace();
//				int statusCode = ex.getStatusCode().value();
//				String abcObj =ex.getResponseBodyAsString();
//				JSONParser parser = new JSONParser();
//				JSONObject obj2 =null;
//				try {
//					obj2 = (JSONObject)parser.parse(abcObj);
//				}catch(Exception ex2){
//					ex2.printStackTrace();
//				}
//				if(obj2!=null) {
//					System.out.println(obj2.toJSONString());
//					
//					
//					
//					System.out.println("#### "+obj2.toJSONString());
//					String errorCode = (String) obj2.get("errorCode");
//
//					customerDetail.setContingencyErrorCode(errorCode);
//					
//					if(errorCode.equals("0100") || errorCode.equals("0002")) {
//						if(newCustomer.equals("yes")) {
//						customerDetail.setKycStatus("contingency not verified");
//						customerDetail.setToken("T"+token);
//						customerDetail.setUpdateDate(new Date());
//						}
//						
//					}
//					
//					custService.updateCustomer(customerDetail, "");
//					
//					
//					
//					
//					
//					
//					long l_end_time = System.currentTimeMillis();
//					l_diff = l_end_time-l_time_start;
//					return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,obj2,l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//				}
//				else
//				{
//					long l_end_time = System.currentTimeMillis();
//					l_diff = l_end_time-l_time_start;
//					return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//				}
//				
//			}
//
//
//			long l_end_time = System.currentTimeMillis();
//			l_diff = l_end_time-l_time_start;
//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//		
return null;		
	}

	@Override
	public ResponseEntity<CoreResponseHandler> passportVerify(JSONObject obj) {
		// TODO Auto-generated method stub
//		String accessToken =  getAccessToken();
//
//		long l_diff = 0;
//		long l_time_start = System.currentTimeMillis();
//		CustomerDetail customerDetail_ =null;
//		SimPassportResponse simPassportResponse = null;
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//		headers.add("Authorization", "Bearer "+accessToken);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//		String token =(String) obj.get("token");
//		String newCustomer = (String) obj.get("newCustomer");
//		CustomerDetail customerDetail =  custService.findByToken(token);
//		
//		
//		
//		ResponseEntity<SimPassportResponse> response = null;
//		HttpEntity formEntity = new HttpEntity(obj, headers);
//		try {
//			response = restTemplate0.exchange("https://simapi.icta.mu/icta/verifyPassportNumber", HttpMethod.POST,
//					formEntity, SimPassportResponse.class);
//			if(response==null) {
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//			if(response!=null) {
//				simPassportResponse = response.getBody();
//				if(simPassportResponse==null) {
//					long l_end_time = System.currentTimeMillis();
//					l_diff = l_end_time-l_time_start;
//					return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//				}
//				System.out.println(simPassportResponse);
//				if(!customerDetail.getKycStatus().equals("contingency not verified")) {
//				//customerDetail.setKycStatus("verified. Other doc proof also needed.");
//				}
//				
//				customerDetail.setPassportDateIssued(simPassportResponse.getDateIssued());
//				customerDetail.setPassportDateExpired(simPassportResponse.getDateExpired());
//				customerDetail.setPassportDateFrom(simPassportResponse.getDateFrom());
//				customerDetail.setPassportDateTo(simPassportResponse.getDateTo());
//				customerDetail.setUpdateDate(new Date());
//				
//				customerDetail.setCorrelationId(simPassportResponse.getCorrelationId());
//				customerDetail.setPmUid(simPassportResponse.getPmUid());
//				CustomerDetail customerDetail2 =  custService.updateCustomer(customerDetail, "");
//			
//				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,simPassportResponse,null) ,HttpStatus.OK);
//
////				customerDetail_ = custService.findByID(simPassportResponse.getPassportNum());
////				if(customerDetail_==null) {
////					long l_end_time = System.currentTimeMillis();
////					l_diff = l_end_time-l_time_start;
////					return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no such customer in records",l_diff+" ms"),HttpStatus.NOT_FOUND);
////
////				}
////				System.out.println(simPassportResponse);
//
//			}
//		} catch (HttpStatusCodeException ex) {
//			System.out.println("Exception...");
//			//ex.printStackTrace();
//			int statusCode = ex.getStatusCode().value();
//			String abcObj =ex.getResponseBodyAsString();
//			JSONParser parser = new JSONParser();
//			JSONObject obj2 =null;
//			try {
//				obj2 = (JSONObject)parser.parse(abcObj);
//			}catch(Exception ex2){
//				ex2.printStackTrace();
//			}
//			if(obj2!=null) {
//
//				System.out.println(obj2.toJSONString());
//				
//				
//				
//				System.out.println("@@@@ "+obj2.toJSONString());
//				String errorCode = (String) obj2.get("errorCode");
//				
//				customerDetail.setContingencyErrorCode(errorCode);
//				if(errorCode.equals("0100") || errorCode.equals("0002")) {
//					if(newCustomer.equals("yes")) {
//					customerDetail.setKycStatus("contingency not verified");
//					customerDetail.setToken("T"+token);
//					customerDetail.setUpdateDate(new Date());
//					}
//				}
//				custService.updateCustomer(customerDetail, "");
//				
//				
//				
//				
//				
//				
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,obj2,l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//							
//			}
//			else
//			{
//				long l_end_time = System.currentTimeMillis();
//				l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//			}
//			
//		}
//
//		long l_end_time = System.currentTimeMillis();
//		l_diff = l_end_time-l_time_start;
//		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
return null;
	}

	@Override
	public ResponseEntity<CoreResponseHandler> agentCustom() {
		long l_time_start = System.currentTimeMillis();

		List<Agent> lsAgent =  agentRepository.findAgentCustom();

		if(lsAgent==null || lsAgent.size()==0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no agents not found",l_diff+" ms"),HttpStatus.NOT_FOUND);

		}

		
		List<List<AgentActivationData_>> listAgentActivationData__ = new ArrayList<List<AgentActivationData_>>();
		
		for(Agent agent :lsAgent) {
			
		
		List<AgentActivation> listActivation = activationRepo.findByAgentId(agent.getId()+"");
		if(listActivation==null || listActivation.size()==0) {
			continue;
		}
		List<AgentActivationData_> listAgentActivationData_ = new ArrayList<AgentActivationData_>();
		for(AgentActivation agentActivation:listActivation) {
			AgentActivationData_  agentActivationData_ = new AgentActivationData_();
			String activationStatus =  agentActivation.getActivationStatus();
			String dealerType = agent.getAgentType();
			String agentMsisdn = agent.getMsisdn();
			String name = agent.getAgentName();
			agentActivationData_.setActivationStatus(activationStatus);
			agentActivationData_.setDealerType(dealerType);
			agentActivationData_.setDealerMsisdn(agentMsisdn);
			agentActivationData_.setDealerName(name);
			String strCustId =  agentActivation.getCustomerId();
			if(strCustId!=null && !strCustId.equals("")) {
				int custId  = Integer.parseInt(strCustId);
				CustomerDetail customerDetail=  custRepo.getOne(custId);
				
				
				Document document =customerDetail.getDocument();
				List<DocumentDetail> documentList = null;
				if(document!=null) {
					documentList = new ArrayList<DocumentDetail>();

//					String bank =  document.getDocument1Type();
//					String electricity = document.getDocument2Type();
//					String permit = document.getDocument3Type();
//					String visa = document.getDocument4Type();
//					String uid = document.getDocument5Type();
					
					
					String bank =  null;
					String electricity = null;
					String permit = null;
					String visa = null;
					String uid = null;
					String water = null;
					String telecom = null;
					String consent = null;
					
					String bank_url =  document.getDocumentUrl();
					String electricity_url = document.getDocument2Url();
					String permit_url = document.getDocument3Url();
					String visa_url = document.getDocument4Url();
					String uid_url = document.getDocument5Url();
					String water_url = document.getDocument6Url();
					String telecom_url = document.getDocument7Url();
					String consent_url = document.getDocument8Url();
					if(bank_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("bank");
						documentDetail.setDocImage(bank);
						documentDetail.setDocImage_url(bank_url);
						documentList.add(documentDetail);
					}
					if(electricity_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("electricity");
						documentDetail.setDocImage(electricity);
						documentDetail.setDocImage_url(electricity_url);
						documentList.add(documentDetail);
					}
					if(permit_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("permit");
						documentDetail.setDocImage(permit);
						documentDetail.setDocImage_url(permit_url);
						documentList.add(documentDetail);
					}
					if(visa_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("visa");
						documentDetail.setDocImage(visa);
						documentDetail.setDocImage_url(visa_url);
						documentList.add(documentDetail);
					}
					if(uid_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("uid");
						documentDetail.setDocImage(uid);
						documentDetail.setDocImage_url(uid_url);
						documentList.add(documentDetail);
					}
					if(water_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("water");
						documentDetail.setDocImage(water);
						documentDetail.setDocImage_url(water_url);
						documentList.add(documentDetail);
					}
					if(telecom_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("telecom");
						documentDetail.setDocImage(telecom);
						documentDetail.setDocImage_url(telecom_url);
						documentList.add(documentDetail);
					}
					if(consent_url!=null) {
						DocumentDetail documentDetail = new DocumentDetail();
						documentDetail.setDocName("consent");
						documentDetail.setDocImage(consent);
						documentDetail.setDocImage_url(consent_url);
						documentList.add(documentDetail);
					}
					
					
				}
				
				
				
				agentActivationData_.setDocumentList(documentList);
				String docId = null;
				if(document!=null) {
					docId = document.getDocumentId()+"";
				}
				agentActivationData_.setDocumentId(docId);
				agentActivationData_.setActivationDate(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(customerDetail.getCreateDate()));
				
				
				
				
				String customerMsisdn = null;
				String alternateNumber = customerDetail.getAlternateNumber()==null||customerDetail.getAlternateNumber().equals("")?"":customerDetail.getAlternateNumber();
				agentActivationData_.setCustomerAlternate(alternateNumber);
				agentActivationData_.setCustomerDetail(customerDetail);
				SimDetail simDetail = customerDetail.getSimDetail();
				if(simDetail!=null) {
					customerMsisdn = simDetail.getMsisdn();
					agentActivationData_.setCustomerMsisdn(customerMsisdn);
				}
				
				
				
				if(customerMsisdn!=null && !customerMsisdn.contains(",")) {
					
				
				List<OtpDetail> otpDetailList = otpRepo.findMsisdn(customerMsisdn);
				OtpDetail otpDetail = null;
				if(otpDetailList!=null && otpDetailList.size()>0) {
					otpDetail = otpDetailList.get(0);					
				}


					if(otpDetail!=null && otpDetail.getIsActive().equals("true")) {
						agentActivationData_.setOtpStatus("Otp verified");
					}
					else if(otpDetail!=null && otpDetail.getIsActive().equals("false")) {
						agentActivationData_.setOtpStatus("Otp sent");
					}
					else if(otpDetail==null) {
						agentActivationData_.setOtpStatus("Otp not sent");
					}
				
				
				
				
				}
				
				if(customerDetail!=null) {
				String resType = customerDetail.getResidentType()==null || customerDetail.getResidentType().equals("")?"":customerDetail.getResidentType();
				String UserType = null;
				if(resType!=null && !resType.equals("")&& resType.equals("citizen")) {
					UserType = "CITIZEN";
				}
				else if(resType!=null && !resType.equals("")&& resType.equals("tourist")) {
					UserType = "TOURIST";
				}
				else if(resType!=null && !resType.equals("")&& resType.equals("resident")) {
					UserType = "RESIDENT";
				}
				else {
					UserType = "";
				}
				String DocumentType = null;
				if(UserType.equals("CITIZEN")) {
					DocumentType = "National ID";
				}
				else {
					DocumentType = "Passport";
				}
				
				agentActivationData_.setCustomerType(UserType);
				agentActivationData_.setCustomerIDType(DocumentType);
				}
			
			
			
			
			
			
			
			
			
			
			}
			
			listAgentActivationData_.add(agentActivationData_);
		}
		listAgentActivationData__.add(listAgentActivationData_);
	}

		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;

		return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,listAgentActivationData__,l_diff+" ms") ,HttpStatus.OK);			

	}
@Autowired
CustomerDetailRepository repo;
	@Override
	public ResponseEntity<CoreResponseHandler> test() {
		// TODO Auto-generated method stub
		List<CustomerDetail> list = repo.findTest();
		for(CustomerDetail cust:list) {
			System.out.println(cust.getCustomerId());
		}
		return null;
	}

	@Override
	public ResponseEntity<CoreResponseHandler> updateVerified(String token) {
//		
//		long l_time_start = System.currentTimeMillis();
//
//		// TODO Auto-generated method stub
//		 String accessToken =  getAccessToken();
//
//		 CustomerDetail customerDetail = custService.findByToken(token);
//		 if(customerDetail==null) {
//				long l_end_time = System.currentTimeMillis();
//				long l_diff = l_end_time-l_time_start;
//				return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer in records with this token",l_diff+" ms"),HttpStatus.NOT_FOUND);
// 
//		 }
//			CustomerDetail customerDetail_ =null;
//			SimNicResponse simNicResponse = null;
//			RestTemplate restTemplate = new RestTemplate();
//
//			HttpHeaders headers = new HttpHeaders();
//			headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//			headers.add("Authorization", "Bearer "+accessToken);
//			ResponseEntity<SimNicResponse> response = null;
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			JSONObject obj =new JSONObject();
//			obj.put("nicNum", customerDetail.getId());
//			obj.put("dateOfBirth",  sdf.format(customerDetail.getDob()));
//			obj.put("gender", customerDetail.getGender().substring(0, 1).toUpperCase());
//			obj.put("userType", "SELF");
//			
//			
//			HttpEntity formEntity = new HttpEntity(obj, headers);
//			
//			
//			try {
//				response = restTemplate0.exchange("https://simapi.icta.mu/icta/verifyNIC", HttpMethod.POST,
//						formEntity, SimNicResponse.class);
//				if(response==null) {
//					long l_end_time = System.currentTimeMillis();
//					long l_diff = l_end_time-l_time_start;
//					return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//				}
//				if(response!=null) {
//					simNicResponse = response.getBody();
//					if(simNicResponse==null) {
//						long l_end_time = System.currentTimeMillis();
//						long l_diff = l_end_time-l_time_start;
//						return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"sim verify nic response null",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
//					}
//
//					System.out.println(simNicResponse);
//					
//					//customerDetail.setCorrelationId(simNicResponse.getCorrelationId());
//					//customerDetail.setUpdateDate(new Date());
//					Image image = customerDetail.getImage();
//					
//					Image_ image_ = new Image_();
//					image_.setBase64(simNicResponse.getPhotograph());
//					image_.setImgType("verified");
//					image_.setToken(customerDetail.getToken());
//					Image img = imgService.updateImageWithSelfie(image,image_);
//					
//					customerDetail.setImage(img);
//					
//					CustomerDetail customerDetail2 =  custService.updateCustomer(customerDetail, "");
//					
//					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,simNicResponse,null) ,HttpStatus.OK);
//				}
//			} catch (HttpStatusCodeException ex) {
//				ex.printStackTrace();
//				long l_end_time = System.currentTimeMillis();
//				long l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//				
//			}
//
//
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
		
return null;		
	
	}

	@Override
	public ResponseEntity<CoreResponseHandler> checkbymsisdnnewcustomer(String msisdn, String newcustomer,
			String type) {
		// TODO Auto-generated method stub
		long l_time_start = System.currentTimeMillis();

			OtpDetail otpDetail = otpRepo.findByMsisdn(msisdn);
			if(msisdn==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "msisdn not found",l_diff+" ms"),HttpStatus.NOT_FOUND);
	
			}
			String token = otpDetail.getToken();
			if(token==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no token found",l_diff+" ms"),HttpStatus.NOT_FOUND);
				
			}
			CustomerDetail customerDetail=null;
			Employee employee=null;
		if(type.equalsIgnoreCase("customer")) {
			customerDetail = custService.findByToken(token);
			if(customerDetail==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no customer found",l_diff+" ms"),HttpStatus.NOT_FOUND);
				
			}
			String newCustomer = customerDetail.getNewCustomer();
			if(newCustomer!=null && !newCustomer.equalsIgnoreCase("no")) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"newCustomer=yes found",l_diff+" ms") ,HttpStatus.OK);
			}
			else if(newCustomer==null || newCustomer.equalsIgnoreCase("no")) {
				String ekycStatus = customerDetail.getKycStatus();
				List<String> listAllowedValues = Arrays.asList("verified","activated","verified. Other doc proof also needed.");
				if(ekycStatus!=null && commonUtilityFunctions.allowedValues(ekycStatus, listAllowedValues)) {
					long l_end_time = System.currentTimeMillis();
					long l_diff = l_end_time-l_time_start;
					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already there",l_diff+" ms") ,HttpStatus.OK);
				}
				else {
					long l_end_time = System.currentTimeMillis();
					long l_diff = l_end_time-l_time_start;
					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"no stauts found like verified,activated,verified. Other doc proof also needed.",l_diff+" ms") ,HttpStatus.OK);					
				}
			}
		}
		else {
			employee = empRepo.findByToken(token);
			if(employee==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "no employee found",l_diff+" ms"),HttpStatus.NOT_FOUND);
				
			}
			String newCustomer = employee.getNewCustomer();
			if(newCustomer!=null && !newCustomer.equalsIgnoreCase("no")) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"newCustomer=yes found",l_diff+" ms") ,HttpStatus.OK);
			}
			else if(newCustomer==null || newCustomer.equalsIgnoreCase("no")) {
				String ekycStatus = employee.getKycStatus();
				List<String> listAllowedValues = Arrays.asList("verified","activated","verified. Other doc proof also needed.");
				if(ekycStatus!=null && commonUtilityFunctions.allowedValues(ekycStatus, listAllowedValues)) {
					long l_end_time = System.currentTimeMillis();
					long l_diff = l_end_time-l_time_start;
					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"already there",l_diff+" ms") ,HttpStatus.OK);
				}
				else {
					long l_end_time = System.currentTimeMillis();
					long l_diff = l_end_time-l_time_start;
					return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"stauts is not verified,activated,verified. Other doc proof also needed.",l_diff+" ms") ,HttpStatus.OK);					
				}
			}
		}
		

		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
	
	}

	@Override
	public ResponseEntity<CoreResponseHandler> checkSimMsisdn(String msisdn) {
		long l_time_start = System.currentTimeMillis();


		List<SimDetail> simDetail =  simRepo.findByMsisdnContaining(msisdn);
		if(simDetail==null || simDetail.size()==0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "not found",l_diff+" ms"),HttpStatus.NOT_FOUND);

			
		}
		else {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"found",l_diff+" ms") ,HttpStatus.OK);
		}

	}

	@Override
	public ResponseEntity<CoreResponseHandler> checkKyc(String msisdn, String flag) {
		// TODO Auto-generated method stub
		
		return null;
	}

	
	@Override
	public ResponseEntity<CoreResponseHandler> processbase64s(String docId) {
		long l_time_start = System.currentTimeMillis();
		int intDocId = Integer.parseInt(docId);
		Document document = docRepo.getOne(intDocId);
		if(document==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "document not found",l_diff+" ms"),HttpStatus.NOT_FOUND);			
		}
		
		CustomerDetail cust = custRepo.findByDocument(document);
		
		if(cust==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "customer not found",l_diff+" ms"),HttpStatus.NOT_FOUND);			
			
		}
		
		//not able to save
		String token = cust.getToken();
		if(token==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "token is null",l_diff+" ms"),HttpStatus.NOT_FOUND);			
			
		}
		
		if(document.getDocumentUrl()!=null && document.getDocumentUrl().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument1Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "type1 null",l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument1Type());
			doc_.setImgType("bank");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		
		if(document.getDocument2Url()!=null && document.getDocument2Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument2Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type2 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument2Type());
			doc_.setImgType("electricity");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		
		
		if(document.getDocument3Url()!=null && document.getDocument3Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument3Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type3 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument3Type());
			doc_.setImgType("permit");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		

		if(document.getDocument4Url()!=null && document.getDocument4Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument4Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type4 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument4Type());
			doc_.setImgType("other");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		if(document.getDocument5Url()!=null && document.getDocument5Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument5Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type5 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument5Type());
			doc_.setImgType("UID");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		if(document.getDocument6Url()!=null && document.getDocument6Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument6Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type6 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument6Type());
			doc_.setImgType("water");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
				
		
		
		if(document.getDocument7Url()!=null && document.getDocument7Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument7Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type7 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument7Type());
			doc_.setImgType("telecom");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		
		
		
		if(document.getDocument8Url()!=null && document.getDocument8Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument8Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type8 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument8Type());
			doc_.setImgType("consent");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		
		if(document.getDocument9Url()!=null && document.getDocument9Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument9Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type9 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument9Type());
			doc_.setImgType("incorporationLetter");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		
		
		if(document.getDocument10Url()!=null && document.getDocument10Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument10Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type10 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument10Type());
			doc_.setImgType("vat");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		
		
		if(document.getDocument11Url()!=null && document.getDocument11Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument11Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type11 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument11Type());
			doc_.setImgType("brn");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		if(document.getDocument12Url()!=null && document.getDocument12Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument12Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type12 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument12Type());
			doc_.setImgType("utility");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		if(document.getDocument13Url()!=null && document.getDocument13Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument13Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type13 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument13Type());
			doc_.setImgType("authorizationLetter");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		
		if(document.getDocument14Url()!=null && document.getDocument14Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument14Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type14 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument14Type());
			doc_.setImgType("emp_utility_org");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
	
		if(document.getDocument15Url()!=null && document.getDocument15Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument15Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type15 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument15Type());
			doc_.setImgType("touristCert");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		
		if(document.getDocument16Url()!=null && document.getDocument16Url().equals("not able to save")) {
			Document_ doc_ = new Document_();
			if(document.getDocument16Type()==null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				String msg = "type16 null";
				//return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, msg,l_diff+" ms"),HttpStatus.NOT_FOUND);			
					
			}
			doc_.setBase64(document.getDocument16Type());
			doc_.setImgType("authorizationLetter_part2");
			doc_.setToken(token);
			Document document_ =  docService.saveDocument(document, doc_);
			if(document_!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				//return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
			}
		}
		
		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"base64 found and saved as file",l_diff+" ms") ,HttpStatus.OK);
		

//		long l_end_time = System.currentTimeMillis();
//		long l_diff = l_end_time-l_time_start;
//		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//	
	
	}

	
	@Autowired
	private CommonUtilityFunctions utility;
	@Autowired
	private SimLostDamageDetailRepository simlostdamagerepo;
	
	@Override
	public ResponseEntity<CoreResponseHandler> simLostDamageCase(SimCase simCase) {
		// TODO Auto-generated method stub
		long l_time_start = System.currentTimeMillis();

		SimLostDamageDetail check = simlostdamagerepo.findByMsisdn(simCase.getMsisdn());
		
		if(check!=null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"detail for this msisdn already there",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												

		}
		
		
		String token = utility.getRandomNumber(9);

		SimLostDamageDetail simLostDamageDetail = new SimLostDamageDetail();
		if(simCase.getSimCase().equalsIgnoreCase("lost")) {
			
			

			Image_ image_ = new Image_();
			image_.setBase64(simCase.getId64());
			image_.setImgType("kyc");
			image_.setToken(token);
			Image image  = imgService.saveImage(image_);
			
			
			
			
			
			Document	document=new Document();
			
			Document_ d_ = new Document_();
			d_.setBase64(simCase.getDoc64());
			d_.setImgType("policeMemo");
			d_.setToken(token);

			Document document0 = null;
			
			document0 = docService.saveDocument(document, d_);

			simLostDamageDetail.setCase_("lost");
			simLostDamageDetail.setMsisdn(simCase.getMsisdn());
			simLostDamageDetail.setDocument(document0);
			simLostDamageDetail.setImage(image);
			simLostDamageDetail.setToken(token);
			simLostDamageDetail.setCreateDate(new Date());
			
			 simlostdamagerepo.saveAndFlush(simLostDamageDetail);
			 
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"saved. token : "+token,l_diff+" ms") ,HttpStatus.OK);
				
			
		}
		else if(simCase.getSimCase().equalsIgnoreCase("damage")) {

			
			Image_ image_ = new Image_();
			image_.setBase64(simCase.getId64());
			image_.setImgType("kyc");
			image_.setToken(token);
			Image image  = imgService.saveImage(image_);
			
			
			
			
			
			Document	document=new Document();
			
			Document_ d_ = new Document_();
			d_.setBase64(simCase.getDoc64());
			d_.setImgType("applicationWithDamageSim");
			d_.setToken(token);

			Document document0 = null;
			
			document0 = docService.saveDocument(document, d_);

			simLostDamageDetail.setCase_("damage");
			simLostDamageDetail.setMsisdn(simCase.getMsisdn());
			simLostDamageDetail.setDocument(document0);
			simLostDamageDetail.setImage(image);
			simLostDamageDetail.setToken(token);
			simLostDamageDetail.setCreateDate(new Date());
			 simlostdamagerepo.saveAndFlush(simLostDamageDetail);

				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"saved. token : "+token,l_diff+" ms") ,HttpStatus.OK);

			 
			 
		}
		long l_end_time = System.currentTimeMillis();
		long l_diff = l_end_time-l_time_start;
		return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
	
	}

	public boolean saveToVerifiedMsisdn(VerifiedMsisdn_ verifiedMsisdn_) {
		VerifiedMsisdn vm = new VerifiedMsisdn();
		vm.setCreateDate(new Date());
		if(verifiedMsisdn_.getMsisdn()==null)
			vm.setMsisdn(null);
		else
		vm.setMsisdn(verifiedMsisdn_.getMsisdn());
		vm.setToken(verifiedMsisdn_.getToken());
		vm.setSimDetail(verifiedMsisdn_.getSimDetail());
		VerifiedMsisdn vm2 =  vRepo.saveAndFlush(vm);
		if(vm2!=null) {
			return true;
		}
		return false;
	}

	@Override
	public ResponseEntity<CoreResponseHandler> findByMsisdn(String msisdn) {
		long l_time_start = System.currentTimeMillis();

		SimLostDamageDetail check = simlostdamagerepo.findByMsisdn(msisdn);
		
		if(check==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "not found",l_diff+" ms"),HttpStatus.NOT_FOUND);
		}
		
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,check,l_diff+" ms") ,HttpStatus.OK);

	}

	@Override
	public ResponseEntity<CoreResponseHandler> findByToken(String token) {
		long l_time_start = System.currentTimeMillis();

		SimLostDamageDetail check = simlostdamagerepo.findByToken(token);
		
		if(check==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "not found",l_diff+" ms"),HttpStatus.NOT_FOUND);
		}
		
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,check,l_diff+" ms") ,HttpStatus.OK);

	}

	@Override
	public ResponseEntity<CoreResponseHandler> findByCase_(String case_) {
		long l_time_start = System.currentTimeMillis();

		List<SimLostDamageDetail> check = simlostdamagerepo.findByCase_(case_);
		
		if(check==null || check.size()==0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "not found",l_diff+" ms"),HttpStatus.NOT_FOUND);
		}
		
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,check,l_diff+" ms") ,HttpStatus.OK);

	}

	@Override
	public ResponseEntity<CoreResponseHandler> findByDateRange(String from, String to) {
		long l_time_start = System.currentTimeMillis();

		List<SimLostDamageDetail> check = simlostdamagerepo.findByDateRange(from, to);
		
		if(check==null || check.size()==0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "not found",l_diff+" ms"),HttpStatus.NOT_FOUND);
		}
		
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,check,l_diff+" ms") ,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<CoreResponseHandler> checkVerifiedMsisdn(String msisdn) {
		long l_time_start = System.currentTimeMillis();

		List<VerifiedMsisdn> check = vRepo.findByMsisdn(msisdn);
		if(check!=null && check.size()>0) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,check,l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
		}
		
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"ok",l_diff+" ms") ,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<CoreResponseHandler> findByDocId(String id) {
//		long l_time_start = System.currentTimeMillis();
//		Optional<String> object = Optional.ofNullable(repo.findById2(id).map(e->e.getFirstName()).orElseThrow(()-> new EntityNotFoundException("deails not found")));
//		if(object.isPresent()) {
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,object,l_diff+" ms") ,HttpStatus.OK);
//		}
//		throw new RuntimeException("some internal server exception occurred");

		
		
		long l_time_start = System.currentTimeMillis();
		Optional<CustomerObject> object = Optional.ofNullable(repo.findById2(id).orElseThrow(()-> new EntityNotFoundException("deails not found")));
		if(object.isPresent()) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,object,l_diff+" ms") ,HttpStatus.OK);
		}
		throw new RuntimeException("some internal server exception occurred");
	}

	@Override
	public ResponseEntity<CoreResponseHandler> ekycActivate(String token,ExtraInfo extraInfo) {
//		
//		long l_time_start = System.currentTimeMillis();
//		EkycActivate ekycActivate = getData(token);
//		ekycActivate.setCity(extraInfo.getCity());
//		ekycActivate.setCountryCode(extraInfo.getCountryCode());
//		ekycActivate.setInvoiceChild(extraInfo.getInvoiceChild());
//		ekycActivate.setIsParent(extraInfo.getIsParent());
//		ekycActivate.setMonthlyLimit(extraInfo.getMonthlyLimit());
//		ekycActivate.setNextInvoiceDayOfPeriod(extraInfo.getNextInvoiceDayOfPeriod());
//		//ekycActivate.setNextInoviceDate(extraInfo.getNextInoviceDate());
//		ekycActivate.setInvoiceDesign(extraInfo.getInvoiceDesign());
//		ekycActivate.setNotificationInclude(extraInfo.getNotificationInclude());
//		ekycActivate.setParentId(extraInfo.getParentId());
//		ekycActivate.setPersonInitial(extraInfo.getPersonInitial());
//		ekycActivate.setPersonTitle(extraInfo.getPersonTitle());
//		ekycActivate.setRechargeThreshold(extraInfo.getRechargeThreshold());
//		ekycActivate.setReferralFeePaid(extraInfo.getReferralFeePaid());
//		ekycActivate.setPartnerId(extraInfo.getPartnerId());
//		ekycActivate.setElectricityMeterId(extraInfo.getElectricityMeterId());
//		ekycActivate.setMsisdn(extraInfo.getMsisdn());
//		ekycActivate.setDeviceId(extraInfo.getDeviceId());
//		String rechargeType =null;
//		if(extraInfo.getRechargeType().contains("~")) {
//			rechargeType = rechargeType.substring(0, rechargeType.indexOf("~"));
//		}
//		else {
//			rechargeType = extraInfo.getRechargeType();
//		}
//		
//		ekycActivate.setRechargeType(rechargeType);
//		ekycActivate.setServiceType(extraInfo.getServiceType());
//		
//		
//		System.out.println("GET DATA FROM EKYC FOR TOKEN : "+token);
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		try {
//			String json = ow.writeValueAsString(ekycActivate);
//			System.out.println(json);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		if(ekycActivate==null) {
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "not found",l_diff+" ms"),HttpStatus.NOT_FOUND);
//		
//		}
//		String accessToken = getCrmAccessToken();
//		//System.out.println("ACCESS TOKEN : "+accessToken);
//		
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//		headers.add("Authorization", "Bearer "+accessToken);
//		ResponseEntity<String> response = null;
//		HttpEntity formEntity = new HttpEntity(ekycActivate, headers);
//		try {
//			response = restTemplate0.exchange("http://172.17.1.20:9090/api/save/ekyc/customer/in/crm", HttpMethod.POST,
//					formEntity, String.class);
//			System.out.println("========================================");
//			System.out.println("!!!!!!!!!!!!!!!!!!!\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+response);
//			System.out.println("========================================");
//			
//			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
//				String ekycActivateRes = response.getBody();
//				long l_end_time = System.currentTimeMillis();
//				long l_diff = l_end_time-l_time_start;
//				JSONParser parser =new JSONParser();
//				JSONObject obj =(JSONObject) parser.parse(ekycActivateRes);
//				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,obj==null?"not able to parse to json":obj,l_diff+" ms") ,HttpStatus.OK);
//			}
//			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
//				System.out.println("check1 check1 check1 check1 check1 "+response.getStatusCodeValue());
//				long l_end_time = System.currentTimeMillis();
//				long l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,response,l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//
//			}
//			else
//			{
//				System.out.println("check2 check2 check2 check2 check2 ");
//				long l_end_time = System.currentTimeMillis();
//				long l_diff = l_end_time-l_time_start;
//				return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//				
//			}
//		}
////			catch(HttpClientErrorException ex) {
////			ex.printStackTrace();
////			String lMsg = ex.getLocalizedMessage();
////			//String msg = ex.getMessage();
//////			JSONParser parser =new JSONParser();
//////			JSONObject obj = null;
//////			try {
//////			obj = (JSONObject)parser.parse(lMsg);
//////		}catch(Exception ex_) {
//////			ex_.printStackTrace();
//////		}
////			System.out.println("exception check check check check check ");
////			
////			long l_end_time = System.currentTimeMillis();
////			long l_diff = l_end_time-l_time_start;
////			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
////
////		}
//		
//		
//		catch(Exception ex) {
//			ex.printStackTrace();
//				System.out.println("exception check check check check check ");
//			String msg = ex.getMessage();
//			long l_end_time = System.currentTimeMillis();
//			long l_diff = l_end_time-l_time_start;
//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR : "+msg,l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				
//
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
		
return null;		
		
	
	}
	
	EkycActivate getData(String token) {
		
		CustomerDetail custDetail = custService.findByToken(token);
		if(custDetail==null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		EkycActivate ekycActivate = new EkycActivate();
		ekycActivate.setAddress(custDetail.getAddress());
		ekycActivate.setCreateTime(sdf.format(custDetail.getCreateDate()));
		ekycActivate.setDob(sdf2.format(custDetail.getDob()));
		ekycActivate.setEkycId(custDetail.getCustomerId()+"");
		ekycActivate.setFirstName(custDetail.getFirstName());
		ekycActivate.setGender(custDetail.getGender());
		ekycActivate.setIdDocId(custDetail.getId());
		ekycActivate.setLastName(custDetail.getLastName());
		ekycActivate.setMaidenName(custDetail.getMaidenName());
		ekycActivate.setStatus(custDetail.getKycStatus());
		ekycActivate.setEmail(custDetail.getEmail());
//		if(custDetail.getSelf()==null || custDetail.getSelf().equalsIgnoreCase("no")) {
//			ekycActivate.setSelf("no");	
//		}
//		else {
//			ekycActivate.setSelf("yes");
//		}
//		String msisdn = null;
//		SimDetail simDetail = custDetail.getSimDetail();
//		
//		if(simDetail==null) {
//			msisdn = null;
//		}
//		else {
//			msisdn = simDetail.getMsisdn();
//		}
		//ekycActivate.setMsisdn(msisdn);
		ekycActivate.setNationality(custDetail.getNationality());
		ekycActivate.setOriginalPhotoUrl(custDetail.getImage().getOriginalPhotoUrl());
//		String rechargeType_ = custDetail.getRechargeType();
//		String rechTypeArr []  = null;
//		if(rechargeType_.contains("~")) {
//			rechTypeArr= rechargeType_.split("~");
//		}
//		if(rechTypeArr.length>0)
//		ekycActivate.setRechargeType(rechTypeArr[0]);
//		else
//		ekycActivate.setRechargeType(rechargeType_);
			
		ekycActivate.setResidentType(custDetail.getResidentType());
		ekycActivate.setToken(custDetail.getToken());
		ekycActivate.setUserType(custDetail.getUserType());
		ekycActivate.setRemark(custDetail.getRemarks());
		return ekycActivate;
	}
	
	String getCrmAccessToken() {
		String CRM_LoginUrl="http://172.5.10.2:9090/api/login";
		String jwtToken = null;
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		String credential = "{\"email\":\"pawan@gmail.com\",\"password\":\"pawan123\"}";
		
		//System.out.println("@@@@@ "+ credential);

		HttpEntity<String> requestEntity = new HttpEntity<>(credential, header);

		//System.out.println("!!!!!requestEntity "+ requestEntity);
		ResponseEntity<String> responseEntity = restTemplate.exchange(CRM_LoginUrl, HttpMethod.POST, requestEntity,String.class);

		//System.out.println("$$$$$$$$ responseEntity" +responseEntity);
		HttpStatusCode statusCode = responseEntity.getStatusCode();

		//System.out.println("CRM login Api Status Code1: " + statusCode);
		if (statusCode == HttpStatus.OK) {

			String response = responseEntity.getBody();
			// System.out.println(response);

			org.json.JSONObject jsonResponse = new org.json.JSONObject(response);
			

			jwtToken = jsonResponse.getString("jwtToken");

			//System.out.println("XXXXXX"+jwtToken);
	
	}
		return jwtToken;
	}

	@Override
	public ResponseEntity<CoreResponseHandler> collectCrmFields(String token,ExtraInfo extraInfo) {
		long l_time_start = System.currentTimeMillis();
		CustomerDetail custDetail = custService.findByToken(token);
		if(custDetail==null) {
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "not found",l_diff+" ms"),HttpStatus.NOT_FOUND);
		
		}
		JSONObject obj = new JSONObject();
		obj.put("city", extraInfo.getCity());
		obj.put("countryCode", extraInfo.getCountryCode());
		obj.put("invoiceChild", extraInfo.getInvoiceChild());
		obj.put("isParent", extraInfo.getIsParent());
		obj.put("monthlyLimit", extraInfo.getMonthlyLimit());
		obj.put("parentId", extraInfo.getParentId());
		obj.put("nextInvoiceDayOfPeriod", extraInfo.getNextInvoiceDayOfPeriod());
		obj.put("invoiceDesign", extraInfo.getInvoiceDesign());
		obj.put("notificationInclude", extraInfo.getNotificationInclude());
		obj.put("personInitial", extraInfo.getPersonInitial());
		obj.put("personTitle", extraInfo.getPersonTitle());
		obj.put("rechargeThreshold", extraInfo.getRechargeThreshold());
		obj.put("referralFeePaid", extraInfo.getReferralFeePaid());
		obj.put("partnerId", extraInfo.getPartnerId());
		obj.put("electricityMeterId", extraInfo.getElectricityMeterId());
		obj.put("serviceType", extraInfo.getServiceType());
		obj.put("msisdn",extraInfo.getMsisdn());
		obj.put("rechargeType",extraInfo.getRechargeType());
		String crmFields = obj.toJSONString();
		custDetail.setCrmInfo(crmFields);
		 CustomerDetail custDetail2= custService.updateCustomer(custDetail, "");
		 if(custDetail2!=null) {
				long l_end_time = System.currentTimeMillis();
				long l_diff = l_end_time-l_time_start;
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"updated",l_diff+" ms") ,HttpStatus.OK);
	
		 }
			long l_end_time = System.currentTimeMillis();
			long l_diff = l_end_time-l_time_start;
			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);				

	}

	@Override
	public ResponseEntity<CoreResponseHandler> updateDob(String token,
			String dob) {
		
		
		CustomerDetail custDetail = custService.findByToken(token);
		if(custDetail==null) {
			return new	ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed, "customer not found",null),HttpStatus.NOT_FOUND);
		
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
			Date dtDob = null;
			try {
				dtDob = sdf.parse(dob);
				custDetail.setDob(dtDob);
			}catch(Exception ex) {
				custDetail.setDob(null);
				return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"incorrect format of dob",null) ,HttpStatus.BAD_REQUEST);												
							
			}
		
			CustomerDetail custDetail2 =custService.updateCustomer(custDetail, null);
		
		if(custDetail2!=null)
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,"updated",null) ,HttpStatus.OK);
		else
			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",null),HttpStatus.INTERNAL_SERVER_ERROR);				

	}

}
