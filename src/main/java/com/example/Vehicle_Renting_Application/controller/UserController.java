package com.example.Vehicle_Renting_Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicle_Renting_Application.DTO.UserRequest;
import com.example.Vehicle_Renting_Application.DTO.UserResponse;
import com.example.Vehicle_Renting_Application.enums.UserRole;
import com.example.Vehicle_Renting_Application.service.UserService;
import com.example.Vehicle_Renting_Application.util.ResponseStructure;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
          
	}

	
	@GetMapping("/find-User")
	public ResponseEntity<ResponseStructure<UserResponse>> findUser(@RequestParam int userId) {
		UserResponse userResponse = userService.findUser(userId);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Not Found", userResponse));

	}


	@PostMapping("/customer/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registorCustomer(@RequestBody UserRequest userRequest) {
		UserResponse userResponse = userService.registor(userRequest, UserRole.CUSTOMER);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", userResponse));

	}

	@PostMapping("/renting-partner/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registorRentingPartner(@RequestBody UserRequest userRequest) {
		UserResponse userResponse = userService.registor(userRequest, UserRole.RENTING_PARTNER);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", userResponse));

	}
	
}
