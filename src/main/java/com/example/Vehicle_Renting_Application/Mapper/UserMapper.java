package com.example.Vehicle_Renting_Application.Mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle_Renting_Application.DTO.UserRequest;
import com.example.Vehicle_Renting_Application.DTO.UserResponse;
import com.example.Vehicle_Renting_Application.entity.User;

@Component
public class UserMapper {

	public User mapToUser(UserRequest request, User user) {
		
		
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setPassword(request.getPassword());
		
		
		return user;
	}

	public UserResponse mapToResponse(User user) {
		
		UserResponse response = new UserResponse();
		response.setUserName(user.getUserName());
		response.setEmail(user.getEmail());
		response.setPhoneNumber(user.getPhoneNumber());
		response.setUserRole(user.getUserRole());
		response.setUserId(user.getUserId());
		
		return response;

	}
	

}
