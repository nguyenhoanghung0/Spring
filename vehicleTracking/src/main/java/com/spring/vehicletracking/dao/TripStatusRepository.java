package com.spring.vehicletracking.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.vehicletracking.model.TripStatus;

@Repository
public interface TripStatusRepository extends PagingAndSortingRepository<TripStatus, Long> {
	
	TripStatus findByVehicleId(Integer vehicleId);
}