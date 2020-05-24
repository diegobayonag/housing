package com.scotiabank.housing.rest.util;

public class ErrorMessageWrapper {

	private String errorMessage;

	public ErrorMessageWrapper(String _errorMessage) {
		super();
		this.errorMessage = _errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
