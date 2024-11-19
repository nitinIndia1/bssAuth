package com.bssAuth.controller;
import java.time.Duration;
import java.util.*;
import java.util.stream.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.function.*;

//@RestController
public class NewController {
	@PostMapping(value="api2/test")
	public ResponseEntity<?> api2test(@RequestBody JSONObject json){

		//String accessToken = getCrmAccessToken();
		//System.out.println("ACCESS TOKEN : "+accessToken);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate = new RestTemplateBuilder(null).
				setConnectTimeout(Duration.ofMinutes(3)).build();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		//headers.add("Authorization", "Bearer "+accessToken);
		ResponseEntity<String> response = null;
		HttpEntity formEntity = new HttpEntity(json, headers);
		try {
			String url = "https://dppoapiproxy.linksfield.net/apiProxy/es2/downloadOrder";
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
				return new ResponseEntity<>(obj+" error", HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<>(obj+" error", ex.getStatusCode());

		}
	}
}
