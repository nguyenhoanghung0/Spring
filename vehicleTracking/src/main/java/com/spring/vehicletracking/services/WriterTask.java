package com.spring.vehicletracking.services;

import java.util.TimerTask;

/**
 * Read data from the event source file
 * Each time it will read the events from 4 vehicles
 * @author Nguyen Hung
 *
 */
public class WriterTask extends TimerTask {

	public void run() {
		System.out.println("Adding event...");
		EventQueue.addEvents(FileSystemStorageService.getEventsForOneCycle());
	}
}
