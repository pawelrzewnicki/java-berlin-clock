package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ubs.opsit.interviews.lamp.Lamp;
import com.ubs.opsit.interviews.lamp.LampDecorator;
import com.ubs.opsit.interviews.lamp.RedLamp;
import com.ubs.opsit.interviews.lamp.YellowLamp;
import com.ubs.opsit.interviews.lamp.Lamp.TimeType;
import com.ubs.opsit.interviews.lamp.statechanger.GreaterThanStateChanger;
import com.ubs.opsit.interviews.lamp.statechanger.ReminderNoMoreThanStateChanger;
import com.ubs.opsit.interviews.lamp.statechanger.ReminderStateChanger;

public class TimeConverterImpl implements TimeConverter {

	public static final String EXCEPTION_24h = "24:00:00";
	public static final String EXCEPTION_24h_RESULT = "Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO";
	
	List<Lamp> lamps;
	LocalTime time;

	@Override
	public String convertTime(String aTime) {

		if (aTime.equals(EXCEPTION_24h)) {
			return EXCEPTION_24h_RESULT;
		}

		initLamps();

		// Time parser - unchecked DateTimeParseException
		time = LocalTime.parse(aTime);

		// updates all lamps based on time
		lamps.stream().forEach(l -> l.update(time));

		return lamps.stream().map(l -> l.state()).collect(Collectors.joining());
	}

	void initLamps() {

		lamps = new ArrayList<Lamp>();

		// first row of lamps
		lamps.add(new LampDecorator(new YellowLamp(TimeType.SECONDS, new ReminderStateChanger(2, 0)), "\r\n"));

		// second row of lamps
		lamps.add(new RedLamp(TimeType.HOURS, new GreaterThanStateChanger(5)));
		lamps.add(new RedLamp(TimeType.HOURS, new GreaterThanStateChanger(10)));
		lamps.add(new RedLamp(TimeType.HOURS, new GreaterThanStateChanger(15)));
		lamps.add(new LampDecorator(new RedLamp(TimeType.HOURS, new GreaterThanStateChanger(20)), "\r\n"));

		// third row of lamps
		lamps.add(new RedLamp(TimeType.HOURS, new ReminderNoMoreThanStateChanger(5, 1)));
		lamps.add(new RedLamp(TimeType.HOURS, new ReminderNoMoreThanStateChanger(5, 2)));
		lamps.add(new RedLamp(TimeType.HOURS, new ReminderNoMoreThanStateChanger(5, 3)));
		lamps.add(new LampDecorator(new RedLamp(TimeType.HOURS, new ReminderNoMoreThanStateChanger(5, 4)), "\r\n"));

		// fourth row of lamps
		lamps.add(new YellowLamp(TimeType.MINUTES, new GreaterThanStateChanger(5)));
		lamps.add(new YellowLamp(TimeType.MINUTES, new GreaterThanStateChanger(10)));
		lamps.add(new RedLamp(TimeType.MINUTES, new GreaterThanStateChanger(15)));
		lamps.add(new YellowLamp(TimeType.MINUTES, new GreaterThanStateChanger(20)));
		lamps.add(new YellowLamp(TimeType.MINUTES, new GreaterThanStateChanger(25)));
		lamps.add(new RedLamp(TimeType.MINUTES, new GreaterThanStateChanger(30)));
		lamps.add(new YellowLamp(TimeType.MINUTES, new GreaterThanStateChanger(35)));
		lamps.add(new YellowLamp(TimeType.MINUTES, new GreaterThanStateChanger(40)));
		lamps.add(new RedLamp(TimeType.MINUTES, new GreaterThanStateChanger(45)));
		lamps.add(new YellowLamp(TimeType.MINUTES, new GreaterThanStateChanger(50)));
		lamps.add(new LampDecorator(new YellowLamp(TimeType.MINUTES, new GreaterThanStateChanger(55)), "\r\n"));

		// fifth row of lamps
		lamps.add(new YellowLamp(TimeType.MINUTES, new ReminderNoMoreThanStateChanger(5, 1)));
		lamps.add(new YellowLamp(TimeType.MINUTES, new ReminderNoMoreThanStateChanger(5, 2)));
		lamps.add(new YellowLamp(TimeType.MINUTES, new ReminderNoMoreThanStateChanger(5, 3)));
		lamps.add(new YellowLamp(TimeType.MINUTES, new ReminderNoMoreThanStateChanger(5, 4)));

	}

}
