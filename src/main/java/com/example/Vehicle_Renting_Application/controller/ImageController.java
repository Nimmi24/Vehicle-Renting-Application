package com.example.Vehicle_Renting_Application.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle_Renting_Application.entity.Image;
import com.example.Vehicle_Renting_Application.service.ImageService;
import com.example.Vehicle_Renting_Application.service.UserService;
import com.example.Vehicle_Renting_Application.util.SimpleResponseStructure;

@RestController
public class ImageController {
	
	private final ImageService imageService;
	
	
	
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}



	@PostMapping("/user-profile-picture")
	public ResponseEntity<SimpleResponseStructure> addProfilePicture(
			@RequestParam("userId")int userId,
			@RequestParam("file")MultipartFile file)throws IOException {
		imageService.addUserProfilePicture(userId,file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(SimpleResponseStructure.create(HttpStatus.OK.value(), "Profile Picture added"));
	}
	
	@GetMapping("/find/imageById")
	public ResponseEntity<byte[]> findImageById(@RequestParam int imageId){
		
		Image image = imageService.findImageById(imageId);
		return ResponseEntity.status(HttpStatus.OK)
				              .contentType(MediaType.valueOf(image.getContentType()))
				              .body(image.getImageByte());
				             
	}
	
}
