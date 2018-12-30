package com.spring.vehicletracking.services;

import java.util.Timer;

public class ReaderTaskScheduler {
	
	private static int readerPeriod = 10000;
	
	public static void schedulerReaderService() {
		Timer time = new Timer();
		ReaderTask st = new ReaderTask();
		time.schedule(st, 0, readerPeriod);
	}

	public static int getReaderPeriod() {
		return readerPeriod;
	}

	public static void setReaderPeriod(int readerPeriod) {
		ReaderTaskScheduler.readerPeriod = readerPeriod;
	}
	
	
}
