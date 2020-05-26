package com.laptop.laptopbag.exception;

public class UnauthorizeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String exceptionMessage;

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public UnauthorizeException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	public UnauthorizeException() {
	}
}
