package com.ubs.opsit.interviews.lamp;

import com.ubs.opsit.interviews.lamp.statechanger.StateChanger;

public class RedLamp extends AbstractLamp {


	public RedLamp(TimeType timeType, StateChanger worker) {
		super(timeType, worker);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String state() {
		if (isShining) {
			return "R";
		}

		return "O";

	}

}
