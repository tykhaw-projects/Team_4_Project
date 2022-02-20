package com.ncs.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ncs.exception.ErrorResponse;
import com.ncs.exception.InventoryIDNotFoundException;
import com.ncs.exception.ProductIDNotFoundException;

@RestControllerAdvice
public class InventoryControllerAdvice {
	@ExceptionHandler(InventoryIDNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleInventoryIDNotFoundException(InventoryIDNotFoundException e) {
		ErrorResponse err = new ErrorResponse("Inventory-404", "Inventory with specific inventory ID not found!", new Date());
		return new ResponseEntity<ErrorResponse>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductIDNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductIDNotFoundException(ProductIDNotFoundException e) {
		ErrorResponse err = new ErrorResponse("Product-404", "Inventory with specific product ID not found!", new Date());
		return new ResponseEntity<ErrorResponse>(err, HttpStatus.NOT_FOUND);
	}
}