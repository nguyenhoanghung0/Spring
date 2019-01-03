package com.spring.vehicletracking.model;

public class Event {
	private int vehicleId;
	private Action action;
	
	// TODO : Change Action to String
	public Event(int Id, Action action) {
		this.vehicleId = Id;
		this.action = action;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int id) {
		vehicleId = id;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public static enum Action {
	    START, STOP, NONE
	}
	
	@Override
	public String toString() {
		return "[" + getVehicleId() + "," + getAction().toString() + "]";
	}
}


