package com.example.Vehicle_Renting_Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Vehicle_Renting_Application.exception.VehicleNotFoundException;
import com.example.Vehicle_Renting_Application.DTO.VehicleRequest;
import com.example.Vehicle_Renting_Application.DTO.VehicleResponse;
import com.example.Vehicle_Renting_Application.entity.Image;
import com.example.Vehicle_Renting_Application.entity.Vehicle;
import com.example.Vehicle_Renting_Application.Mapper.VehicleMapper;
import com.example.Vehicle_Renting_Application.Repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

	private final VehicleRepository vehicleRepository;
	private final VehicleMapper vehicleMapper;
	private final ImageService imageService;

	public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper, ImageService imageService) {
		super();
		this.vehicleRepository = vehicleRepository;
		this.vehicleMapper = vehicleMapper;
		this.imageService = imageService;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	public VehicleResponse register(VehicleRequest request) {
		Vehicle vehicle = new Vehicle();
		vehicle.setBrand(request.getBrand());
		vehicle.setModel(request.getModel());
		vehicle.setVehicleType(request.getVehicleType());
		vehicle.setFuleType(request.getFuelType());
		Vehicle savedVehicle = vehicleRepository.save(vehicle);
		return vehicleMapper.mapToResponse(savedVehicle);
	}

	public List<VehicleResponse> findAllVehicles() {

		List<Vehicle> vehicles = vehicleRepository.findAll();
		List<VehicleResponse> vehicleResponses = new ArrayList();

		if (vehicles.isEmpty()) {
			throw new VehicleNotFoundException("No Vehicles present");
		}
		for (Vehicle vehicle : vehicles) {
			VehicleResponse response = vehicleMapper.mapToResponse(vehicle);
			vehicleResponses.add(response);
		}

		return vehicleResponses;
	}


	@PreAuthorize("hasAuthority('ADMIN')")
	public VehicleResponse updateVehicleById(int vehicleId, VehicleRequest request) {

		Vehicle existingVehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));
		existingVehicle.setBrand(request.getBrand());
		existingVehicle.setModel(request.getModel());
		existingVehicle.setFuleType(request.getFuelType());

		Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);

		return vehicleMapper.mapToResponse(updatedVehicle);
	}
}
