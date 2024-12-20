package com.example.Vehicle_Renting_Application.service;

import org.springframework.stereotype.Service;

import com.example.Vehicle_Renting_Application.entity.User;
import com.example.Vehicle_Renting_Application.entity.Vehicle;
import com.example.Vehicle_Renting_Application.entity.VehicleListing;
import com.example.Vehicle_Renting_Application.exception.NoVehicleListingException;
import com.example.Vehicle_Renting_Application.exception.VehicleNotFoundException;
import com.example.Vehicle_Renting_Application.Mapper.VehicleListingMapper;
import com.example.Vehicle_Renting_Application.Repository.VehicleListingRepository;
import com.example.Vehicle_Renting_Application.Repository.VehicleRepository;
import com.example.Vehicle_Renting_Application.DTO.VehicleListingRequest;
import com.example.Vehicle_Renting_Application.DTO.VehicleListingResponse;
import com.example.Vehicle_Renting_Application.security.OAuthUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleListingService {

	private final VehicleListingRepository vehicleListingRepository;
	private final VehicleRepository vehicleRepository;
	private final VehicleListingMapper vehicleListingMapper;
	private final OAuthUtil authUtil;

	public VehicleListingService(VehicleListingRepository vehicleListingRepository, VehicleRepository vehicleRepository,
			VehicleListingMapper vehicleListingMapper, OAuthUtil authUtil) {
		super();
		this.vehicleListingRepository = vehicleListingRepository;
		this.vehicleRepository = vehicleRepository;
		this.vehicleListingMapper = vehicleListingMapper;
		this.authUtil = authUtil;
	}

	public VehicleListingResponse createVehicleListing(VehicleListingRequest request, int vehicleId) {

		User user = authUtil.getCurrentUser();

		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + request.getVehicleId()));

		VehicleListing vehicleListing = new VehicleListing();
		vehicleListing.setVehicle(vehicle);
		vehicleListing.setVehicleNo(request.getVehicleNo());
		vehicleListing.setPricePerDay(request.getPricePerDay());
		vehicleListing.setSeating(request.getSeating());
		vehicleListing.setRenting_partner(user);

		VehicleListing savedVehicleListing = vehicleListingRepository.save(vehicleListing);

		return vehicleListingMapper.mapToResponse(savedVehicleListing);
	}

	public List<VehicleListingResponse> getVehicleListingsByVehicleId(int vehicleId) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with ID: " + vehicleId));
		List<VehicleListing> listings = vehicleListingRepository.findByVehicle(vehicle);

		if (listings.isEmpty()) {
			throw new NoVehicleListingException("No listings found for Vehicle ID: " + vehicleId);
		}

		List<VehicleListingResponse> responses = new ArrayList<>();
		for (VehicleListing listing : listings) {
			responses.add(vehicleListingMapper.mapToResponse(listing));
		}

		return responses;
	}

}
