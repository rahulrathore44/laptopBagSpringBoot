package com.laptop.laptopbag.exception;

import org.springframework.http.HttpStatus;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
