package com.cg.sprint1_onlineplantnursery.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SeedExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String,String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {String fieldName = ((FieldError) error).getField();
		String errorMessage = error.getDefaultMessage();
		errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
	@ExceptionHandler(SeedIdNotFoundException.class)
	ResponseEntity<?> SeedIdNotFound(SeedIdNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage("400", ex.getMessage());
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OutOfStockException.class)
	ResponseEntity<?> OutOfStock(OutOfStockException oex){
		ErrorMessage errorMessage = new ErrorMessage("400",oex.getMessage());
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ErrorMessage handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		return new ErrorMessage("400","The value of BloomTime or Difficulty is INVALID");
	}

}