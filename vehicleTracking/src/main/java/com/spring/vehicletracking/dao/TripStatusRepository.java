package com.spring.vehicletracking.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.vehicletracking.model.TripStatus;

public interface TripStatusRepository extends PagingAndSortingRepository<TripStatus, Long> {
	
	TripStatus findByVehicleId(Integer vehicleId);
}