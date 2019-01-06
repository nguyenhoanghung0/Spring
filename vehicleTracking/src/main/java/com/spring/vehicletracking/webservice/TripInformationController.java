package com.spring.vehicletracking.webservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vehicletracking.model.Trip;
import com.spring.vehicletracking.model.TripError;
import com.spring.vehicletracking.services.TripServiceImpl;

@RestController
public class TripInformationController {
	
	private static final Logger logger = LoggerFactory.getLogger(TripInformationController.class);
	
	@Autowired
	TripServiceImpl tripService;
	
	@GetMapping("/tripinformation")
	public List<Trip> getAllTripInformation(@RequestParam(value="page", defaultValue="0") Integer page) {
		
		return tripService.findAll(page);		
    }
	
	@GetMapping("/tripinformation/{vehicleId}")
	public List<Trip> getTripByVehicleId(@PathVariable Integer vehicleId,
			@RequestParam(value="page", defaultValue="0") Integer page) {
		
		return tripService.findByVehicleId(vehicleId, page);
	}
	
	@PostMapping("/tripinformation/create")
	Trip newTrip(@RequestBody Trip newTrip) {
		return tripService.save(newTrip);
	}
	
	@PutMapping("/tripinformation/{id}")
	Trip replaceTrip(@RequestBody Trip newTrip, @PathVariable Long id) {

		return tripService.replaceTrip(id, newTrip);			
	}

	@DeleteMapping("/tripinformation/{id}")
	void deleteTrip(@PathVariable Long id) {
		tripService.deleteById(id);
	}
	
	@GetMapping("/triperrors")
	public List<TripError> getAllTripError(@RequestParam(value="page", defaultValue="0") Integer page) {
		
		return tripService.findAllErrorTrip(page);		
    }
}
