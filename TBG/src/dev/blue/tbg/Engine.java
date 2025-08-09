package dev.blue.tbg;

import dev.blue.nml.Node;
import dev.blue.tbg.calendar.DateTime;
import dev.blue.tbg.calendar.StepClock;
import dev.blue.tbg.window.Window;

public class Engine implements Runnable {
	private Thread thread;
	private boolean running;
	private Window window;
	private StepClock clock;
	private int tickrate;
	private Node save;
	private int ticksPerSave = 300;
	private int ticksTilSave = 300;
	
	public Engine(Node root) {
		this.save = root;
		this.thread = new Thread(this);
		running = false;
		DateTime clockStart = DateTime.loadFromFile(save);
		int TPS = Integer.parseInt(root.getPath("SaveName", "TPS").getValue());
		int secondsPerDay = Integer.parseInt(root.getPath("SaveName", "SecondsPerDay").getValue());
		System.out.println("Starting clock at time "+clockStart.toString());
		clock = new StepClock(clockStart, TPS, secondsPerDay);
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
		final long interval = 1_000_000_000L / clock.getTPS();
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
		clock.increment();
		window.tick();
		ticksTilSave--;
		if(ticksTilSave < 0) {
			ticksTilSave = ticksPerSave;
			saveGameData();
		}
	}
	
	public void saveGameData() {
		Main.saveGame();
	}
	
	public int getTickrate() {
		return tickrate;
	}
	
	public StepClock getClock() {
		return clock;
	}
}
//Plantation simulator complete with different crops, seasons, employees, servants, slaves, animals, markets, weather events, political changes, etc. 
//Could expand into multiplayer, where the two can trade, share, buy and sell resources in competitive or co-op play.