package com.cg.sprint1_onlineplantnursery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerNotFoundExceptionHandler {

	@ExceptionHandler
	
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException exception) {

		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
