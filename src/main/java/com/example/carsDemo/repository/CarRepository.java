package com.example.carsDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.carsDemo.model.CarDetails;

@Repository
public interface CarRepository extends JpaRepository<CarDetails, Long>{

	@Query(value = "SELECT * FROM cars WHERE car_name = ?1", nativeQuery = true)
	List<CarDetails> findByName(String car_name);
	
	
	@Query(value = "SELECT * FROM cars WHERE color = ?1 AND car_name = ?2", nativeQuery = true)
	List<CarDetails> findBycolor(String color , String name);
	
	
}
