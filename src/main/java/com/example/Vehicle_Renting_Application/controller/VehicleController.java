package com.example.Vehicle_Renting_Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Vehicle_Renting_Application.DTO.VehicleRequest;
import com.example.Vehicle_Renting_Application.DTO.VehicleResponse;
import com.example.Vehicle_Renting_Application.service.ImageService;
import com.example.Vehicle_Renting_Application.service.VehicleService;
import com.example.Vehicle_Renting_Application.util.ResponseStructure;

import java.util.List;

@RestController
public class VehicleController {

	private final VehicleService vehicleService;

	private final ImageService imageService;

	public VehicleController(VehicleService vehicleService, ImageService imageService) {
		super();
		this.vehicleService = vehicleService;
		this.imageService = imageService;
	}

	@PostMapping("/register-vehicle")
	public ResponseEntity<ResponseStructure<VehicleResponse>> registerVehicle(@RequestBody VehicleRequest request) {
		VehicleResponse response = vehicleService.register(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				ResponseStructure.create(HttpStatus.CREATED.value(), "Vehicle Registered Successfully", response));
	}

	@GetMapping("/find-all-vehicles")
	public ResponseEntity<ResponseStructure<List<VehicleResponse>>> findAllVehicles() {
		List<VehicleResponse> vehicleResponses = vehicleService.findAllVehicles();
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "All Vehicles Found", vehicleResponses));
	}

	@PutMapping("/update/vehicle-info")
	public ResponseEntity<ResponseStructure<VehicleResponse>> updateVehicle(@RequestParam("vehicleId") int vehicleId,
			@RequestBody VehicleRequest request) {
		VehicleResponse response = vehicleService.updateVehicleById(vehicleId, request);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "Vehicle Updated Successfully", response));
	}

}
