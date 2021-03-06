package com.spring.vehicletracking.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.vehicletracking.model.Trip;

@Repository
public interface TripRepository extends PagingAndSortingRepository<Trip, Long> {

    List<Trip> findByVehicleId(Pageable pageable, int vehicleId);
    
}
