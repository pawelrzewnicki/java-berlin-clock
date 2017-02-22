package com.ubs.opsit.interviews.lamp;

import com.ubs.opsit.interviews.lamp.statechanger.StateChanger;

public class YellowLamp extends AbstractLamp {



	public YellowLamp(TimeType timeType, StateChanger worker) {
		super(timeType, worker);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String state() {
		if (isShining) {
			return "Y";
		}

		return "O";

	}

}
