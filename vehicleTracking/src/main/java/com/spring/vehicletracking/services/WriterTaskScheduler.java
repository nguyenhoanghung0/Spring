package com.spring.vehicletracking.services;

import java.util.Timer;

public class WriterTaskScheduler {
	
	private static final Timer timer = new Timer();
	
	private static final WriterTask writerTask = new WriterTask();
	
	private static int writerPeriod = 5000;
	
	public static void schedulerWriterService() {
		
		writerTask.cancel();
		timer.schedule(writerTask, 0, writerPeriod);
	}
	
	public static void setWriterPeriod(int period) {
		writerPeriod = period;
	}
	
	public static int getWriterPeriod() {
		return writerPeriod;
	}
}
