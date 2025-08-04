package dev.blue.tbg.window.widgets.calendarPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JCell extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel label;
	public JCell(Font font, String value) {
		this.setLayout(new BorderLayout());
		label = new JLabel(value, SwingConstants.CENTER);
		label.setFont(font);
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(label, BorderLayout.CENTER);
	}
	
	public void setValue(String value) {
		this.label.setText(value);
	}
	
	public String getValue() {
		return label.getText();
	}
	
	public void setColor(Color color) {
		this.label.setForeground(color);
	}
	
	public void setSelected(boolean selected) {
		if(selected) {
			this.setBorder(BorderFactory.createLineBorder(Color.GREEN));//color, thickness, rounded
		}else {
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY));//color, thickness, rounded
		}
	}
}
