package dev.blue.tbg.calendar;

public class Clock {
	private int TPS = 60;
	private long time = 0;
	private int secondsPerDay = 30;
	private int ticksPerDay;
	private double ticksPerHour;
	private double ticksPerMinute;
	private int startDay = 105;
	private int startYear = 1800;
	private Month month;
	
	public Clock() {
		ticksPerDay = secondsPerDay*TPS;
		ticksPerHour = ticksPerDay/24;
		ticksPerMinute = ticksPerHour/60;
		month = new Month();
		month.setYear(startYear);
	}
	
	public int getTPS() {
		return TPS;
	}
	
	public long getTimeRaw() {
		return time;
	}
	
	public void incrementTime(int amt) {
		time += amt;
	}
	
	public int getMinute() {
		return (int) (time/ticksPerMinute)%60;
	}
	
	public int getHour() {
		return (int) (time/ticksPerHour)%12;
	}
	
	public int getDay() {
		return startDay+(int) (time/ticksPerDay);
	}
	
	public int getYear() {
		int days = getDay();
	    int year = startYear;

	    while(true) {
	        int daysInYear = (year % 4 == 0 && ((year % 100 != 0) || (year % 400 == 0))) ? 366 : 365;
	        if (days < daysInYear) break;
	        days -= daysInYear;
	        year++;
	    }
		return year;
	}
	
	public String getMeridian() {
		return (int)(time/ticksPerHour)%24 < 12 ? "AM":"PM";
	}
	
	public String getDate() {
		int year = getYear();
		int dayOfYear = getDay();
		int dayOfMonth = month.dayOfMonth(dayOfYear);
		
		return month.getName(dayOfYear)+" "+month.dayOfMonth(dayOfYear)+getOrdinalSuffix(dayOfMonth)+", "+year;//"Day "+clock.getDay()+", "+clock.getHour()+":"+clock.getMinute()+" "+clock.getMeridian()
	}
	
	public String getTime() {
		int hr = getHour();
		String hour = ""+(hr == 0 ? 12 : hr);
		String minute = ""+getMinute();
		if(minute.length() == 1) {
			minute = "0"+minute;
		}
		if(hour.length() == 1) {
			hour = " "+hour;
		}
		return hour+":"+minute+" "+getMeridian();
	}
	
	public static String getOrdinalSuffix(int number) {
		int abs = Math.abs(number);
		int lastTwo = abs % 100;
		if(lastTwo >= 11 && lastTwo <= 13) {
			return "th";
		}
		
		switch(abs % 10) {
			case 1: return "st";
			case 2: return "nd";
			case 3: return "rd";
			default: return "th";
		}
	}
}
