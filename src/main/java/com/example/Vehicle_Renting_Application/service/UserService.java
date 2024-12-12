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
	
	private final ImageRepository imageRepository;
	
	public UserService(UserRepository userRepository, ImageRepository imageRepository) {
		super();
		this.userRepository = userRepository;
		this.imageRepository = imageRepository;
	}


	public User addUser(User user) {
		return userRepository.save(user);
		
	}
	public void addUserProfilePicture(int userId, MultipartFile multipartFile){
		Optional<User> optional = userRepository.findById(userId);

		if (optional.isPresent()) {

			Image image = getImage(multipartFile);
			image = imageRepository.save(image);

			User user = optional.get();
			user.setProfilePicture(image);
			userRepository.save(user);
		} else {
			throw new UserNotFoundByIdException("Failed to Find the user");
		}
	}

	private Image getImage(MultipartFile imagefile) {
		Image image = new Image();
		try {
			byte[] imageBytes = imagefile.getBytes();
			image.setContentType(imagefile.getContentType());
			image.setImageByte(imageBytes);
		} catch (IOException e) {
			throw new FailedToUploadImageException("Failed to upload the Image");
		}

		return image;
	}

	 
	



	

}
