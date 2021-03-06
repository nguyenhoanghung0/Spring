package com.spring.vehicletracking.services;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.vehicletracking.dao.TripErrorRepository;
import com.spring.vehicletracking.dao.TripRepository;
import com.spring.vehicletracking.dao.TripStatusRepository;
import com.spring.vehicletracking.model.Event;
import com.spring.vehicletracking.model.Event.Action;
import com.spring.vehicletracking.model.Trip;
import com.spring.vehicletracking.model.TripError;
import com.spring.vehicletracking.model.TripStatus;
import com.spring.vehicletracking.util.BeanUtil;

public class ReaderServiceImpl implements ReaderService {
	
	private static final Logger logger = LoggerFactory.getLogger(ReaderServiceImpl.class);
	
	private TripRepository tripRepository = BeanUtil.getBean(TripRepository.class);
	
	private TripStatusRepository tripStatusRepository = 
			BeanUtil.getBean(TripStatusRepository.class);
	
	private TripErrorRepository tripErrorRepository = 
			BeanUtil.getBean(TripErrorRepository.class);
	
	private static List<Event> eventList;	
	
	@Override
	public void processEventInQueue() {
		
		// Get events from queue
		eventList = getEventsFromQueue();
		logger.debug("No. of events: " + eventList.size());
		
		// TODO: Save all the events to DB for tracking purpose
		
		// Update Trip Information		
		Trip trip;
		TripStatus tripStatus;
		for (Event event : eventList) {
			try {
				if (event.getAction() == Action.NONE) {
					// do nothing
					continue;
					
				} else if (event.getAction() == Action.START) {
					// Start a new trip
					logger.info("Vehicle with Id - " + event.getVehicleId() + " starting new trip");
					
					tripStatus = tripStatusRepository.findByVehicleId(event.getVehicleId());
					if (tripStatus != null) {
						// Start a new trip when last trip not finished yet -> something goes wrong
						insertTripErrorToDatabase(0L, event.getVehicleId(), 
								tripStatus.getStartTime(), null);
					}
					tripStatus = new TripStatus(event.getVehicleId(), Action.START.toString(),
							Instant.now());
					
					tripStatusRepository.save(tripStatus);
					
				} else {
					// Event STOP - Finish the trip
					logger.info("Vehicle with Id - " + event.getVehicleId() + " finishing one trip");
					
					tripStatus = tripStatusRepository.findByVehicleId(event.getVehicleId());
					
					// Update TripRepository
					if (tripStatus == null) {
						// Could not find trip status 
						trip = new Trip(event.getVehicleId(), Duration.ZERO);
						tripRepository.save(trip);
						
						// Insert the exception record to db						
						insertTripErrorToDatabase(trip.getId(), event.getVehicleId(), 
								null, Instant.now());
						
					} else {
						trip = new Trip(event.getVehicleId(),
								Duration.between(tripStatus.getStartTime(), Instant.now()));
						// Delete from TripStatusRepository
						tripStatusRepository.delete(tripStatus);
						tripRepository.save(trip);
					}
				}
			} catch (Exception ex) {
				logger.error("Exception while processiong event: " + event.toString());
				/*
				 * - Save error event to db for further investigation
				 * - Check with resource to recover the data
				 */
				insertTripErrorToDatabase(0L, event.getVehicleId(), null, null);
			}
		}		
	}
	
	private void insertTripErrorToDatabase(long tripId, int vehicleId, 
			Instant startTime, Instant endTime) {
		TripError tripError = new TripError(tripId, vehicleId, startTime, endTime);
		tripErrorRepository.save(tripError);
	}
	
	@Override
	public List<Event> getEventsFromQueue() {
		return EventQueue.getEvents();
	}
}
