package com.spring.vehicletracking.configuration;

public class ConfigurationForm {
	private String url;
	private String excludingString;
	
	public ConfigurationForm() {
		
	}
	
	public ConfigurationForm(String url, String excludingString) {
		this.url = url;
		this.excludingString = excludingString;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getExcludingString() {
		return excludingString;
	}
	public void setExcludingString(String excludingString) {
		this.excludingString = excludingString;
	}	
}
