package com.spring.vehicletracking.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.vehicletracking.model.Event;
import com.spring.vehicletracking.model.Event.Action;
import com.spring.vehicletracking.util.FileUtil;

@Service
public class FileSystemStorageService implements StorageService {

	private static Queue<String> eventQueue = new LinkedList<>();
	private static final int NUMBER_OF_VEHICLES = 4; // TODO: configurable  
	
    @Override
    public String uploadEventSource(MultipartFile file) {
    	
    	List<String> eventList = FileUtil.load(file);
    	
    	if (eventList.size() > 0) {
	    	// Adding all the events in uploaded file to the eventList
    		eventQueue.addAll(eventList);
    	}
    	
    	return "";
    }
    
    public static List<Event> getEventsForOneCycle() {
    	List<Event> cycleEvents = new ArrayList<>();
    	String line;
    	
    	for (int i = 1; i <= NUMBER_OF_VEHICLES; i++) {
    		try {
    			line = eventQueue.remove();
    			cycleEvents.add(convertToEventObject(line));
    			
    		} catch (NoSuchElementException noElementEx) {
    			// TODO: handle exception
    			break;
    		} catch (Exception ex) {
    			// TODO: handle exception
    		}
    		
    	}
    	
    	return cycleEvents;
    }
    
    private static Event convertToEventObject(String line) throws Exception {
    	
    	String [] array= line.split(",");
    	Event event;
    	if (array.length == 2) {
    		event = new Event(Integer.parseInt(array[0]), Action.valueOf(array[1]));
    	} else {
    		throw new Exception("Event: incorrect format");
    	}
    	
    	return event;
    }
}
