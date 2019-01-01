package com.spring.vehicletracking.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WriterTaskScheduler {
	
	private static final WriterTask writerTask = new WriterTask();
	
	private static int writerPeriod = 5;
	
	private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
	
	private static ScheduledFuture<?> scheduledFuture;
	
	public static void schedulerWriterService() {
		
		if (scheduledFuture != null) scheduledFuture.cancel(false);
		scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(writerTask, 0, 
				writerPeriod, TimeUnit.SECONDS);
	}
	
	public static void setWriterPeriod(int period) {
		writerPeriod = period;
	}
	
	public static int getWriterPeriod() {
		return writerPeriod;
	}
}
