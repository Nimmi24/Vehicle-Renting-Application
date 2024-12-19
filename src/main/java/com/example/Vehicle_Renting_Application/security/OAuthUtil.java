package com.example.Vehicle_Renting_Application.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.Vehicle_Renting_Application.entity.User;
import com.example.Vehicle_Renting_Application.Repository.UserRepository;

@Component
public class OAuthUtil {

	private final UserRepository userRepository;

	public OAuthUtil(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public String getCurrentUsername() {
		return this.getAuthentication().getName();
	}

	public User getCurrentUser() {
		return userRepository.findByEmail(getCurrentUsername())
			.orElseThrow();
	}

}
