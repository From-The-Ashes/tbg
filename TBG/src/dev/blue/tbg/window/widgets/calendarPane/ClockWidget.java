package dev.blue.tbg.window.widgets.calendarPane;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.blue.tbg.calendar.Clock;

public class ClockWidget extends JPanel {
	private static final long serialVersionUID = 1L;
	private GridBagConstraints bordergbc;
	private JLabel text;
	private Clock clock;
	
	public ClockWidget(Clock clock) {
		this.bordergbc = new GridBagConstraints();
		this.bordergbc.fill = GridBagConstraints.BOTH;
		this.bordergbc.gridx = 0; this.bordergbc.gridy = 1;
		this.bordergbc.weightx = 0;
		this.bordergbc.weighty = 1;
		this.text = new JLabel();
		this.add(text);
		this.clock = clock;
		this.setOpaque(false);
	}
	
	public GridBagConstraints getConstraints() {
		return bordergbc;
	}
	
	public void update() {
		this.text.setText(clock.getTime());
	}
}
