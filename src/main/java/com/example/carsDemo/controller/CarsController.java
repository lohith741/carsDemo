package com.example.carsDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.carsDemo.exception.ResourceNotFoundException;
import com.example.carsDemo.model.CarDetails;
import com.example.carsDemo.model.CarDetailsRequest;
import com.example.carsDemo.repository.CarRepository;
import com.example.carsDemo.repository.GetCarDetails;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/api")
public class CarsController {
    @Autowired
    CarRepository carRepository;
    
    @Autowired
    GetCarDetails getCarDetails;
    
    @GetMapping("/car")
    public List<CarDetails> getAllCars() {
        return carRepository.findAll();
    }

    @PostMapping(path = "/car" ,consumes = "application/json")
    public ResponseEntity<?> createCar(@Valid @RequestBody CarDetails car) {
        carRepository.save(car);
        JSONObject response = new JSONObject();
        response.put("message: ", "Successfully Inserted!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/car/{id}")
    public CarDetails getCarById(@PathVariable(value = "id") Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));
    }
    
    @GetMapping(path = "/car/getName" , consumes = "text/plain")
    public List<CarDetails> getCarByName(@RequestBody String carName) {
        return carRepository.findByName(carName);
    }
    
    @GetMapping(path = "/car/getcolor")
    public List<CarDetails> getCarBycolor(@RequestParam(required = false,value = "color") String color,@RequestParam(required =  false,value = "name") String name) { 
    	return carRepository.findBycolor(color,name);
    }
    
    @GetMapping(path = "/car/getCars", consumes = "application/json")
    public List<CarDetails> getCars(@RequestBody CarDetailsRequest request) {
    	return  getCarDetails.getCarDetailsList(request);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<?> updateCar(@PathVariable(value = "id") Long carId,
                                           @Valid @RequestBody CarDetails updateDetails) {

    	CarDetails carDetails = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));

    	carDetails.setCarName(updateDetails.getCarName());
        carDetails.setManufactureName(updateDetails.getManufactureName());
        carDetails.setModel(updateDetails.getModel());
        carDetails.setYear(updateDetails.getYear());
        carDetails.setColor(updateDetails.getColor());
        
        carRepository.save(carDetails);
        JSONObject response = new JSONObject();
        response.put("message: ", "Successfully updated car details!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @ResponseBody
    @DeleteMapping("/car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long carId){
    	CarDetails carDetails = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));

        carRepository.delete(carDetails);
        JSONObject response = new JSONObject();
        response.put("message: ", "Deleted Sucessfully!");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
