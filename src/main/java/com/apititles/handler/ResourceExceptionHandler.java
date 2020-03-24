package com.apititles.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apititles.main.DetailsError;
import com.apititles.services.exception.TitleAlreadyExistsException;
import com.apititles.services.exception.TitleNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(TitleNotFoundException.class)
	public ResponseEntity<DetailsError> handleTitleNotFoundException
						(TitleNotFoundException e, HttpServletRequest request){
		DetailsError error = new DetailsError();
		
		error.setStatus(404l);
		error.setTitle("O título não foi encontrado");
		error.setTimestapLong(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	@ExceptionHandler(TitleAlreadyExistsException.class)
	public ResponseEntity<DetailsError> handleTitleAlreadyExistsException
						(TitleAlreadyExistsException e, HttpServletRequest request){
		DetailsError error = new DetailsError();
		
		error.setStatus(409l);
		error.setTitle("O título já existe");
		error.setTimestapLong(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
		
	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity <DetailsError> handlerDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetailsError error = new DetailsError();
		
		error.setStatus(400l);
		error.setTitle("Requisição inválida");
		error.setTimestapLong(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
		
	}
}
