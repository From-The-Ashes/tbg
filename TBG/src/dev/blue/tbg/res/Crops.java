package dev.blue.tbg.res;

import java.util.HashMap;

public class Crops {
	HashMap<Type, Integer> assets = new HashMap<Type, Integer>();
	
	public enum Type{
		COTTON, CORN, SOYBEANS, WHEAT, ALFALFA, HAY, POTATOES, SUGARCANE, APPLES, BERRIES, ORANGES, BANANAS
	}
}
