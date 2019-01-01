package com.spring.vehicletracking.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.vehicletracking.model.Trip;

public interface TripRepository extends PagingAndSortingRepository<Trip, Long> {

    List<Trip> findByVehicleId(Pageable pageable, int vehicleId);
    
}
