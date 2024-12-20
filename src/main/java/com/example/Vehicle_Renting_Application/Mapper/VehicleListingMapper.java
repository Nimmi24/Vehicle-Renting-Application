package com.example.Vehicle_Renting_Application.Mapper;

import org.springframework.stereotype.Component;

import com.example.Vehicle_Renting_Application.DTO.VehicleListingResponse;
import com.example.Vehicle_Renting_Application.entity.VehicleListing;

@Component
public class VehicleListingMapper {
	
	public VehicleListingResponse mapToResponse(VehicleListing listing) {
		VehicleListingResponse response = new VehicleListingResponse();
		response.setListingId(listing.getListingId());
		response.setVehicleNo(listing.getVehicleNo());
		response.setPricePerDay(listing.getPricePerDay());
		response.setSeating(listing.getSeating());
		return response;
		
	}

}
