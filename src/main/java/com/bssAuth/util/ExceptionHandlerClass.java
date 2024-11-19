package com.bssAuth.util;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//@RestControllerAdvice
public class ExceptionHandlerClass {

	
	//@ResponseStatus(HttpStatus.NOT_FOUND)
	//@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<CoreResponseHandler> handleInvalidArgument(EntityNotFoundException ex) {
		long l_diff = 0;
		long l_time_start = System.currentTimeMillis();	
		System.out.println("here here here here here");
		long l_end_time = System.currentTimeMillis();
		l_diff = l_end_time-l_time_start;
		return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.NOT_FOUND, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,ex.getMessage(),l_diff+" ms") ,HttpStatus.NOT_FOUND);

	}
	//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	//@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<CoreResponseHandler> handleInternalError(RuntimeException ex) {
		long l_diff = 0;
		long l_time_start = System.currentTimeMillis();	
		System.out.println("here here here here here");
		long l_end_time = System.currentTimeMillis();
		l_diff = l_end_time-l_time_start;
		return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,ex.getMessage(),l_diff+" ms") ,HttpStatus.INTERNAL_SERVER_ERROR);

	}
	//java.lang.InternalError.InternalError(String message)
	
}
