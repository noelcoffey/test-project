package com.sample.web;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ApplicationExceptionHandler { 

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleInvalidRequest(MethodArgumentNotValidException ex) {
		
		LOG.error(ex.getMessage());

		ErrorResponse errorResponse = new ErrorResponse();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			errorResponse.addMessage(error.getDefaultMessage());
		}
		
		return errorResponse;
	}
	
	@ExceptionHandler(value = EntityNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleMissingEntityReference(EntityNotFoundException ex) {
		
		LOG.error(ex.getMessage());

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
		
		return errorResponse;
	}
}
