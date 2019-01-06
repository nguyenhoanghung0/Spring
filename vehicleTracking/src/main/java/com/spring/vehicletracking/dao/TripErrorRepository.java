package com.spring.vehicletracking.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.vehicletracking.model.TripError;

@Repository
public interface TripErrorRepository extends PagingAndSortingRepository<TripError, Long> {

    List<TripError> findByVehicleId(Pageable pageable, int vehicleId);
    
}