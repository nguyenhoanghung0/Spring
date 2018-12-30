package com.spring.vehicletracking.services;

import java.util.Timer;

public class ReaderTaskScheduler {
	
	public static void schedulerReaderService() {
		Timer time = new Timer();
		ReaderTask st = new ReaderTask();
		time.schedule(st, 0, 10000);
	}
}
