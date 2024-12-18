package com.example.Vehicle_Renting_Application.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Vehicle_Renting_Application.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u.profilePicture.imageId FROM User u WHERE u.userId= :userId")
	Integer getProfilePictureByIdUserId(int userId);
	
	
}
