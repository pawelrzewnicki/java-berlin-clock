package com.ubs.opsit.interviews.lamp.statechanger;

public class ReminderNoMoreThanStateChanger implements StateChanger {

	int divider;
	int reminder;

	public ReminderNoMoreThanStateChanger(int divider, int reminder) {
		super();
		this.divider = divider;
		this.reminder = reminder;
	}

	@Override
	public boolean getState(int currentTime) {
		return currentTime % divider >= reminder;

	}

}
