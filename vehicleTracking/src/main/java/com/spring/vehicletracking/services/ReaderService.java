package com.spring.vehicletracking.services;

import java.util.List;

import com.spring.vehicletracking.model.Event;

public interface ReaderService {
	
	public void processEventInQueue();
	
	public List<Event> getEventsFromQueue();
}
