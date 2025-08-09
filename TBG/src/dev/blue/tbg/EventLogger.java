package dev.blue.tbg;

import java.util.ArrayList;
import java.util.List;

public class EventLogger {
	public enum Event {
		INC_MINUTE,
		INC_HOUR,
		INC_DAY,
		INC_MONTH,
		INC_YEAR
	}
	public List<EventListener> listeners;
	public EventLogger() {
		listeners = new ArrayList<EventListener>();
	}
	
	public void registerListener(EventListener listener) {
		listeners.add(listener);
	}
	
	public void logEvent(Event e) {
		for(EventListener each:listeners) {
			Event[] events = each.getEvents();
			for(int i = 0; i < events.length; i++) {
				if(e == events[i]) {
					each.CatchEvent(e);
				}
			}
		}
	}
}
