package dev.blue.tbg;

public class Clock {
	private int TPS = 60;
	private long time = 0;
	private int secondsPerDay = 30;
	private int ticksPerDay;
	private double ticksPerHour;
	private double ticksPerMinute;
	
	public Clock() {
		ticksPerDay = secondsPerDay*TPS;
		ticksPerHour = ticksPerDay/24;
		ticksPerMinute = ticksPerHour/60;
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
		return (int) Math.ceil(time/ticksPerMinute)%60;
	}
	
	public int getHour() {
		return (int) Math.ceil(time/ticksPerHour)%12;//24hr clock
	}
	
	public int getDay() {
		return (int) Math.ceil(time/ticksPerDay);
	}
	
	public String getMeridian() {
		return Math.ceil(time/ticksPerHour)/12 < 1 ? "AM":"PM";
	}
}
