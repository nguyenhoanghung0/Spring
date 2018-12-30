package com.spring.vehicletracking.services;

/**
 * Read data from queue and store in to database
 *
 */
public class ReaderTask implements Runnable {
	
	public void run() {
		System.out.println("Reading event...");
		ReaderService.processEventInQueue();
	}
}

