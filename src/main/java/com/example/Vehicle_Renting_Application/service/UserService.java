package com.example.Vehicle_Renting_Application.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle_Renting_Application.Repository.ImageRepository;
import com.example.Vehicle_Renting_Application.Repository.UserRepository;
import com.example.Vehicle_Renting_Application.entity.Image;
import com.example.Vehicle_Renting_Application.entity.User;
import com.example.Vehicle_Renting_Application.exception.FailedToUploadImageException;
import com.example.Vehicle_Renting_Application.exception.UserNotFoundByIdException;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		
	}


	public User addUser(User user) {
		return userRepository.save(user);
		
	}



}
