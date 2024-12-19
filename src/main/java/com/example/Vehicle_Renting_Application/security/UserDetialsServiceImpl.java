package com.example.Vehicle_Renting_Application.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Vehicle_Renting_Application.entity.User;
import com.example.Vehicle_Renting_Application.Repository.UserRepository;

@Service
public class UserDetialsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetialsServiceImpl(UserRepository repository) {
		super();
		this.userRepository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Failed To Authenticate User"));
		return new UserDetailsImpl(user);
	}

}
