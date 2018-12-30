package com.spring.vehicletracking.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TripStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer vehicleId;
	private String status;
	private Instant startTime;
	
	protected TripStatus() {}
	
	public TripStatus(int vehicleId, String status, Instant startTime) {
		this.vehicleId = vehicleId;
		this.status = status;
		this.startTime = startTime;
	}	
	
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Instant getStartTime() {
		return startTime;
	}
	public void setStartTime(Instant startingTime) {
		this.startTime = startingTime;
	}
	
}
