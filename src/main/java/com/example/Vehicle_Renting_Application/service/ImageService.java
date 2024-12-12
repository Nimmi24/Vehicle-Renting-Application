package com.example.Vehicle_Renting_Application.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle_Renting_Application.Repository.ImageRepository;
import com.example.Vehicle_Renting_Application.Repository.UserRepository;
import com.example.Vehicle_Renting_Application.entity.Image;
import com.example.Vehicle_Renting_Application.entity.User;
import com.example.Vehicle_Renting_Application.exception.FailedToUploadImageException;
import com.example.Vehicle_Renting_Application.exception.ImageNotFoundByIdException;
import com.example.Vehicle_Renting_Application.exception.UserNotFoundByIdException;

@Service
public class ImageService {
	
	private final ImageRepository imageRepository;
	private final UserRepository userRepository;
	

	public ImageService(ImageRepository imageRepository, UserRepository userRepository) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository = userRepository;
	}
	public void addUserProfilePicture(int userId, MultipartFile multipartFile){
		Optional<User> optional = userRepository.findById(userId);

		
		if (optional.isPresent()) {

			Image image = ImageService.getImage(multipartFile);
			image = imageRepository.save(image);

			User user = optional.get();
			user.setProfilePicture(image);
			userRepository.save(user);
			
		} else {
			throw new UserNotFoundByIdException("Failed to Find the user");
		}
	}
	public static Image getImage(MultipartFile imagefile) {
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
	
	public Image findImageById(int imageId) {
		Optional<Image> optional = imageRepository.findById(imageId);
		if (optional.isPresent()) {
			return optional.get();	
		}else {
			throw new ImageNotFoundByIdException("Failed to find the image");
			
		}
		
		
	}
	

}
