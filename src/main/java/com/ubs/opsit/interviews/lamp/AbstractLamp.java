package com.ubs.opsit.interviews.lamp;

import java.time.LocalTime;

import com.ubs.opsit.interviews.lamp.statechanger.StateChanger;

public abstract class AbstractLamp implements Lamp {

	protected boolean isShining = false;
	
	TimeType timeType;

	StateChanger stateChanger;
	
	
	public AbstractLamp(TimeType timeType, StateChanger worker) {
		super();
		this.timeType = timeType;
		this.stateChanger = worker;
	}

	@Override
	public void update(LocalTime lt) {
		int currentTime = getCurrentTime(lt);
		
		isShining = stateChanger.getState(currentTime);
		

	}

	private int getCurrentTime(LocalTime lt) {
		int currentTime;
		
		if(timeType.equals(TimeType.HOURS))
		{
			currentTime = lt.getHour();
		}
		else if(timeType.equals(TimeType.MINUTES))
		{
			currentTime = lt.getMinute();
		}
		else{
			currentTime = lt.getSecond();
		}
		
		return currentTime;
	}

}
