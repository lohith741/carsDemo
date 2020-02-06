package com.example.carsDemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import com.example.carsDemo.model.CarDetails;
import com.example.carsDemo.model.CarDetailsRequest;

@Service
public class GetCarDetailsServiceImpl implements GetCarDetails{

	@PersistenceContext
	EntityManager entitymanager;
	
	@Override
	public List<CarDetails> getCarDetailsList(CarDetailsRequest request) {
		
		String queryString = "SELECT * FROM cars WHERE";
		boolean addAnd = false;
		
		if(request.getColor() != null){
			queryString+= " color = '" + request.getColor() +"'";
			addAnd = true;
		}
		if(request.getName() != null){
			queryString += addAnd ? " and" : "";
			queryString +=  " car_name = '"+ request.getName() +"'" ;
			addAnd = true;
		}
		if(request.getManufactureName() != null){
			queryString += addAnd ? " and" : "";
			queryString +=  " manufacture_name = '"+ request.getManufactureName() +"'" ;
			addAnd = true;
		}
		if(request.getModel() != null){
			queryString += addAnd ? " and" : "";
			queryString +=  " model = '"+ request.getModel() +"'" ;
			addAnd = true;
		}
		if(request.getYear() != null){
			queryString += addAnd ? " and" : "";
			queryString+= " year = "+ request.getYear()  ;
			addAnd = true;
		}
		Query query =  entitymanager.createNativeQuery(queryString);

		List<CarDetails> carDetailsList =  query.getResultList();
		  return carDetailsList;
 
	}

	


}
