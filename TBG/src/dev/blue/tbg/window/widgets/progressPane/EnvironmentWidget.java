package dev.blue.tbg.window.widgets.progressPane;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.blue.tbg.EventListener;
import dev.blue.tbg.EventLogger.Event;
import dev.blue.tbg.env.Climate;
import dev.blue.tbg.env.Climate.Precipitation;
import dev.blue.tbg.window.widgets.Widget;

public class EnvironmentWidget extends Widget implements EventListener {
	private static final long serialVersionUID = 1L;
	private JLabel l_temp;
	private JLabel l_humid;
	private JLabel l_precip;
	
	private JLabel v_temp;
	private JLabel v_humid;
	private JLabel v_precip;
	
	private Climate climate;

	public EnvironmentWidget(Climate climate) {
		this.climate = climate;
		this.setBackground(Color.CYAN);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setOpaque(false);
		
		JPanel p_labels = new JPanel();
		p_labels.setLayout(new BoxLayout(p_labels, BoxLayout.Y_AXIS));
		JPanel p_values = new JPanel();
		p_values.setLayout(new BoxLayout(p_values, BoxLayout.Y_AXIS));
		
		l_temp = new JLabel("Temperature: ");
		v_temp = new JLabel(climate.getTemperature()+"°F");
		p_labels.add(l_temp);
		p_values.add(v_temp);
		
		l_humid = new JLabel("Humidity: ");
		v_humid = new JLabel(climate.getHumidity()+"%");
		p_labels.add(l_humid);
		p_values.add(v_humid);
		
		l_precip = new JLabel("Precipitation: ");
		v_precip = new JLabel(climate.getPrecipitation().format());
		p_labels.add(l_precip);
		p_values.add(v_precip);
		
		add(p_labels);
		add(p_values);
	}
	
	private void setTemperature(int i) {
		v_temp.setText(i+"°F");
	}

	private void setHumidity(int i) {
		v_humid.setText(i+"%");
	}
	
	private void setPrecipitation(Precipitation p) {
		v_precip.setText(p.format());
	}
	
	public void update() {
		setTemperature(climate.getTemperature());
		setHumidity(climate.getHumidity());
		setPrecipitation(climate.getPrecipitation());
	}

	@Override
	public Event[] getEvents() {
		return new Event[] {Event.INC_HOUR};//Should only need to update on an hourly basis. 
	}

	@Override
	public void CatchEvent(Event event) {
		if(event != Event.INC_HOUR) {
			return;
		}
		update();//pass the burden of simulation onto the climate class. 
	}
}
