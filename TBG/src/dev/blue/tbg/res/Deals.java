package dev.blue.tbg.res;

import java.util.HashMap;

public class Deals {
	HashMap<Type, Integer> assets = new HashMap<Type, Integer>();
	
	public enum Type{
		WORK_CONTRACTS, TRADE_AGREEMENTS, LOAN_PREAPPROVALS, POLITICAL_BRIBERY
	}
}
