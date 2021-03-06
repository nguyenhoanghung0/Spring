package com.spring.vehicletracking.scheduler;

import com.spring.vehicletracking.services.EventQueue;
import com.spring.vehicletracking.services.FileSystemStorageServiceImpl;

/**
 * Read data from the event source file
 * Each time it will read the events from 4 vehicles
 * @author Nguyen Hung
 *
 */
public class WriterTask implements Runnable {

	private final FileSystemStorageServiceImpl fileSystemStorageService = 
			new FileSystemStorageServiceImpl();
	
	public void run() {
		System.out.println("Adding event...");
		EventQueue.addEvents(fileSystemStorageService.getEventsForOneCycle());
	}
}
