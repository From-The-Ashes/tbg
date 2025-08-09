package dev.blue.tbg.window.widgets.calendarPane;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.blue.tbg.EventListener;
import dev.blue.tbg.EventLogger.Event;
import dev.blue.tbg.calendar.DateTime;
import dev.blue.tbg.calendar.StepClock;

public class ClockWidget extends JPanel implements EventListener {
	private static final long serialVersionUID = 1L;
	private GridBagConstraints bordergbc;
	private JLabel text;
	private StepClock clock;
	
	public ClockWidget(StepClock clock) {
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
		this.text.setText(DateTime.loadFromClock(clock).getTimeString());
	}

	@Override
	public Event[] getEvents() {
		return new Event[] {Event.INC_MINUTE, Event.INC_HOUR};
	}

	@Override
	public void CatchEvent(Event event) {
		update();
	}
}
