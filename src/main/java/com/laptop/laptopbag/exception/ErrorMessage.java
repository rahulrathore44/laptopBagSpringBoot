package com.laptop.laptopbag.exception;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

@XmlRootElement
public class ErrorMessage {
	private String errorMessage;

	@XmlElement(name = "ErrorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@XmlElement(name = "ErrorCode")
	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	private HttpStatus errorCode;
	
	public ErrorMessage() {
	}
	
	public ErrorMessage(HttpStatus statusCode, String errorMessge) {
		this.errorCode = statusCode;
		this.errorMessage = errorMessge;
	}
}
