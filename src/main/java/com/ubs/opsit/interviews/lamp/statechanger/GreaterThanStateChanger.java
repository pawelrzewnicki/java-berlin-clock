package com.ubs.opsit.interviews.lamp.statechanger;

public class GreaterThanStateChanger implements StateChanger {

	int greaterThan;
	
	public GreaterThanStateChanger(int greaterThan) {
		super();
		this.greaterThan = greaterThan;
	}

	@Override
	public boolean getState(int currentTime) {
		
		return currentTime > greaterThan;
	}

}
