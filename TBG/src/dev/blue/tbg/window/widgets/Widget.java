package dev.blue.tbg.window.widgets;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public abstract class Widget extends JPanel{
	private static final long serialVersionUID = 1L;
	protected GridBagConstraints gbc;
	
	public Widget() {
		
	}
	
	public GridBagConstraints getConstraints() {
		return gbc;
	}
}
