package com.example.Vehicle_Renting_Application.controller;


import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle_Renting_Application.entity.User;
import com.example.Vehicle_Renting_Application.service.UserService;
import com.example.Vehicle_Renting_Application.util.ResponseStructure;
import com.example.Vehicle_Renting_Application.util.SimpleResponseStructure;


@RestController
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
			
	}
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		user = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", user));

	}
}
