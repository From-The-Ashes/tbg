package dev.blue.tbg;

import dev.blue.tbg.calendar.Clock;
import dev.blue.tbg.window.Window;

public class Engine implements Runnable {
	private Thread thread;
	private boolean running;
	private Window window;
	private Clock clock;
	private int tickrate;
	
	public Engine() {
		this.thread = new Thread(this);
		running = false;
		clock = new Clock();
		window = new Window(this);
	}
	
	public synchronized void start() {
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	@Override
	public void run() {
		//Insert update loop here. 30s per day maybe?
		final long interval = 1000000000L / clock.getTPS();
		long lastTick = System.nanoTime();
		while (this.running) {
			long now = System.nanoTime();
			if (now - lastTick >= interval) {
				update();
				lastTick+=interval;
			}else {
				long timeToSleep = (interval - (now - lastTick)) / 1_000_000L;
				if(timeToSleep > 1) {
					try {
						Thread.sleep(timeToSleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					Thread.yield();
				}
			}
		}
		stop();
	}
	
	public void update() {
		clock.incrementTime(1);
		window.tick();
	}
	
	public int getTickrate() {
		return tickrate;
	}
	
	public Clock getClock() {
		return clock;
	}
}
//Plantation simulator complete with different crops, seasons, employees, servants, slaves, animals, markets, weather events, political changes, etc. 
//Could expand into multiplayer, where the two can trade, share, buy and sell resources in competitive or co-op play.