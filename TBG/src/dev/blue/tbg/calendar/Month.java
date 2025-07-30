package dev.blue.tbg.calendar;

public class Month {
	private int[] monthLengths;
	private String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	public void setYear(int year) {
		if(year%4 == 0) {
			monthLengths = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		}else {
			monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		}
	}
	public String getName(int dayOfYear) {
		int index = 0;
		for(int i = 0; i < monthLengths.length; i++) {
			if((index += monthLengths[i]) > dayOfYear) {
				return monthNames[i];
			}
		}
		return "Error";
	}
	public int dayOfMonth(int dayOfYear) {
		int index = 0;
		for(int i = 0; i < monthLengths.length; i++) {
			if((index += monthLengths[i]) > dayOfYear) {
				return dayOfYear - (index - monthLengths[i]);
			}
		}
		return 0;
	}
}
