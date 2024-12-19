package com.example.Vehicle_Renting_Application.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Vehicle_Renting_Application.Mapper.UserMapper;
import com.example.Vehicle_Renting_Application.entity.User;
import com.example.Vehicle_Renting_Application.enums.UserRole;
import com.example.Vehicle_Renting_Application.Repository.UserRepository;
import com.example.Vehicle_Renting_Application.DTO.UserRequest;
import com.example.Vehicle_Renting_Application.DTO.UserResponse;
import com.example.Vehicle_Renting_Application.security.OAuthUtil;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final UserMapper mapper;

	private final PasswordEncoder passwordEncoder;

	private final OAuthUtil authUtil;

	public UserService(UserRepository userRepository, UserMapper mapper, PasswordEncoder passwordEncoder,
			OAuthUtil authUtil) {
		super();
		this.userRepository = userRepository;
		this.mapper = mapper;
		this.passwordEncoder = passwordEncoder;
		this.authUtil = authUtil;
	}

	public UserResponse register(UserRequest userRequest, UserRole userRole) {
		try {
			User user = mapper.mapToUser(userRequest, new User());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRole(userRole);
			user = userRepository.save(user);
			return mapper.mapToResponse(user);
		} catch (Exception ex) {
			if (ex.getMessage().contains("email")) {
				throw new IllegalArgumentException("Email already exists. Please use a different email.");
			}
			throw ex;
		}
	}

	public UserResponse findUser() {
		User user = authUtil.getCurrentUser();

		UserResponse userResponse = mapper.mapToResponse(user);

		Integer profilePictureId = userRepository.findImageIdByUserId(user.getUserId());

		if (profilePictureId != null) {
			userResponse.setProfilePictureLink("/find/imageById?imageId=" + profilePictureId);
		} else {
			userResponse.setProfilePictureLink(null);
		}
		return userResponse;
	}

	public UserResponse updateUser(UserRequest userRequest) {

		User updatedUser = mapper.mapToUser(userRequest, authUtil.getCurrentUser());
		updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
		updatedUser = userRepository.save(updatedUser);

		return mapper.mapToResponse(updatedUser);

	}

}