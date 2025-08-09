package dev.blue.tbg.calendar;

import dev.blue.nml.Node;

public class DateTime {
	int seconds = 0, minutes = 0, hours = 0, day = 1, month = 0, year = 1800;
	
	private DateTime(int seconds, int minutes, int hours, int day, int month, int year) {
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return new String(month+"/"+day+"/"+year+", "+hours+":"+minutes+":"+seconds);
	}
	
	public static DateTime loadFromFile(Node save) {
		String[] filedata = save.getPath("SaveName", "DateTime").getValue().split("_");//d_m_y_h_m_s
		return new DateTime(Integer.parseInt(filedata[5]), Integer.parseInt(filedata[4]), Integer.parseInt(filedata[3]), Integer.parseInt(filedata[0]),
				Integer.parseInt(filedata[1]), Integer.parseInt(filedata[2]));
	}
	
	public static DateTime loadFromClock(StepClock clock) {
		return new DateTime(clock.getSeconds(), clock.getMinutes(), clock.getHours(), clock.getDayOfMonth(), clock.getMonth(), clock.getYear());
	}
	
	/**
	 *Does NOT save to file. Saving still needs to be done through normal channels using the NML Parser. 
	 **/
	public void writeToNode(Node save) {
		Node dt = save.getChild("SaveName").getChild("DateTime");
		dt.setValue(day+"_"+month+"_"+year+"_"+hours+"_"+minutes+"_"+seconds);
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
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getMeridian() {
		return hours/12 < 1 ? "AM":"PM";
	}
	
	public String getDateString() {
		return StepClock.getMonthName(month)+" "+day+getOrdinalSuffix(day)+", "+year;
	}
	
	public String getTimeString() {
		int hr = (hours > 12 ? hours%12 : hours);//Turns it into 12-hour format
		String hour = ""+(hr == 0 ? 12 : hr);//Makes sure that 0:00 is actually 12:00
		String minute = ""+minutes;
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
