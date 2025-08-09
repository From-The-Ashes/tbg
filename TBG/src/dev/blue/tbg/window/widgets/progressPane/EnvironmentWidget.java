package dev.blue.tbg.window.widgets.progressPane;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.blue.tbg.window.widgets.Widget;

public class EnvironmentWidget extends Widget {
	private static final long serialVersionUID = 1L;
	private JLabel l_temp;
	private JLabel l_humid;
	private JLabel l_precip;
	
	private JLabel v_temp;
	private JLabel v_humid;
	private JLabel v_precip;

	public EnvironmentWidget() {
		this.setBackground(Color.CYAN);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setOpaque(false);
		
		JPanel p_labels = new JPanel();
		p_labels.setLayout(new BoxLayout(p_labels, BoxLayout.Y_AXIS));
		JPanel p_values = new JPanel();
		p_values.setLayout(new BoxLayout(p_values, BoxLayout.Y_AXIS));
		
		l_temp = new JLabel("Temperature: ");
		v_temp = new JLabel("72°F");
		p_labels.add(l_temp);
		p_values.add(v_temp);
		
		l_humid = new JLabel("Humidity: ");
		v_humid = new JLabel("48%");
		p_labels.add(l_humid);
		p_values.add(v_humid);
		
		l_precip = new JLabel("Precipitation: ");
		v_precip = new JLabel("None");//light, medium, high, torrential
		p_labels.add(l_precip);
		p_values.add(v_precip);
		
		add(p_labels);
		add(p_values);
	}
}
