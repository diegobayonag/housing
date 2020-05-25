package com.scotiabank.housing.rest.util;

/**
* <h1>Error Message Wrapper</h1>
* Utility class 
* 
* @author  Diego Bayona Gómez
* @version 1.0
* @since   2020-05-23
*/

public class ErrorMessageWrapper {

	private String errorCode;

	private String errorField;
	
	private String errorMessage;

	public ErrorMessageWrapper(String _errorCode, String _errorField, String _errorMessage) {
		super();
		this.errorCode = _errorCode;
		this.errorField = _errorField;
		this.errorMessage = _errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorField() {
		return errorField;
	}

	public void setErrorField(String errorField) {
		this.errorField = errorField;
	}
	
	
}
