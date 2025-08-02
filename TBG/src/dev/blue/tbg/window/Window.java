package dev.blue.tbg.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dev.blue.tbg.Engine;
import dev.blue.tbg.Pair;
import dev.blue.tbg.calendar.Clock;
import dev.blue.tbg.window.widgets.calendarPane.CalendarWidget;
import dev.blue.tbg.window.widgets.calendarPane.ClockWidget;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private MouseManager mouseManager;
	private KeyboardManager keyboardManager;
	private Dimension dim;
	private Clock clock;
	
	private ClockWidget clockDisplay;
	
	public Window(Engine engine) {
		this.mouseManager = new MouseManager();
		this.keyboardManager = new KeyboardManager();
		dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		clock = engine.getClock();
		setup();
	}
	
	private void setup() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Text-Based Game");
		this.setIconImage(null);
		this.setPreferredSize(dim);
		this.setMinimumSize(dim);
		this.setMaximumSize(dim);
		this.setLocationRelativeTo(null);
		
		this.getContentPane().setBackground(new Color(0, 0, 0));
		this.getContentPane().setForeground(new Color(200, 200, 200));
		
		this.addMouseListener(mouseManager);
		this.addMouseMotionListener(mouseManager);
		this.addMouseWheelListener(mouseManager);
		this.addKeyListener(keyboardManager);
		
		layoutPage();
		
		this.pack();
		this.setVisible(true);
	}
	
	private void layoutPage() {
		Pair<JPanel, GridBagConstraints> lblt = panel_lblt();
		Pair<JPanel, GridBagConstraints> lblb = panel_lblb();//repeat
		Pair<JPanel, GridBagConstraints> lbl = panel_lbl();
		Pair<JPanel, GridBagConstraints> lbm = panel_lbm();
		Pair<JPanel, GridBagConstraints> lbr = panel_lbr();
		Pair<JPanel, GridBagConstraints> lb = panel_lb();
		Pair<JPanel, GridBagConstraints> ltl = panel_ltl();
		Pair<JPanel, GridBagConstraints> ltr = panel_ltr();
		Pair<JPanel, GridBagConstraints> lt = panel_lt();
		Pair<JPanel, GridBagConstraints> l = panel_l();
		Pair<JPanel, GridBagConstraints> rt = panel_rt();
		Pair<JPanel, GridBagConstraints> rm = panel_rm();
		Pair<JPanel, GridBagConstraints> rb = panel_rb();
		Pair<JPanel, GridBagConstraints> r = panel_r();
		
		lbl.A().add(lblt.A(), lblt.B());
		lbl.A().add(lblb.A(), lblb.B());
		
		lb.A().add(lbl.A(), lbl.B());
		lb.A().add(lbm.A(), lbm.B());
		lb.A().add(lbr.A(), lbr.B());
		
		lt.A().add(ltl.A(), ltl.B());
		lt.A().add(ltr.A(), ltr.B());
		
		l.A().add(lt.A(), lt.B());
		l.A().add(lb.A(), lb.B());
		
		r.A().add(rt.A(), rt.B());
		r.A().add(rm.A(), rm.B());
		r.A().add(rb.A(), rb.B());
		
		getContentPane().setLayout(new GridBagLayout());
		
		
		getContentPane().add(l.A(), l.B());
		getContentPane().add(r.A(), r.B());
		
		CalendarWidget wcal = new CalendarWidget(clock);
		clockDisplay = new ClockWidget(clock);
		rt.A().add(wcal);
		rt.A().add(clockDisplay, clockDisplay.getConstraints());
		
		//clockDisplay = new JTextArea(""+clock.getTimeRaw());
		//clockDisplay.setEditable(false);
		//clockDisplay.setMinimumSize(new Dimension(100, 30));
		//getContentPane().add(clockDisplay);
	}
	
	private Pair<JPanel, GridBagConstraints> panel_lblt() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 30, 30));
		panel.setOpaque(true);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 1; gbc.weighty = 3;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_lblb() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(80, 30, 30));
		panel.setOpaque(true);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_lbl() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_lbm() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 30, 80));
		panel.setOpaque(true);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1; gbc.gridy = 0;
		gbc.weightx = 3; gbc.weighty = 1;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_lbr() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(80, 80, 30));
		panel.setOpaque(true);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 2; gbc.gridy = 0;
		gbc.weightx = 10; gbc.weighty = 1;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_lb() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_ltl() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(80, 30, 80));
		panel.setOpaque(true);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.insets = new Insets(2, 2, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_ltr() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(80, 80, 80));
		panel.setOpaque(true);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1; gbc.gridy = 0;
		gbc.weightx = 4; gbc.weighty = 1;
		gbc.insets = new Insets(2, 1, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_lt() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 1; gbc.weighty = 2.5;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_l() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 6; gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_rt() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(new Color(80, 80, 120));
		panel.setOpaque(true);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 1; gbc.weighty = 2;
		gbc.insets = new Insets(2, 0, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_rm() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(120, 80, 120));
		panel.setOpaque(true);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.weightx = 1; gbc.weighty = 5;
		gbc.insets = new Insets(1, 0, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_rb() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(120, 120, 80));
		panel.setOpaque(true);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 2;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.insets = new Insets(1, 0, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	private Pair<JPanel, GridBagConstraints> panel_r() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1; gbc.gridy = 0;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	
	private void updatePage() {
		clockDisplay.update();
	}
	
	public void tick() {
		updatePage();
	}
}
