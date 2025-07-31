package dev.blue.tbg.calendar;

public class Date {
	private int currentDay;
	private int currentMonth;
	private int currentYear;
	
	public Date(Clock clock) {
		currentDay = clock.getDay();
		currentMonth = clock.getMonth();
	}
}
