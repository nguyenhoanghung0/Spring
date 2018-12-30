package com.spring.vehicletracking.services;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import com.spring.vehicletracking.dao.TripRepository;
import com.spring.vehicletracking.dao.TripStatusRepository;
import com.spring.vehicletracking.model.Event;
import com.spring.vehicletracking.model.Event.Action;
import com.spring.vehicletracking.model.Trip;
import com.spring.vehicletracking.model.TripStatus;
import com.spring.vehicletracking.util.BeanUtil;

public class ReaderService {
	
	private static TripRepository tripRepository = BeanUtil.getBean(TripRepository.class);
	private static TripStatusRepository tripStatusRepository = 
			BeanUtil.getBean(TripStatusRepository.class);
	
	private static List<Event> eventList;	
	
	public static void processEventInQueue() {
		
		// Get events from queue
		eventList = EventQueue.getEvents();
		
		// TODO Save all the events to DB for tracking purpose
		
		// Update Trip Information		
		Trip trip;
		TripStatus tripStatus;
		for (Event event : eventList) {
			if (event.getAction() == Action.NONE) {
				// do nothing
				continue;
				
			} else if (event.getAction() == Action.START) {
				// Start a new trip
				tripStatus = tripStatusRepository.findByVehicleId(event.getVehicleId());
				if (tripStatus != null) {
					// TODO: something goes wrong, handle exception					
				}
				tripStatus = new TripStatus(event.getVehicleId(), Action.START.toString(),
						Instant.now());
				
				tripStatusRepository.save(tripStatus);
				
			} else {
				// Event STOP - Finish the trip
				tripStatus = tripStatusRepository.findByVehicleId(event.getVehicleId());
				
				// Update TripRepository
				if (tripStatus == null) {
					// TODO: something goes wrong, handle exception
					trip = new Trip(event.getVehicleId(), Duration.ZERO);
				} else {
					trip = new Trip(event.getVehicleId(),
							Duration.between(tripStatus.getStartTime(), Instant.now()));
					// Delete from TripStatusRepository
					tripStatusRepository.delete(tripStatus);
				}								
				
				tripRepository.save(trip);
			}
		}		
	}

}
