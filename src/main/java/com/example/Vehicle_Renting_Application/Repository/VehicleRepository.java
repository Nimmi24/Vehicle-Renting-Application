package com.example.Vehicle_Renting_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Vehicle_Renting_Application.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
