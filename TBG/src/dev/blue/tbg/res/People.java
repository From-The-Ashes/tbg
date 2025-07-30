package dev.blue.tbg.res;

import java.util.HashMap;

public class People {
	HashMap<Type, Integer> assets = new HashMap<Type, Integer>();
	
	public enum Type{
		CHILDREN, WIVES, SERVANTS, EMPLOYEES, SLAVES
	}
}
