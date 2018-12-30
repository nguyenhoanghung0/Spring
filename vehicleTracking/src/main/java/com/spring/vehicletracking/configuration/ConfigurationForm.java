package com.spring.vehicletracking.configuration;

public class ConfigurationForm {
	
	private int writerPeriod;
	private int readerPeriod;
	private int numberOfVehicle;
	
	public ConfigurationForm() {
		
	}
	
	public ConfigurationForm(int writerPeriod, int readerPeriod) {
		this.writerPeriod = writerPeriod;
		this.readerPeriod = readerPeriod;
	}

	public int getWriterPeriod() {
		return writerPeriod;
	}

	public void setWriterPeriod(int writerPeriod) {
		this.writerPeriod = writerPeriod;
	}

	public int getReaderPeriod() {
		return readerPeriod;
	}

	public void setReaderPeriod(int readerPeriod) {
		this.readerPeriod = readerPeriod;
	}

	public int getNumberOfVehicle() {
		return numberOfVehicle;
	}

	public void setNumberOfVehicle(int numberOfVehicle) {
		this.numberOfVehicle = numberOfVehicle;
	}
}
