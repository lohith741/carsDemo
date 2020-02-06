package com.example.carsDemo.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "cars")
@EntityListeners(AuditingEntityListener.class)
public class CarDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String carName;

    @NotBlank
    private String manufactureName;
    
    @NotBlank
    private String model;
    
    @NotNull
    private Integer year;
    
    @NotBlank
    private String color;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getCarName() {
		return carName;
	}

	public String getManufactureName() {
		return manufactureName;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public String getColor() {
		return color;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setColor(String color) {
		this.color = color;
	}

  
}
