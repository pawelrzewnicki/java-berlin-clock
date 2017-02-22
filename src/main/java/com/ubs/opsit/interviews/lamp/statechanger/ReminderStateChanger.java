package com.ubs.opsit.interviews.lamp.statechanger;

public class ReminderStateChanger extends ReminderNoMoreThanStateChanger {

	public ReminderStateChanger(int divider, int reminder) {
		super(divider, reminder);

	}

	@Override
	public boolean getState(int currentTime) {
		return currentTime % divider == reminder;

	}

}
