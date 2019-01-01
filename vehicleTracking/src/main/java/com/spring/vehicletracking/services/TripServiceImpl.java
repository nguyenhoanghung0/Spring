package com.spring.vehicletracking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.spring.vehicletracking.dao.TripRepository;
import com.spring.vehicletracking.model.Trip;

@Service
public class TripServiceImpl {
	
	@Autowired
	private TripRepository tripRepository;
	
	private static final int pageSize = 3;
	
	public List<Trip> findByVehicleId(int vehicleId, int page) {
		List<Trip> tripList;
		tripList = tripRepository.findByVehicleId(PageRequest.of(page, pageSize), vehicleId);
		
		return tripList;
	}
	
	public List<Trip> findAll(int page) {
		List<Trip> tripList = new ArrayList<>();
		tripRepository.findAll(PageRequest.of(page, pageSize)).forEach(tripList::add);
		
		return tripList;
		
	}
}
