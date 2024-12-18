 
package com.example.Vehicle_Renting_Application.DTO;

import com.example.Vehicle_Renting_Application.enums.FuelType;
import com.example.Vehicle_Renting_Application.enums.VehicleType;

public class VehicleRequest {

	private String brand;
	private String model;
	private VehicleType vehicleType;
	private FuelType fuelType;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
}
