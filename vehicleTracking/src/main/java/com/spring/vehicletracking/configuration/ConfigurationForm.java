package com.spring.vehicletracking.configuration;

import com.spring.vehicletracking.scheduler.ReaderTaskScheduler;
import com.spring.vehicletracking.scheduler.WriterTaskScheduler;
import com.spring.vehicletracking.util.CommonConstant;

public class ConfigurationForm {
	
	private int writerPeriod;
	private int readerPeriod;
	private int numberOfVehicles;
	private int numberOfRecordsPerPage;
	private String[] errorList;
	
	public ConfigurationForm() {
		
	}
	
	public static ConfigurationForm getInstance() {
		ConfigurationForm form = new ConfigurationForm();
		
		form.writerPeriod = WriterTaskScheduler.getWriterPeriod();
		form.readerPeriod = ReaderTaskScheduler.getReaderPeriod();
		form.numberOfVehicles = CommonConstant.NUMBER_OF_VEHICLES;
		form.numberOfRecordsPerPage = CommonConstant.PAGE_SIZE;
		
		return form;
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
	
	public String [] getErrorList() {
		return errorList;
	}

	public void setErrorList(String [] errorList) {
		this.errorList = errorList;
	}

	public int getNumberOfRecordsPerPage() {
		return numberOfRecordsPerPage;
	}

	public void setNumberOfRecordsPerPage(int numberOfRecordsPerPage) {
		this.numberOfRecordsPerPage = numberOfRecordsPerPage;
	}
}
