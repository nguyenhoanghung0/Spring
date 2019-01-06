package com.spring.vehicletracking.scheduler;

import com.spring.vehicletracking.services.ReaderService;
import com.spring.vehicletracking.services.ReaderServiceImpl;

/**
 * Read data from queue and store in to database
 *
 */
public class ReaderTask implements Runnable {
	
	private final ReaderService readerService = new ReaderServiceImpl();
	
	public void run() {
		System.out.println("Reading event...");
		readerService.processEventInQueue();
	}
}

