package com.example.carsDemo.model;

public class CarDetailsRequest {

	private String name;
	private String color;
	private String manufactureName;
	private String model;
	private Integer year;
	
	public String getManufactureName() {
		return manufactureName;
	}
	public String getModel() {
		return model;
	}
	public Integer getYear() {
		return year;
	}
	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
