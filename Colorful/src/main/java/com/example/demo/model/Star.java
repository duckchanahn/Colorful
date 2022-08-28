package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="star")
public class Star {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int starId;
	int customerId;
	int tourSpotId;
	
	public Star() {
		super();
		
		this.starId = 0;
		this.customerId = 0;
		this.tourSpotId = 0;
	}
	
	public Star(int starId, int customerId, int tourSpotId) {
		super();
		
		this.starId = starId;
		this.customerId =  customerId;
		this.tourSpotId = tourSpotId;
	}

	public int getStarId() {
		return starId;
	}

	public void setStarId(int starId) {
		this.starId = starId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getTourSpotId() {
		return tourSpotId;
	}

	public void setTourSpotId(int tourSpotId) {
		this.tourSpotId = tourSpotId;
	}
	
		
}
