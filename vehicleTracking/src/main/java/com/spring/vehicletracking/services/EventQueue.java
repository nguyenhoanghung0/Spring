package com.spring.vehicletracking.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.spring.vehicletracking.model.Event;

public class EventQueue {
	
	private static final Queue<Event> eventQueue = new LinkedList<>();
	
	private EventQueue(){}
	
	public static void addEvents(List<Event> list) {
		eventQueue.addAll(list);
	}
	
	public static List<Event> getEvents() {
		
		List<Event> eventList = new ArrayList<>();
		while (!eventQueue.isEmpty()) {
			eventList.add(eventQueue.remove());
		}
		
		return eventList;
	}
}
