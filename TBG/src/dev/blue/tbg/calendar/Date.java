package dev.blue.tbg.calendar;

public class Date {
	private int currentDay;
	private int currentMonth;
	private int currentYear;
	
	public Date(Clock clock) {
		currentDay = clock.getDayOfMonth();
		currentMonth = clock.getMonth();
		currentYear = clock.getYear();
	}
	
	public int getCurrentDay() {
		return currentDay;
	}
	
	public int getCurrentMonth() {
		return currentMonth;
	}
	
	public int getCurrentYear() {
		return currentYear;
	}
}
