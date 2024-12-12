package com.example.Vehicle_Renting_Application.util;

public class ErrorStructure {

	private int status;
	private String message;
	private String rootCause;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public static ErrorStructure create(int status, String message, String rootCause) {
		ErrorStructure errorStructure = new ErrorStructure();
		errorStructure.setStatus(status);
		errorStructure.setMessage(message);
		errorStructure.setRootCause(rootCause);
		
		return errorStructure;
	}

}
