package com.cetpa.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cetpa.exceptions.DoctorNotFound;
import com.cetpa.exceptions.PatientNotFound;

@RestControllerAdvice
public class ValidationAndExceptionHandlerController extends ResponseEntityExceptionHandler
{
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		System.out.println("Handler called");
		BindingResult br=ex.getBindingResult();
		List<ObjectError> objectErrorList=br.getAllErrors();
		List<String> errorList=new ArrayList<String>();
		for(ObjectError error:objectErrorList)
		{
			errorList.add(error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
	@ExceptionHandler(PatientNotFound.class)
	public ResponseEntity<Object> handlePatientNotFount(PatientNotFound ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleOtherException(Exception ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(DoctorNotFound.class)
	public ResponseEntity<Object> handleDoctorNotFount(DoctorNotFound ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
