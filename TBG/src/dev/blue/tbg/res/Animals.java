package dev.blue.tbg.res;

import java.util.HashMap;

public class Animals {
	HashMap<Type, Integer> assets = new HashMap<Type, Integer>();
	
	public enum Type{
		COWS, HORSES, DONKEYS, OXEN, CHICKENS, TURKEYS, HOGS, DEER, GOATS, BEAVERS, SHEEP
	}
}
