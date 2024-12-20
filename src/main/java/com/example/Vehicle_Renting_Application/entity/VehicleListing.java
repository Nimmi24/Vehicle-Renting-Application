package com.example.Vehicle_Renting_Application.entity;

import com.example.Vehicle_Renting_Application.enums.Seating;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class VehicleListing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int listingId;
	
	private String vehicleNo;
	
	private double pricePerDay;
	
	private Seating seating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User renting_partner;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vehicle vehicle;

	public int getListingId() {
		return listingId;
	}

	public void setListingId(int listingId) {
		this.listingId = listingId;
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

	public User getRenting_partner() {
		return renting_partner;
	}

	public void setRenting_partner(User renting_partner) {
		this.renting_partner = renting_partner;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
