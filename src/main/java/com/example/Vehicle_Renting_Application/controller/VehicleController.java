
package com.example.Vehicle_Renting_Application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicle_Renting_Application.DTO.VehicleRequest;
import com.example.Vehicle_Renting_Application.DTO.VehicleResponse;
import com.example.Vehicle_Renting_Application.enums.VehicleType;
import com.example.Vehicle_Renting_Application.service.VehicleService;
import com.example.Vehicle_Renting_Application.util.ResponseStructure;

import java.util.List;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

   

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<VehicleResponse>> registerMUV(@RequestBody VehicleRequest request) {
        VehicleResponse response = vehicleService.register(request, VehicleType.MUV);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseStructure.create(HttpStatus.CREATED.value(), "MUV Vehicle Created", response));
    }

   
    @GetMapping("/vehicles")
    public ResponseEntity<ResponseStructure<List<VehicleResponse>>> findAllVehicles() {
        List<VehicleResponse> vehicleResponses = vehicleService.findAllVehicles();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseStructure.create(HttpStatus.OK.value(), "All Vehicles Found", vehicleResponses));
    }

    @PutMapping("/update/vehicle")
    public ResponseEntity<ResponseStructure<VehicleResponse>> updateVehicle(@RequestParam("vehicleId") int vehicleId,
            @RequestBody VehicleRequest request) {
        VehicleResponse response = vehicleService.updateVehicleById(vehicleId, request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseStructure.create(HttpStatus.OK.value(), "Vehicle Updated Successfully", response));
    }
}
