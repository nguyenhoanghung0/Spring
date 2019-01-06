package com.spring.vehicletracking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.spring.vehicletracking.dao.TripErrorRepository;
import com.spring.vehicletracking.dao.TripRepository;
import com.spring.vehicletracking.model.Trip;
import com.spring.vehicletracking.model.TripError;
import com.spring.vehicletracking.util.CommonConstant;

@Service
public class TripServiceImpl {
	
	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private TripErrorRepository tripErrorRepository;
	
	public List<Trip> findByVehicleId(int vehicleId, int page) {
		List<Trip> tripList;
		tripList = tripRepository.findByVehicleId(
				PageRequest.of(page, CommonConstant.PAGE_SIZE), vehicleId);
		
		return tripList;
	}
	
	public List<Trip> findAll(int page) {
		List<Trip> tripList = new ArrayList<>();
		tripRepository.findAll(PageRequest.of(page, CommonConstant.PAGE_SIZE)).forEach(tripList::add);
		
		return tripList;
	}
	
	public Trip save(Trip newTrip) {
		return tripRepository.save(newTrip);
	}
	
	public Trip replaceTrip(long id, Trip newTrip) {
		return tripRepository.findById(id)
				.map(trip -> {
					trip.setVehicleId(newTrip.getVehicleId());
					trip.setDuration(newTrip.getDuration());
					return tripRepository.save(newTrip);
		})
		.orElseGet(() -> {
			newTrip.setId(id);
			return tripRepository.save(newTrip);
		});		
	}
	
	public void deleteById(Long id ) {
		tripRepository.deleteById(id);
	}
	
	public List<TripError> findAllErrorTrip(int page) {
		List<TripError> tripErrors = new ArrayList<>();
		tripErrorRepository.findAll(PageRequest.of(page, CommonConstant.PAGE_SIZE)).forEach(tripErrors::add);
		
		return tripErrors;
	}
}
