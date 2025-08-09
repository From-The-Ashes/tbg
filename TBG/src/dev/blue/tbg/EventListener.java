package dev.blue.tbg;

import dev.blue.tbg.EventLogger.Event;

public interface EventListener {
	public Event[] getEvents();
	public void CatchEvent(Event event);
}
