package com.spring.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntity extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(UsernameNotFoundException e, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(),
				request.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}
