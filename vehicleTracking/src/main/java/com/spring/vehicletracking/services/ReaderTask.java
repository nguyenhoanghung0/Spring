package com.spring.vehicletracking.services;

import java.util.TimerTask;

/**
 * Read data from queue and store in to database
 *
 */
public class ReaderTask extends TimerTask {
	
	public void run() {
		System.out.println("Reading event...");
		ReaderService.processEventInQueue();
	}
}

