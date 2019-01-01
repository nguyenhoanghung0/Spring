package com.spring.vehicletracking.webservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vehicletracking.model.Trip;
import com.spring.vehicletracking.services.TripServiceImpl;

@RestController
@RequestMapping("/tripinformation")
public class TripInformationController {
	
	private static final Logger logger = LoggerFactory.getLogger(TripInformationController.class);
	
	@Autowired
	TripServiceImpl tripService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Trip> tripInformation(@RequestParam(value="vehicleId", defaultValue="none") String vehicleId, 
			@RequestParam(value="page", defaultValue="0") Integer page) {
		
		logger.debug("vehicleId: " + vehicleId);
		
		if (vehicleId.equals("none")) {
			return tripService.findAll(page);
		} else {
			return tripService.findByVehicleId(Integer.parseInt(vehicleId), page);
		}
    }
}
