package com.spring.vehicletracking.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.vehicletracking.model.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {

    List<Trip> findByVehicleId(int vehicleId);
    
}
