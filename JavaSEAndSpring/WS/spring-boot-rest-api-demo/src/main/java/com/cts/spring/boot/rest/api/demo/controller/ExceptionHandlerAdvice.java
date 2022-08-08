package com.cts.spring.boot.rest.api.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.spring.boot.rest.api.demo.exception.InvalidTxnException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(InvalidTxnException.class)
	public ResponseEntity<String> handleInvalidTxnException(InvalidTxnException exp){
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exp){
		exp.printStackTrace();
		return new ResponseEntity<String>("Request can not be processed! Please try agian later", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
