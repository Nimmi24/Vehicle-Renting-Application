package com.example.Vehicle_Renting_Application.exception;

public class BaseException extends RuntimeException{
	
	private final String mesage;

	public BaseException(String mesage) {
		super();
		this.mesage = mesage;
	}

	public String getMesage() {
		return mesage;
	}
	
	
	

}
