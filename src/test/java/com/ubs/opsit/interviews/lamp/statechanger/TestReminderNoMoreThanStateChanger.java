package com.ubs.opsit.interviews.lamp.statechanger;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReminderNoMoreThanStateChanger {

	@Test
	public void testGetStateEquals() {
		
		int currentTime = 10;
		int divider = 3;
		int reminder = 1;
		
		StateChanger stateChanger = new ReminderNoMoreThanStateChanger(divider, reminder);
		
		boolean state = stateChanger.getState(currentTime);
		
		assertTrue(state);

	}
	
	@Test
	public void testGetStateLower() {
		
		int currentTime = 11;
		int divider = 3;
		int reminder = 1;
		
		StateChanger stateChanger = new ReminderNoMoreThanStateChanger(divider, reminder);
		
		boolean state = stateChanger.getState(currentTime);
		
		assertTrue(state);

	}
	
	@Test
	public void testGetStateGreater() {
		
		int currentTime = 11;
		int divider = 3;
		int reminder = 3;
		
		StateChanger stateChanger = new ReminderNoMoreThanStateChanger(divider, reminder);
		
		boolean state = stateChanger.getState(currentTime);
		
		assertFalse(state);

	}
	
}
