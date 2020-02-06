package com.example.carsDemo.repository;

import java.util.List;

import com.example.carsDemo.model.CarDetails;
import com.example.carsDemo.model.CarDetailsRequest;

public interface GetCarDetails {
	/**
	 * 
	 * @param request
	 * @return
	 */
	public List<CarDetails> getCarDetailsList (CarDetailsRequest request);

}
