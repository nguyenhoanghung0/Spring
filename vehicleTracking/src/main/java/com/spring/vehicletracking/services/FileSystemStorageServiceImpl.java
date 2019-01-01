package com.spring.vehicletracking.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.vehicletracking.model.Event;
import com.spring.vehicletracking.model.Event.Action;
import com.spring.vehicletracking.util.CommonConstant;
import com.spring.vehicletracking.util.FileUtil;

@Service
public class FileSystemStorageServiceImpl implements StorageService {

	private static final Logger logger = LoggerFactory.getLogger(FileSystemStorageServiceImpl.class);
	
	private static Queue<String> eventQueue = new LinkedList<>();
	
    @Override
    public List<String> uploadEventSource(MultipartFile file) {
    	
    	List<String> eventList = FileUtil.load(file);
    	logger.debug("Number of event to be adding: " + eventList.size());
    	if (eventList.size() > 0) {
    		// Validation
    		List<String> errorList = validateInputFile(eventList);
    		if (errorList.size() > 0) return errorList;
    		
	    	// Adding all the events in uploaded file to the eventList
    		eventQueue.addAll(eventList);
    	}
    	
    	return null;
    }
    
    public List<Event> getEventsForOneCycle() {
    	List<Event> cycleEvents = new ArrayList<>();
    	String line;
    	
    	for (int i = 1; i <= CommonConstant.NUMBER_OF_VEHICLES; i++) {
    		try {
    			line = eventQueue.remove();
    			cycleEvents.add(convertToEventObject(line));
    			
    		} catch (NoSuchElementException noElementEx) {
    			// No more event in the queue
    			break;
    		} catch (Exception ex) {
    			// Something's wrong with the event, skip it
    			// TODO: handle exception cases
    		}
    	}
    	
    	return cycleEvents;
    }
    
    private Event convertToEventObject(String line) throws Exception {
    	
    	String [] array= line.split(",");
    	Event event;
    	if (array.length == 2) {
    		event = new Event(Integer.parseInt(array[0]), Action.valueOf(array[1]));
    	} else {
    		throw new Exception("Event: incorrect format");
    	}
    	
    	return event;
    }
    
    private List<String> validateInputFile(List<String> eventList) {
    	List<String> errorList = new ArrayList<>();
    	String line;
    	String [] lineArray;
    	
    	for (int i = 0; i < eventList.size(); i++) {
    		line = eventList.get(i);
    		if (line == null || line.isEmpty() ) {
    			errorList.add("Line " + i + " is null or empty.");
    		} else {
    			lineArray = line.split(",");
    			if (lineArray.length != 2) {
    				errorList.add("Line " + i + " has wrong format - " + line);
    			}
    		}
    	}
    	
    	return errorList;
    }
}
