 
package com.example.Vehicle_Renting_Application.Mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle_Renting_Application.DTO.VehicleRequest;
import com.example.Vehicle_Renting_Application.DTO.VehicleResponse;
import com.example.Vehicle_Renting_Application.entity.Vehicle;


@Component
public class VehicleMapper {

	public Vehicle mapToVehicle(VehicleRequest vehicleRequest, Vehicle vehicle) {
		if (vehicleRequest.getBrand() != null) {
			vehicle.setBrand(vehicleRequest.getBrand());
		}
		if (vehicleRequest.getModel() != null) {
			vehicle.setModel(vehicleRequest.getModel());
		}
		if (vehicleRequest.getVehicleType() != null) {
			vehicle.setVehicleType(vehicleRequest.getVehicleType());
		}
		if (vehicleRequest.getFuelType() != null) {
			vehicle.setFuelType(vehicleRequest.getFuelType());
		}
		return vehicle;
	}

	public VehicleResponse mapToResponse(Vehicle vehicle) {
		VehicleResponse response = new VehicleResponse();
		response.setVehicleId(vehicle.getVehicleId());
		response.setBrand(vehicle.getBrand());
		response.setModel(vehicle.getModel());
		response.setVehicleType(vehicle.getVehicleType());
		response.setFuelType(vehicle.getFuelType());
		return response;
	}
}
