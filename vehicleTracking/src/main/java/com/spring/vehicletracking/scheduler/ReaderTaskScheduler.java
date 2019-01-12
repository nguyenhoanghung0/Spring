package com.spring.vehicletracking.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ReaderTaskScheduler {
	
	private static final ReaderTask readerTask = new ReaderTask();
	
	private static int readerPeriod = 10;
	
	private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
	
	private static ScheduledFuture<?> scheduledFuture;
	
	public static void schedulerReaderService() {
		
		stopScheduledService();
		
		scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(readerTask, 0, 
				readerPeriod, TimeUnit.SECONDS);
	}
	
	public static void stopScheduledService() {
		if (scheduledFuture != null) scheduledFuture.cancel(false);
	}

	public static int getReaderPeriod() {
		return readerPeriod;
	}

	public static void setReaderPeriod(int readerPeriod) {
		ReaderTaskScheduler.readerPeriod = readerPeriod;
	}
		
}
