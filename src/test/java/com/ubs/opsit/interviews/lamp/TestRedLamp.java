package com.ubs.opsit.interviews.lamp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.Test;

import com.ubs.opsit.interviews.lamp.Lamp.TimeType;
import com.ubs.opsit.interviews.lamp.statechanger.StateChanger;

public class TestRedLamp {

	@Test
	public void testShiningLamp(){
		
		LocalTime time = LocalTime.parse("13:17:01");
		
		StateChanger stateChanger = mock(StateChanger.class);
		when(stateChanger.getState(time.getHour())).thenReturn(true);
		
		RedLamp redLamp = new RedLamp(TimeType.HOURS, stateChanger);
		
		redLamp.update(time);
		
		assertTrue(redLamp.state().equals("R"));
		assertTrue(redLamp.isShining);
	}
	
	@Test
	public void testNotShiningLamp(){
		
		LocalTime time = LocalTime.parse("13:17:01");
		
		StateChanger stateChanger = mock(StateChanger.class);
		when(stateChanger.getState(time.getMinute())).thenReturn(false);
		
		RedLamp redLamp = new RedLamp(TimeType.MINUTES, stateChanger);
		
		redLamp.update(time);
		
		assertTrue(redLamp.state().equals("O"));
		assertFalse(redLamp.isShining);
	}
	
}
