package com.laptop.laptopbag.exception;

public class LaptopDetailNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String exceptionMessage;

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public LaptopDetailNotFoundException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	public LaptopDetailNotFoundException() {
	}
}
