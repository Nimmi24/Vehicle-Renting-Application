package com.example.Vehicle_Renting_Application.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vehicle_Renting_Application.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	
}
