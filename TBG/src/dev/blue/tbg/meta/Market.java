package dev.blue.tbg.meta;

import java.util.HashMap;

public class Market {
	HashMap<Type, Double> values = new HashMap<Type, Double>();
	
	public enum Type{
		PORK, BEEF, LAMB, POULTRY, GRAIN, HAYBALES, TEMPERATE_FRUIT, TROPICAL_FRUIT
	}
}
