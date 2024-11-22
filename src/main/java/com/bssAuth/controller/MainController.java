package com.bssAuth.controller;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.util.stream.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.function.*;
@RestController
public class MainController {


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	
	@GetMapping(value="api/rating/profile/get/all/{type}")
	public ResponseEntity<?> api_rating_profile_get_all(@PathVariable(value="type")String type){

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<String> response = null;
		//HttpEntity formEntity = new HttpEntity(ekycActivate, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.11:9696/api/rating/profile/get/all/"+type, HttpMethod.GET,
					null, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, response.getStatusCode());
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){

				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}



	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/prepaid/account/get/all/available/balance")
	public ResponseEntity<?> api_prepaid_account_get_all_available_balance(@RequestParam(name = "imsi")String imsi,@RequestParam(name = "msisdn")String msisdn){

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<String> response = null;
		//HttpEntity formEntity = new HttpEntity(ekycActivate, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.11:9698/api/prepaid/account/get/all/available/balance?imsi="+imsi+"&msisdn="+msisdn, HttpMethod.GET,
					null, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj = null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){

				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/postpaid/account/get/all/available/balance")
	public ResponseEntity<?> api_postpaid_account_get_all_available_balance(@RequestParam(name = "imsi")String imsi,@RequestParam(name = "msisdn")String msisdn){

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<String> response = null;
		//HttpEntity formEntity = new HttpEntity(ekycActivate, headers);
		try {
			//								  http://172.17.1.11:9699/api/postpaid/account/get/all/available/balance?imsi=&msisdn=987653258
			response = restTemplate.exchange("http://172.17.1.11:9699/api/postpaid/account/get/all/available/balance?imsi="+imsi+"&msisdn="+msisdn, HttpMethod.GET,
					null, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj = null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){

				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}

		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}	

	String getCrmAccessToken() {
		//String CRM_LoginUrl="http://172.5.10.2:9090/api/login";
		//http://172.17.1.20:9090/
		String CRM_LoginUrl="http://172.17.1.20:9090/api/login";
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
	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*///6749991025 ok, 6749991027 not in crm
	@GetMapping(value="api/customerbymsisdn/{msisdn}")
	public ResponseEntity<?> api_customerbymsisdn(@PathVariable(value="msisdn")String msisdn){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/customerbymsisdn/"+msisdn, HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/set/monthly/amount/msisdn/{msisdn}/amount/{amount}")
	public ResponseEntity<?> pushToAbmf(@PathVariable(value="msisdn")String msisdn,@PathVariable(value="amount")String amount){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/set/monthly/amount/msisdn/"+msisdn+"/amount/"+amount, HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/invoice/msisdn/{msisdn}")
	public ResponseEntity<?> invoice(@PathVariable(value="msisdn")String msisdn){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/invoice/msisdn/"+msisdn, HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				HttpStatusCode statusCode = response.getStatusCode();
				return new ResponseEntity<>(response, statusCode);
			}
			else
			{
				HttpStatusCode statusCode = response.getStatusCode();
				System.out.println("2");
				return new ResponseEntity<>("ERROR", statusCode);

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}

		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			HttpStatusCode statusCode = ex.getStatusCode();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj,statusCode);

		}
	}



	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/bill/{msisdn}")
	public ResponseEntity<?> generateInvoice1(@PathVariable(value="msisdn")String msisdn){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9098/bill/"+msisdn, HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}











	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/savepayment/currency")
	public ResponseEntity<?> simCardPaymentViaCard(@RequestBody JSONObject json){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/savepayment/currency/1/paymentrsult/1/paymentmethod/1?creditCard=2", HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/savepayment/currency/1/paymentrsult/{msisdn}")
	public ResponseEntity<?> paymentForPlan(@RequestBody JSONObject json,@PathVariable(value="msisdn",required = true)String msisdn){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/savepayment/currency/1/paymentrsult/1/paymentmethod/1?creditCard=2&msisdn="+msisdn, HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}

		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/postpaid/bill/payment/invoice/{invoiceNumber}/amount/{amount}/currency/1/paymentrsult/1/paymentmethod/1/partnerid/{partnerId}/transactionid/{transactionId}")
	public ResponseEntity<?> postpaidbillpayment(@PathVariable(value="invoiceNumber")String invoiceNumber,@PathVariable(value="amount")String amount,@PathVariable(value="partnerId")String partnerId,@PathVariable(value="transactionId")String transactionId){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:9090/api/postpaid/bill/payment/invoice/"+invoiceNumber+"/amount/"+amount+"/currency/1/paymentrsult/1/paymentmethod/1?creditCard=2&partner="+partnerId+"&transactionId="+transactionId;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/self/care/devices")
	public ResponseEntity<?> selfCareDevices(){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:9090/api/self/care/devices";
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}

		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/voucher/api/all/special/offers")
	public ResponseEntity<?> apiAllSpecialOffers(){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:8082/voucher/api/all/special/offers";
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}

		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/voucher/save/direct/voucher/sell")
	public ResponseEntity<?> voucher_save_direct_voucher_sell(@RequestBody JSONObject json){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			String url = "http://172.17.1.20:8082/voucher/save/direct/voucher/sell";
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/voucher/1.0/voucher/redeem")
	public ResponseEntity<?> voucher_voucher_redeem(@RequestBody JSONObject json){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			String url = "http://172.17.1.20:8082/voucher/1.0/voucher/redeem";
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	//	@GetMapping(value="api/save/cart/token/{token}/device/{device}")
	//	public ResponseEntity<?> save_cart_token(@PathVariable(value="token")String token,@PathVariable(value="device")String device){
	//	
	//		String accessToken = getCrmAccessToken();
	//		//System.out.println("ACCESS TOKEN : "+accessToken);
	//		
	//		RestTemplate restTemplate = new RestTemplate();
	//
	//		HttpHeaders headers = new HttpHeaders();
	//		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
	//		headers.add("Authorization", "Bearer "+accessToken);
	//		ResponseEntity<String> response = null;
	//		HttpEntity formEntity = new HttpEntity(null, headers);
	//		try {
	//			String url = "http://172.17.1.20:9090/api/save/cart/token/"+token+"/device/"+device;
	//			System.out.println(url);
	//			response = restTemplate.exchange(url , HttpMethod.POST,
	//					formEntity, String.class);
	//			
	//			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
	//				String actualResponse = response.getBody();
	//				JSONParser parser =new JSONParser();
	//				JSONObject obj =(JSONObject) parser.parse(actualResponse);
	//				return new ResponseEntity<>(obj, HttpStatus.OK);
	//			}
	//			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
	//				System.out.println("1");
	//				return new ResponseEntity<>(response, response.getStatusCode());
	//			}
	//			else
	//			{
	//				System.out.println("2");
	//				return new ResponseEntity<>("ERROR", response.getStatusCode());
	//				
	//			}
	//		}
	//		
	//		
	//		catch(Exception ex) {
	//			System.out.println("3");
	//			ex.printStackTrace();
	//			String msg = ex.getMessage();
	//			return new ResponseEntity<>(msg, response.getStatusCode());
	//
	//		}
	//	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/carts/token/{token}")
	public ResponseEntity<?> carts_token(@PathVariable(value="token")String token){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:9090/api/carts/token/"+token;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/save/order/token/{token}")
	public ResponseEntity<?> save_order_token(@PathVariable(value="token")String token){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:9090/api/save/order/token/"+token;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}



	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@DeleteMapping(value="api/cart/id/{id}")
	public ResponseEntity<?> delete_cart_id(@PathVariable(value="id")String id){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:9090/api/cart/id/"+id;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.DELETE,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}



	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/invoice/order/{order}")
	public ResponseEntity<?> invoice_order(@PathVariable(value="order")String order){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:9090/api/invoice/order/"+order;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}



	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/savepayment/currency/1/paymentrsult/1/paymentmethod/1")
	public ResponseEntity<?> savepayment_currency_paymentrsult_paymentmethod(@RequestBody JSONObject json){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate = new RestTemplateBuilder(null).
				setConnectTimeout(Duration.ofMinutes(3)).build();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			String url = "http://172.17.1.20:9090/api/savepayment/currency/1/paymentrsult/1/paymentmethod/1?creditCard=2";
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}



	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/login")
	public ResponseEntity<?> login(@RequestBody JSONObject json){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			String url = "http://172.17.1.20:9090/api/login";
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}





	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/voucher/recipient/msisdn/{msisdn}")
	public ResponseEntity<?> voucher_recipient_msisdn(@PathVariable(name = "msisdn",required = true)String msisdn){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:8082/voucher/recipient/msisdn/"+msisdn;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}

		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/savepayment/currency/1/paymentrsult/1/paymentmethod/1/{msisdn}")
	public ResponseEntity<?> savepayment_currency_paymentrsult_paymentmethod(@RequestBody JSONObject json,@PathVariable(name = "msisdn",required = true)String msisdn){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			String url = "http://172.17.1.20:9090/api/savepayment/currency/1/paymentrsult/1/paymentmethod/1?msisdn="+msisdn;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/assigned/device/partner/{partner}")
	public ResponseEntity<?> assigneddevicepartner(@PathVariable(name = "partner",required = true)String partner){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:9090/api/assigned/device/partner/"+partner;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/voucher/all/batch/recipient/{recepient}")
	public ResponseEntity<?> voucher_all_batch_recipient(@PathVariable(name = "recepient",required = true)String recepient){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.20:8082/voucher/all/batch/recipient/"+recepient;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/voucher/save/customer/partner/transaction")
	public ResponseEntity<?> voucher_save_customer_partner_transaction(@RequestBody JSONObject json){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			String url = "http://172.17.1.20:8082/voucher/save/customer/partner/transaction";
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/savepayment/currency/1/paymentrsult/1/paymentmethod/1/no/creditcard")
	public ResponseEntity<?> api_savepayment_currency_1_paymentrsult_1_paymentmethod_1(@RequestBody JSONObject json){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/savepayment/currency/1/paymentrsult/1/paymentmethod/1", HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/assigned/sim/partner/{partner}")
	public ResponseEntity<?> api_assigned_sim_partner(@PathVariable(value="partner")String partner){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/assigned/sim/partner/"+partner, HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/ekyc/activate/{token}")
	public ResponseEntity<?> ekyc_activate(@PathVariable(name = "token",required = true)String token,@RequestBody JSONObject json){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			String url = "http://172.17.1.19:9898/api/ekyc/activate/"+token;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}



	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/save/cart/token/{token}/device/{device}")
	public ResponseEntity<?> save_cart_token_device(@PathVariable(name = "token") String token,@PathVariable(name = "device") String device){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/save/cart/token/"+token+"/device/"+device+"?partner=0", HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj = null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/pack/allocation/get/all/assigned/prepaid/packs/{msisdn}")
	public ResponseEntity<?> pack_allocation_get_all_assigned_prepaid_packs(@PathVariable( name = "msisdn")String msisdn){

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<String> response = null;
		//HttpEntity formEntity = new HttpEntity(ekycActivate, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.11:9698/api/pack/allocation/get/all/assigned/prepaid/packs/"+msisdn, HttpMethod.GET,
					null, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){

				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	
	
	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/prepaid/account/get/available/with/offered/balance")
	public ResponseEntity<?> prepaidaccountgetavailablewithofferedbalance(@RequestParam(name = "imsi")String imsi,@RequestParam(name = "msisdn")String msisdn){

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<String> response = null;
		//HttpEntity formEntity = new HttpEntity(ekycActivate, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.11:9698/api/prepaid/account/get/available/with/offered/balance?imsi="+imsi+"&msisdn="+msisdn, HttpMethod.GET,
					null, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){

				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}
	
	
	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/plan/allocation/postpaid/customer")
	public ResponseEntity<?> plan_allocation_postpaid_customer(@RequestBody JSONObject json){

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.11:9699/api/plan/allocation/postpaid/customer", HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){

				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}



	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/plan/allocation/assigned/postpaid/customer/{msisdn}")
	public ResponseEntity<?> plan_allocation_assinged_postpaid_customer(@PathVariable(name = "msisdn")String msisdn){

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.11:9699/api/plan/allocation/assigned/postpaid/customer/"+msisdn, HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){

				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}



	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PostMapping(value="api/eway/payment")
	public ResponseEntity<?> ewayPayment(@RequestBody JSONObject json){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			response = restTemplate.exchange("http://182.74.113.61/eway/payment_transparent.php", HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PutMapping(value="api/update/image/{id}")
	public ResponseEntity<?> uploadFile(@PathVariable(name = "id")String id,  @RequestParam("customerImage") final MultipartFile customerImage) {

		ResponseEntity<String> response = null;

		//MultipartFile file = imageClass.getCustomerImage();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://172.17.1.20:9090/api/update_image/"+id;
		String accessToken = getCrmAccessToken();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+accessToken);
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);



		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
		try {
			parts.add("image", new ByteArrayResource(customerImage.getBytes()) {
				@Override
				public String getFilename() {
					return customerImage.getOriginalFilename();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>("exception", response.getStatusCode());
		}

		HttpEntity<MultiValueMap<String, Object>> requestEntity =
				new HttpEntity<MultiValueMap<String, Object>>(parts, headers);

		try {
			response =
					restTemplate.exchange(url, 
							HttpMethod.PUT, requestEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}



		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}

	}

	
	
	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/image/{id}" ,  produces = MediaType.IMAGE_JPEG_VALUE)
	
	public @ResponseBody ResponseEntity<Object> api_image_customer(@PathVariable(name = "id")String id, HttpServletResponse res){

		String accessToken = getCrmAccessToken();
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<byte[]> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
	
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/image/"+id, HttpMethod.GET,
					formEntity, byte[].class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				byte[] imageBytes = response.getBody();
				return new ResponseEntity<>(imageBytes, HttpStatus.OK);
				
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){

				return new ResponseEntity<>(response, response.getStatusCode());
				
			}
			else
			{
				return new ResponseEntity<>("ERROR", response.getStatusCode());
				
			}
		}
		catch(HttpClientErrorException ex) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);			
			String msg = ex.getResponseBodyAsString();
			System.out.println(msg+" !!!!"); // this is getting printed as json string.
			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>("error converting json", response.getStatusCode());
				
			}
			
			return new ResponseEntity<>(obj,  responseHeaders, response.getStatusCode());			
		}
	}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@PatchMapping(value="api/partial/update/customer/{id}")
	//http://172.17.1.20:9090/api/partial/update/customer/133%27
	public ResponseEntity<?> partialUpdateCustomer(@PathVariable(name = "id",required = true)String id,@RequestBody JSONObject json){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			String url = "http://172.17.1.20:9090/api/partial/update/customer/"+id;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.PATCH,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}


	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/{type}/account/get/available/with/offered/balance")
	public ResponseEntity<?> api_postpaid_account_get_available_with_offered_balance(@PathVariable(name = "type")String type, @RequestParam(name = "imsi")String imsi,
			@RequestParam(name = "msisdn")String msisdn){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.11:9699/api/"+type+"/account/get/available/with/offered/balance?imsi="+imsi+"&msisdn="+msisdn;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj, ex.getStatusCode());

		}
	}
//http://172.17.1.20:9090/api/partner/contact/{msisdn}

	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/partner/contact/{msisdn}")
	public ResponseEntity<?> apiPartnerContact(@PathVariable(name = "msisdn") String msisdn){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/partner/contact/"+msisdn, HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj = null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

	
	
	/*@CrossOrigin(origins = "*", allowedHeaders = "*")*/
	@GetMapping(value="api/invoice/list/msisdn/{msisdn}")
	public ResponseEntity<?> apiinvoicelistmsisdn(@PathVariable(name = "msisdn",required = true)String msisdn){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.5.10.2:9090/api/invoice/list/msisdn/"+msisdn;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONArray obj=null;
				try {
					obj = (JSONArray) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}
	
	
	
	@GetMapping(value="api/{connectionType}/bill/payment/invoiceNumber/{invoiceNumber}/amount/"
			+ "{amount}/currency/{currency}/paymentrsult/{paymentrsult}/paymentmethod/{paymentmethod}")
	public ResponseEntity<?> somelongrequest(@PathVariable(value="connectionType")String connectionType,
			@PathVariable(value="invoiceNumber")String invoiceNumber,
			@PathVariable(value="amount")String amount,
			@PathVariable(value="currency")String currency,
			@PathVariable(value="paymentrsult")String paymentrsult,
			@PathVariable(value="paymentmethod")String paymentmethod,
			@RequestParam(value = "creditCard")String creditCard,
			@RequestParam(value = "partner")String partner,
			@RequestParam(value = "transactionId")String transactionId
			){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		String strUrl = null;
		try {
			if(transactionId!=null)
				strUrl = "http://172.17.1.20:9090/api/"+connectionType+"/bill/payment/invoiceNumber/"+invoiceNumber+"/amount/"+amount+"/currency/"+currency+"/paymentrsult/"+paymentrsult+"/paymentmethod/"+paymentmethod+"?creditCard="+creditCard+"&partner="+partner+"&transactionId="+transactionId; 
			else
				strUrl = "http://172.17.1.20:9090/api/"+connectionType+"/bill/payment/invoiceNumber/"+invoiceNumber+"/amount/"+amount+"/currency/"+currency+"/paymentrsult/"+paymentrsult+"/paymentmethod/"+paymentmethod+"?creditCard="+creditCard+"&partner="+partner; 
			response = restTemplate.exchange(strUrl, HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}

//	@GetMapping(value="api/plan/allocation/assigned/postpaid/customer/{msisdn}")
//	public ResponseEntity<?> apiplanallocationassignedpostpaidcustomer(
//			@PathVariable(value="msisdn")String msisdn
//			){
//
//		//String accessToken = getCrmAccessToken();
//		//System.out.println("ACCESS TOKEN : "+accessToken);
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//		//headers.add("Authorization", "Bearer "+accessToken);
//		ResponseEntity<String> response = null;
//		HttpEntity formEntity = new HttpEntity(null, headers);
//		try {
//			String url = "http://172.17.1.11:9699/api/plan/allocation/assigned/postpaid/customer/"+msisdn;
//			System.out.println(url);
//			response = restTemplate.exchange(url , HttpMethod.GET,
//					formEntity, String.class);
//
//			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
//				String actualResponse = response.getBody();
//				JSONParser parser =new JSONParser();
//				JSONObject obj=null;
//				try {
//					obj = (JSONObject) parser.parse(actualResponse);
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				return new ResponseEntity<>(obj, HttpStatus.OK);
//			}
//			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
//				System.out.println("1");
//				return new ResponseEntity<>(response, response.getStatusCode());
//			}
//			else
//			{
//				System.out.println("2");
//				return new ResponseEntity<>("ERROR", response.getStatusCode());
//
//			}
//		}
//		//			catch(HttpClientErrorException ex) {
//		//			ex.printStackTrace();
//		//			String lMsg = ex.getLocalizedMessage();
//		//			//String msg = ex.getMessage();
//		////			JSONParser parser =new JSONParser();
//		////			JSONObject obj = null;
//		////			try {
//		////			obj = (JSONObject)parser.parse(lMsg);
//		////		}catch(Exception ex_) {
//		////			ex_.printStackTrace();
//		////		}
//		//			System.out.println("exception check check check check check ");
//		//			
//		//			long l_end_time = System.currentTimeMillis();
//		//			long l_diff = l_end_time-l_time_start;
//		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
//		//
//		//		}
//
//		catch(HttpClientErrorException ex) {
//			System.out.println("herehherehehrhehehrehrherhe");
//			ex.printStackTrace();
//			String msg = ex.getResponseBodyAsString();
//
//			JSONParser parser =new JSONParser();
//			JSONObject obj = null;
//			try {
//				obj = (JSONObject)parser.parse(msg);
//
//			}catch(Exception ex_) {
//				ex_.printStackTrace();
//				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);
//
//			}
//			return new ResponseEntity<>(obj , ex.getStatusCode());
//
//		}
//	}

	@GetMapping(value="api/plan/allocation/assigned/prepaid/customer/{msisdn}")
	public ResponseEntity<?> apiplanallocationassignedprepaidcustomer(
			@PathVariable(value="msisdn")String msisdn
			){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			String url = "http://172.17.1.11:9698/api/pack/allocation/assigned/prepaid/customer/"+msisdn;
			System.out.println(url);
			response = restTemplate.exchange(url , HttpMethod.GET,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}

		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}
	//http://172.17.1.20:9090/api/sim/activate/code/121/text/ACT/msisdn/
	@PostMapping(value="api/sim/activate/code/{code}/")
	public void somemethod(){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);
		//http://172.5.10.2:9090/api/sim/activate/code/%7BshortCode%7D/text/%7Btext%7D/msisdn/%7Bmsisdn%7D%27
		
		String text = "text text text";
		String shortCode = "121";
		String msisdn = "9088723";
		
		String url = "http://172.5.10.2:9090/api/sim/activate/code/"+shortCode+"/text/"+text+"/msisdn/"+msisdn;
		
		System.out.println("## "+url);
		
		
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange(url, HttpMethod.POST,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println(obj.toJSONString());
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println(response);
			}
			else
			{
				System.out.println("error");
			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);
				System.out.println(obj.toJSONString());
			}catch(Exception ex_) {
				ex_.printStackTrace();

			}
	
		}
	}
//http://172.17.1.20:9090/api/map/parent_number/6741234571/child_number/6749991025%27
	@GetMapping(value="api/map/parent_number/{parent}/child_number/{child}")
	public ResponseEntity<?> apimapparentnumberchildnumber(@PathVariable(value="parent")String parent,
			@PathVariable(value="child")String child){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/map/parent_number/"+parent+"/child_number/"+child, HttpMethod.PUT,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}
//http://172.17.1.20:9090/api/child_account_of_parent/6741234571
	@GetMapping(value="api/child_account_of_parent/{parent}")
	public ResponseEntity<?> apimapparentnumber(@PathVariable(value="parent")String parent){

		String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(null, headers);
		try {
			response = restTemplate.exchange("http://172.17.1.20:9090/api/child_account_of_parent/"+parent, HttpMethod.PUT,
					formEntity, String.class);

			if(response!=null && response.getStatusCode().is2xxSuccessful()) {
				String actualResponse = response.getBody();
				JSONParser parser =new JSONParser();
				JSONObject obj=null;
				try {
					obj = (JSONObject) parser.parse(actualResponse);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(obj, HttpStatus.OK);
			}
			else if(response!=null && !response.getStatusCode().is2xxSuccessful()){
				System.out.println("1");
				return new ResponseEntity<>(response, response.getStatusCode());
			}
			else
			{
				System.out.println("2");
				return new ResponseEntity<>("ERROR", response.getStatusCode());

			}
		}
		//			catch(HttpClientErrorException ex) {
		//			ex.printStackTrace();
		//			String lMsg = ex.getLocalizedMessage();
		//			//String msg = ex.getMessage();
		////			JSONParser parser =new JSONParser();
		////			JSONObject obj = null;
		////			try {
		////			obj = (JSONObject)parser.parse(lMsg);
		////		}catch(Exception ex_) {
		////			ex_.printStackTrace();
		////		}
		//			System.out.println("exception check check check check check ");
		//			
		//			long l_end_time = System.currentTimeMillis();
		//			long l_diff = l_end_time-l_time_start;
		//			return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(response.getStatusCode(), ResponseStatusEnum.FAILED, ApplicationResponse.Failed,lMsg,l_diff+" ms"),response.getStatusCode());				
		//
		//		}


		catch(HttpClientErrorException ex) {
			System.out.println("herehherehehrhehehrehrherhe");
			ex.printStackTrace();
			String msg = ex.getResponseBodyAsString();

			JSONParser parser =new JSONParser();
			JSONObject obj = null;
			try {
				obj = (JSONObject)parser.parse(msg);

			}catch(Exception ex_) {
				ex_.printStackTrace();
				return new ResponseEntity<>(obj , HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj , ex.getStatusCode());

		}
	}
}

