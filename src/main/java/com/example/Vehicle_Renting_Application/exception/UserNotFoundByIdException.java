package com.example.Vehicle_Renting_Application.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class UserNotFoundByIdException extends BaseException {

	public UserNotFoundByIdException(String message) {
		super(message);
		
	}
	


}
