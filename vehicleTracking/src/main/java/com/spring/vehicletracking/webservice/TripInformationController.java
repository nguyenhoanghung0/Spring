package com.spring.vehicletracking.webservice;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vehicletracking.dao.TripRepository;
import com.spring.vehicletracking.model.Trip;

@RestController
@RequestMapping("/tripinformation")
public class TripInformationController {
	
	private static final Logger logger = LoggerFactory.getLogger(TripInformationController.class);
	
	@Autowired
	TripRepository tripRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Trip> tripInformation(@RequestParam(value="vehicleId", defaultValue="none") String vehicleId) {
		
		logger.debug(vehicleId);
		List<Trip> trips = new ArrayList<>();
		if (vehicleId.equals("none")) {
			tripRepository.findAll().forEach(trips::add);
			return trips;
		} else {
			return tripRepository.findByVehicleId(Integer.parseInt(vehicleId));
		}
    }
}