package com.spring.vehicletracking.services;

import java.util.Timer;

public class WriterServiceScheduler {
	
	private static int writerPeriod = 5000;
	
	public static void schedulerWriterService() {
		Timer time = new Timer();
		WriterTask st = new WriterTask();
		time.schedule(st, 0, writerPeriod);
	}
	
	public static void setWriterPeriod(int period) {
		writerPeriod = period;
	}
	
	public static int getWriterPeriod() {
		return writerPeriod;
	}
}
