package com.spring.vehicletracking.scheduler;

import com.spring.vehicletracking.services.ReaderServiceImpl;

/**
 * Read data from queue and store in to database
 *
 */
public class ReaderTask implements Runnable {
	
	private final ReaderServiceImpl readerService = new ReaderServiceImpl();
	
	public void run() {
		System.out.println("Reading event...");
		readerService.processEventInQueue();
	}
}

