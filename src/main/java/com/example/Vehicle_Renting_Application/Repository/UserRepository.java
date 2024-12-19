package com.example.Vehicle_Renting_Application.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Vehicle_Renting_Application.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u.profilePicture.id FROM User u WHERE u.userId = :userId")
	Integer findImageIdByUserId(int userId);

	Optional<User> findByEmail(String userEmail);
}
