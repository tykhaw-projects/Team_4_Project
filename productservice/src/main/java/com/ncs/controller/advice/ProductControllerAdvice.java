package com.ncs.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ncs.exception.ProductIDMismatchException;
import com.ncs.exception.ProductIdNotFoundException;
import com.ncs.exception.ProductNameNotFoundException;
import com.ncs.exception.ProductPriceNotFoundException;
import com.ncs.exception.ProductTypeNotFoundException;
import com.ncs.exception.ErrorResponse;


@RestControllerAdvice
public class ProductControllerAdvice {
	
	
	
	@ExceptionHandler(ProductIDMismatchException.class)
	 public ResponseEntity<ErrorResponse> handleProductIDMismatchException(ProductIDMismatchException e)
	 {
		 
		 ErrorResponse er= new ErrorResponse("Product-400", "Product ID mismatch!", new Date());
		  return new ResponseEntity<ErrorResponse>(er,HttpStatus.BAD_REQUEST);
	 }
	
	@ExceptionHandler(ProductIdNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleProductIdNotFound(ProductIdNotFoundException e)
	 {
		 
		 ErrorResponse er= new ErrorResponse("Product-404", "Product with the specified ID Not found!", new Date());
		  return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	 }
	
	@ExceptionHandler(ProductPriceNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleProductPriceNotFound(ProductPriceNotFoundException e)
	 {
		 
		 ErrorResponse er= new ErrorResponse("Product-404", "Product with the specified price Not found!", new Date());
		  return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	 }
	
	@ExceptionHandler(ProductTypeNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleProductTypeNotFound(ProductTypeNotFoundException e)
	 {
		 
		 ErrorResponse er= new ErrorResponse("Product-404", "Product with the specified type Not found!", new Date());
		  return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	 }
	
	@ExceptionHandler(ProductNameNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleProductNameNotFound(ProductNameNotFoundException e)
	 {
		 
		 ErrorResponse er= new ErrorResponse("Product-404", "Product with the specified Name Not found!", new Date());
		  return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	 }
	

}