package dev.blue.tbg;

import dev.blue.tbg.env.Climate;

/**
 *This class became necessary when I realized I would need a single spot to put all the actual game LOGIC. It's fine to have an engine running the
 *clock and render loops, and it's great to have a window managing the display panes, but something has to do the thinking. This is the brain. 
 **/
public class Sim {
	public Climate climate;
	
	public Sim() {
		boolean randomize = !Main.getSave().getChild("SaveName").hasChild("Climate");
		climate = new Climate(randomize);
	}
	
	public void update() {
		
	}
}
