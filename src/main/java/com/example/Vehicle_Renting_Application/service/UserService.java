package com.example.Vehicle_Renting_Application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Vehicle_Renting_Application.Repository.UserRepository;
import com.example.Vehicle_Renting_Application.entity.User;

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
