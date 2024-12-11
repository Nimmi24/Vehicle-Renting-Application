package com.example.Vehicle_Renting_Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Image {
	
	@Id
	private int imageId;
	private String contentType;
	private byte[] imageByte;
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public byte[] getImageByte() {
		return imageByte;
	}
	public void setImageByte(byte[] imageByte) {
		this.imageByte = imageByte;
	}
	
	

}
