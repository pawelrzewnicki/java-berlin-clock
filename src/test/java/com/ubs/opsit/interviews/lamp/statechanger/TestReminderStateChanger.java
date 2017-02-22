package com.ubs.opsit.interviews.lamp.statechanger;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReminderStateChanger {

	@Test
	public void testGetStateTrue() {
		
		int currentTime = 10;
		int divider = 3;
		int reminder = 1;
		
		StateChanger stateChanger = new ReminderStateChanger(divider, reminder);
		
		boolean state = stateChanger.getState(currentTime);
		
		assertTrue(state);

	}
	
	@Test
	public void testGetStateFalse() {
		
		int currentTime = 11;
		int divider = 3;
		int reminder = 1;
		
		StateChanger stateChanger = new ReminderStateChanger(divider, reminder);
		
		boolean state = stateChanger.getState(currentTime);
		
		assertFalse(state);

	}
	
}
