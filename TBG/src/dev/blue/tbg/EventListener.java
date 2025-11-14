package dev.blue.tbg;

import dev.blue.tbg.EventLogger.Event;

public interface EventListener {
	/**
	 *Use this function to set the events you want your class to be notified by. 
	 **/
	public Event[] getEvents();
	
	/**
	 *Use this function to do something when your class is notified of an event. 
	 **/
	public void CatchEvent(Event event);
}
