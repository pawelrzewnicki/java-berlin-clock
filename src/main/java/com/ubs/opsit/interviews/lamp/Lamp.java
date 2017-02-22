package com.ubs.opsit.interviews.lamp;

import java.time.LocalTime;

public interface Lamp {

	public String state();
	public void update(LocalTime lt);
	
	public enum TimeType{
		SECONDS, MINUTES, HOURS
	}
	
}

