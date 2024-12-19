package com.example.Vehicle_Renting_Application.Mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle_Renting_Application.entity.User;
import com.example.Vehicle_Renting_Application.DTO.UserRequest;
import com.example.Vehicle_Renting_Application.DTO.UserResponse;

@Component
public class UserMapper {

    public User mapToUser(UserRequest userRequest, User user) {
        if (userRequest.getUsername() != null) {
            user.setUsername(userRequest.getUsername());
        }
        if (userRequest.getEmail() != null) {
            user.setEmail(userRequest.getEmail());
        }
        if (userRequest.getPhoneNumber() != null) {
            user.setPhoneNumber(userRequest.getPhoneNumber());
        }
        if (userRequest.getPassword() != null) {
            user.setPassword(userRequest.getPassword());
        }
        return user;
    }

    public UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setRole(user.getRole());
      
        return response;
    }
}


