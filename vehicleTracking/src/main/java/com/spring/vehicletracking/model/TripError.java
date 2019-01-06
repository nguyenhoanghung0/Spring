package com.spring.vehicletracking.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TripError {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private long tripId;
	private int vehicleId;
	private Instant startTime;
	private Instant endTime;
	
	protected TripError() {}

    public TripError(long tripId, int vehicleId, Instant startTime, Instant endTime) {
        this.tripId = tripId;
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public long getTripId() {
		return tripId;
	}

	public void setTripId(long tripId) {
		this.tripId = tripId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Instant getStartTime() {
		return startTime;
	}

	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}

	public Instant getEndTime() {
		return endTime;
	}

	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}

	@Override
    public String toString() {
        return String.format(
                "TripError[id=%d, tripId='%d',vehicleId='%d', startTime='%s', endTime='%s']",
                id, tripId, vehicleId, 
                startTime == null ? "" : startTime.toString(), 
                endTime == null ? "" : endTime.toString());
    }
}
