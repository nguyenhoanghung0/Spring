package com.spring.vehicletracking.scheduler;

import com.spring.vehicletracking.services.ReaderService;

/**
 * Read data from queue and store in to database
 *
 */
public class ReaderTask implements Runnable {
	
	private final ReaderService readerService = new ReaderService();
	
	public void run() {
		System.out.println("Reading event...");
		readerService.processEventInQueue();
	}
}

