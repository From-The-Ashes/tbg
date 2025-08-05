package dev.blue.tbg;

public abstract class Asset {
	protected String name;
	protected double units;
	protected double valuePerUnit;
	protected Asset depends;//barns depend on acreage, cattle on barns, milk on cattle, cheese on milk.
}
