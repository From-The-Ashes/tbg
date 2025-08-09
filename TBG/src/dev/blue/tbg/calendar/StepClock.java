package dev.blue.tbg.calendar;

import dev.blue.tbg.EventLogger;
import dev.blue.tbg.EventLogger.Event;
import dev.blue.tbg.Main;
import dev.blue.tbg.Pair;

public class StepClock {
	private EventLogger logger;
	private double timeOverflow;
	private int seconds;
	private int minutes;
	private int hours;
	private int dayOfMonth;
	private int month;
	private int year;
	
	private double secondsPerStep;
	private int TPS;
	
	
	@SuppressWarnings("unchecked")
	private static Pair<String, Integer>[] months = 
		new Pair[]{new Pair<String, Integer>("January", 31), new Pair<String, Integer>("February", 28), new Pair<String, Integer>("March", 31), new Pair<String, Integer>("April", 30), new Pair<String, Integer>("May", 31), 
			new Pair<String, Integer>("June", 30), new Pair<String, Integer>("July", 31), new Pair<String, Integer>("August", 31), new Pair<String, Integer>("September", 30), new Pair<String, Integer>("October", 31), 
			new Pair<String, Integer>("November", 30), new Pair<String, Integer>("December", 31)};
	
	public StepClock(DateTime dt, int TPS, int secondsPerDay) {
		logger = new EventLogger();
		int ticksPerSimDay = secondsPerDay * TPS;
		this.secondsPerStep = 86400.0 / ticksPerSimDay;//86400 is 24h, 60m, 60s
		this.TPS = TPS;
		this.seconds = dt.getSeconds();
		this.minutes = dt.getMinutes();
		this.hours = dt.getHours();
		this.dayOfMonth = dt.getDayOfMonth();
		this.month = dt.getMonth();
		this.year = dt.getYear();
		this.timeOverflow = 0;
	}
	
	public void increment() {
		// Accumulate time
		timeOverflow += secondsPerStep;
		int secStep = (int) timeOverflow;
		timeOverflow -= secStep;

		// Step through time units
		seconds += secStep;
		if (seconds >= 60) {
			minutes += seconds / 60;
			seconds = seconds % 60;
			announce(Event.INC_MINUTE);
		}

		if (minutes >= 60) {
			hours += minutes / 60;
			minutes = minutes % 60;
			announce(Event.INC_HOUR);
		}

		if (hours >= 24) {
			dayOfMonth += hours / 24;
			hours = hours % 24;
			announce(Event.INC_DAY);
		}
		
		if(dayOfMonth > daysInMonth(month, year)) {
			month++;
			dayOfMonth = 1;
			announce(Event.INC_MONTH);
		}
		
		if(month > 11) {//Should this be 12?
			year++;
			month = 0;
			announce(Event.INC_YEAR);
		}
		DateTime.loadFromClock(this).writeToNode(Main.getSave());
	}
	
	private void announce(Event event) {
		logger.logEvent(event);
	}
	
	public EventLogger getLogger() {
		return logger;
	}
	
	public int getTPS() {
		return TPS;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getHours() {
		return hours;
	}
	
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	
	public int getMonth() {
		return month;
	}
	
	public static String getMonthName(int month) {
		return months[month].A();
	}
	
	public int getYear() {
		return year;
	}
	
	/**
	 *Number of days in a month depend on the year, since leap years add a single day to February. 
	 **/
	public int daysInMonth(int month, int year) {
		if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
		    months[1].setB(29);
		} else {
			months[1].setB(28);
		}
		return months[month].B();
	}
}
