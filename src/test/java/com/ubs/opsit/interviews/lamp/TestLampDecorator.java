package com.ubs.opsit.interviews.lamp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.Test;

import com.ubs.opsit.interviews.lamp.Lamp.TimeType;
import com.ubs.opsit.interviews.lamp.statechanger.StateChanger;

public class TestLampDecorator {

	@Test
	public void testShiningLamp(){
		
		LocalTime time = LocalTime.parse("13:17:01");
		
		String decoration = "decoration";
		
		StateChanger stateChanger = mock(StateChanger.class);
		when(stateChanger.getState(time.getHour())).thenReturn(true);
		
		YellowLamp yellowLamp = new YellowLamp(TimeType.HOURS, stateChanger);
		LampDecorator lampDecorator = new LampDecorator(yellowLamp, decoration);
		
		yellowLamp.update(time);
		
		assertTrue(lampDecorator.state().equals("Y" + decoration));
		assertTrue(yellowLamp.isShining);
	}
	
	@Test
	public void testNotShiningLamp(){
		
		LocalTime time = LocalTime.parse("13:17:01");
		
		String decoration = "decoration";
		
		StateChanger stateChanger = mock(StateChanger.class);
		when(stateChanger.getState(time.getSecond())).thenReturn(false);
		
		YellowLamp yellowLamp = new YellowLamp(TimeType.SECONDS, stateChanger);
		LampDecorator lampDecorator = new LampDecorator(yellowLamp, decoration);
		
		yellowLamp.update(time);
		
		assertTrue(lampDecorator.state().equals("O" + decoration));
		assertFalse(yellowLamp.isShining);
		
	}
	
}
