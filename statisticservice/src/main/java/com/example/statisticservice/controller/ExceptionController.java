package com.example.statisticservice.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public Map<String, String> conflicData(Exception e) {
		logger.info(e.getMessage());

		Map<String, String> map = new HashMap<>();

		map.put("code", "409");
		map.put("error", "conflic data");

		return map;
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public Map<String, String> methodNotSupportedException(Exception ex) {
		logger.info(ex.getMessage());

		Map<String, String> reponse = new HashMap<>();

		reponse.put("code", "405");
		reponse.put("error", "method not allowed");
		
		return reponse;
	}
	
	@ExceptionHandler({HttpMessageNotReadableException.class,MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> badRequestHandler(Exception ex){
		logger.info(ex.getMessage());

		Map<String, String> reponse = new HashMap<>();

		reponse.put("code", "400");
		reponse.put("error", "params are wrong types");
		
		return reponse;
	}
}
