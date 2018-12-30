package com.spring.vehicletracking.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.vehicletracking.model.TripStatus;

public interface TripStatusRepository extends CrudRepository<TripStatus, Long> {
	
	TripStatus findByVehicleId(int vehicleId);
}