package com.spring.vehicletracking.services;

import java.util.Timer;

public class WriterServiceScheduler {
	
	public static void schedulerWriterService() {
		Timer time = new Timer();
		WriterTask st = new WriterTask();
		time.schedule(st, 0, 5000);
	}
}
