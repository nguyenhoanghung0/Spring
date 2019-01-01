package com.spring.vehicletracking.configuration;

import java.util.List;

public class ConfigurationForm {
	
	private int writerPeriod;
	private int readerPeriod;
	private int numberOfVehicles;
	private String errorList;
	
	public ConfigurationForm() {
		
	}
	
	public ConfigurationForm(int writerPeriod, int readerPeriod, int numberOfVehicles) {
		this.writerPeriod = writerPeriod;
		this.readerPeriod = readerPeriod;
		this.numberOfVehicles = numberOfVehicles;
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

	public int getNumberOfVehicles() {
		return numberOfVehicles;
	}

	public void setNumberOfVehicles(int numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}
	
	public String getErrorList() {
		return errorList;
	}

	public void setErrorList(String errorList) {
		this.errorList = errorList;
	}	
}
