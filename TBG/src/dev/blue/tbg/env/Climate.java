package dev.blue.tbg.env;

import java.util.Random;

import dev.blue.nml.Node;
import dev.blue.tbg.Main;

public class Climate {
	private int temp;
	private int humid;
	private Precipitation precip;
	
	private final int MAX_TEMP = 110;
	private final int MIN_TEMP = -10;
	
	private final int MAX_HUMID = 95;
	private final int MIN_HUMID = 5;
	
	public Climate(boolean randomize) {
		if(randomize) {
			Random rand = new Random();
			temp = rand.nextInt(MAX_TEMP-MIN_TEMP)+MIN_TEMP;
			humid = rand.nextInt(MAX_HUMID-MIN_HUMID)+MIN_HUMID;
			precip = Precipitation.get(rand.nextInt(5));
			Node climate = Main.getSave().getChild("SaveName").addChild("Climate");
			climate.addChild("T", temp);
			climate.addChild("H", humid);
			climate.addChild("P", Precipitation.toInt(precip));
		}else {
			Node climate = Main.getSave().getChild("SaveName").getChild("Climate");
			temp = Integer.parseInt(climate.getChild("T").getValue());
			humid = Integer.parseInt(climate.getChild("H").getValue());
			precip = Precipitation.get(Integer.parseInt(climate.getChild("P").getValue()));
		}
	}
	
	public int getTemperature() {
		return temp;
	}
	
	public void setTemperature(int i) {
		temp = i;
	}
	
	public int getHumidity() {
		return humid;
	}
	
	public void setHumidity(int i) {
		humid = i;
	}
	
	public Precipitation getPrecipitation() {
		return precip;
	}
	
	public void setPrecipitation(Precipitation p) {
		this.precip = p;
	}
	
	public enum Precipitation {
		NONE, LIGHT, MEDIUM, HEAVY, TORRENTIAL;
		
		public static Precipitation get(int i) {
			switch(i) {
			case 0:return NONE;
			case 1:return LIGHT;
			case 2:return MEDIUM;
			case 3:return HEAVY;
			default:return TORRENTIAL;
			}
		}
		
		public static int toInt(Precipitation p) {
			switch(p) {
			case NONE:return 0;
			case LIGHT:return 1;
			case MEDIUM:return 2;
			case HEAVY:return 3;
			default:return 4;
			}
		}
		
		public String format() {
			return (this.toString().charAt(0)+"").toUpperCase()+this.toString().substring(1, this.toString().length()).toLowerCase();
		}
	}
}
