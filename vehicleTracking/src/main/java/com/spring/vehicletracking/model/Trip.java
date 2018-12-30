package com.spring.vehicletracking.model;

import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer vehicleId;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripNo;
	private Duration duration;
	
	protected Trip() {}

    public Trip(int vehicleId, Duration duration) {
        this.vehicleId = vehicleId;
        this.duration = duration;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getTripNo() {
		return tripNo;
	}

	public void setTripNo(Integer tripNo) {
		this.tripNo = tripNo;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@Override
    public String toString() {
        return String.format(
                "Trip[id=%d, vehicleId='%s', tripNo='%s']",
                id, vehicleId, tripNo, duration.getSeconds());
    }

}
