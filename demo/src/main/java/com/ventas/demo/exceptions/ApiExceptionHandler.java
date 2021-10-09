package com.ventas.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations=RestController.class)
public class ApiExceptionHandler {
	
	@ExceptionHandler(value= {ApiRequestException.class})
	public ResponseEntity<?> ApiRequestException(ApiRequestException d){

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity.status(status).body(d.getMessage());

	}
	
	@ExceptionHandler(value= {BusinessException.class})
	public ResponseEntity<?> BadRequestException(BusinessException d){

		HttpStatus status = HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status).body(d.getMessage());

	}
}
