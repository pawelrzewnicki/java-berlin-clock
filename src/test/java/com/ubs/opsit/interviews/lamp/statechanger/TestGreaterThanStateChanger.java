package com.ubs.opsit.interviews.lamp.statechanger;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGreaterThanStateChanger {

	@Test
	public void testGetStateGreater() {
		
		int currentTime = 10;
		int greaterThan = 5;
		
		StateChanger stateChanger = new GreaterThanStateChanger(greaterThan);
		
		boolean state = stateChanger.getState(currentTime);
		
		assertTrue(state);

	}
	
	@Test
	public void testGetStateEquals() {
		
		int currentTime = 10;
		int greaterThan = 10;
		
		StateChanger stateChanger = new GreaterThanStateChanger(greaterThan);
		
		boolean state = stateChanger.getState(currentTime);
		
		assertFalse(state);

	}
	
	@Test
	public void testGetStateLower() {
		
		int currentTime = 10;
		int greaterThan = 15;
		
		StateChanger stateChanger = new GreaterThanStateChanger(greaterThan);
		
		boolean state = stateChanger.getState(currentTime);
		
		assertFalse(state);

	}
	
}
