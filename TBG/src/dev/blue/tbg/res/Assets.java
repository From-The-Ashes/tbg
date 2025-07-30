package dev.blue.tbg.res;

import java.util.HashMap;

public class Assets {
	HashMap<Type, Integer> assets = new HashMap<Type, Integer>();
	
	public enum Type{
		ACREAGE, LIVING_QUARTERS, WATERWAYS, WORKSHOPS, SILOS, STABLES
	}
}
