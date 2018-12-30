package com.spring.vehicletracking.services;

import java.util.Timer;

public class ReaderTaskScheduler {
	
	private static final Timer timer = new Timer();
	
	private static final WriterTask readerTask = new WriterTask();
	
	private static int readerPeriod = 10000;
	
	public static void schedulerReaderService() {
		
		readerTask.cancel();
		timer.schedule(readerTask, 0, readerPeriod);
	}

	public static int getReaderPeriod() {
		return readerPeriod;
	}

	public static void setReaderPeriod(int readerPeriod) {
		ReaderTaskScheduler.readerPeriod = readerPeriod;
	}
	
	
}
