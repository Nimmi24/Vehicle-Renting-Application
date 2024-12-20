package com.example.Vehicle_Renting_Application.DTO;

import com.example.Vehicle_Renting_Application.enums.Seating;

public class VehicleListingRequest {
	private int vehicleId;
	private String vehicleNo;
	private double pricePerDay;
	private Seating seating;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	public Seating getSeating() {
		return seating;
	}
	public void setSeating(Seating seating) {
		this.seating = seating;
	}
	
	

}