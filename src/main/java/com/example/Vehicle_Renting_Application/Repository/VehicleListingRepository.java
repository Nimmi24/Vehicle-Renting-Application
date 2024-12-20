package com.example.Vehicle_Renting_Application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vehicle_Renting_Application.entity.Vehicle;
import com.example.Vehicle_Renting_Application.entity.VehicleListing;

public interface VehicleListingRepository extends JpaRepository<VehicleListing, Integer> {

	List<VehicleListing> findByVehicle(Vehicle vehicle);

}
