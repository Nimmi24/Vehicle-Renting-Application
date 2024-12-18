package com.example.Vehicle_Renting_Application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Vehicle_Renting_Application.DTO.UserRequest;
import com.example.Vehicle_Renting_Application.DTO.UserResponse;
import com.example.Vehicle_Renting_Application.Mapper.UserMapper;
import com.example.Vehicle_Renting_Application.Repository.UserRepository;
import com.example.Vehicle_Renting_Application.entity.User;
import com.example.Vehicle_Renting_Application.enums.UserRole;
import com.example.Vehicle_Renting_Application.exception.UserNotFoundByIdException;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public UserResponse findUser(int userId) {

		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {

			User user = optional.get();

			UserResponse response = userMapper.mapToResponse(user);
			this.setProfilePictureURL(response, user.getUserId());

			return response;

		}else {
			throw new UserNotFoundByIdException("User not found");

		}
	}
	private void setProfilePictureURL(UserResponse response, int userId) {

		int imageId = userRepository.getProfilePictureByIdUserId(userId);
		if(imageId > 0)
			response.setProfilePicture("/find/image-By-Id?image-id=" + imageId);
	}

	public UserResponse registor(UserRequest userRequest, UserRole role) {
		User user= userMapper.mapToUser(userRequest, new User());
		user.setUserRole(role);
		User savedUser = userRepository.save(user);		
		return userMapper.mapToResponse(savedUser);
	}

}
