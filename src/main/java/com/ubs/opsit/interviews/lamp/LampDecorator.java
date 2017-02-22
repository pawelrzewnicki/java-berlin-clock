package com.ubs.opsit.interviews.lamp;

import java.time.LocalTime;

public class LampDecorator implements Lamp {

	Lamp lamp;
	String decorator;

	public LampDecorator(Lamp lamp, String decorator) {
		this.lamp = lamp;
		this.decorator = decorator;
	}

	@Override
	public String state() {
		String result = lamp.state();

		result += decorator;

		return result;
	}

	@Override
	public void update(LocalTime lt) {
		lamp.update(lt);

	}

}
