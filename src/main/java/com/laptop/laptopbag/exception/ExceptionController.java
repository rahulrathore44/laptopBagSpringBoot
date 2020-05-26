package com.laptop.laptopbag.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = LaptopDetailNotFoundException.class)
	public ResponseEntity<Object> exception(LaptopDetailNotFoundException exception) {
		return new ResponseEntity<Object>(new ErrorMessage(HttpStatus.NOT_FOUND, exception.getExceptionMessage()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InvalIdException.class)
	public ResponseEntity<Object> exception(InvalIdException exception) {
		return new ResponseEntity<Object>(new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getExceptionMessage()),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = UnauthorizeException.class)
	public ResponseEntity<Object> exception(UnauthorizeException exception) {
		return new ResponseEntity<Object>(new ErrorMessage(HttpStatus.UNAUTHORIZED, exception.getExceptionMessage()),
				HttpStatus.UNAUTHORIZED);
	}
}
