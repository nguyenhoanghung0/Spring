package com.spring.vehicletracking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.spring.vehicletracking.dao.TripRepository;
import com.spring.vehicletracking.model.Trip;
import com.spring.vehicletracking.util.CommonConstant;

@Service
public class TripServiceImpl {
	
	@Autowired
	private TripRepository tripRepository;
	
	public List<Trip> findByVehicleId(int vehicleId, int page) {
		List<Trip> tripList;
		tripList = tripRepository.findByVehicleId(PageRequest.of(page, CommonConstant.PAGE_SIZE), vehicleId);
		
		return tripList;
	}
	
	public List<Trip> findAll(int page) {
		List<Trip> tripList = new ArrayList<>();
		tripRepository.findAll(PageRequest.of(page, CommonConstant.PAGE_SIZE)).forEach(tripList::add);
		
		return tripList;
	}
}
