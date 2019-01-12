package com.spring.vehicletracking.services;

import java.util.List;

import com.spring.vehicletracking.model.Event;

public interface ReaderService {
	
	public void processEventsInQueue();
	
	public List<Event> getEventsFromQueue();
}
