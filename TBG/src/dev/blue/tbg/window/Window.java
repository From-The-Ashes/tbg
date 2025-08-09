package dev.blue.tbg.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dev.blue.tbg.Engine;
import dev.blue.tbg.Main;
import dev.blue.tbg.Pair;
import dev.blue.tbg.calendar.StepClock;
import dev.blue.tbg.window.widgets.DisplayWidget;
import dev.blue.tbg.window.widgets.calendarPane.CalendarWidget;
import dev.blue.tbg.window.widgets.calendarPane.ClockWidget;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private MouseManager mouseManager;
	private KeyboardManager keyboardManager;
	private Dimension dim;
	private StepClock clock;
	
	private WindowPanes wp;
	private ClockWidget w_clock;
	private CalendarWidget w_calendar;
	private DisplayWidget w_display;
	
	public Window(Engine engine) {
		this.mouseManager = new MouseManager();
		this.keyboardManager = new KeyboardManager();
		dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		clock = engine.getClock();
		wp = new WindowPanes();
		setup();
	}
	
	private void setup() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Text-Based Game");
		this.setIconImage(null);
		this.setPreferredSize(dim);
		this.setMinimumSize(dim);
		this.setMaximumSize(dim);
		this.setLocationRelativeTo(null);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
			}
			@Override
			public void windowIconified(WindowEvent e) {
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
			}
			@Override
			public void windowClosing(WindowEvent e) {
			}
			@Override
			public void windowClosed(WindowEvent e) {
				Main.exitGame();
			}
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		
		this.getContentPane().setBackground(new Color(0, 0, 0));
		
		this.addMouseListener(mouseManager);
		this.addMouseMotionListener(mouseManager);
		this.addMouseWheelListener(mouseManager);
		this.addKeyListener(keyboardManager);
		
		layoutPage();
		
		this.pack();
		this.setVisible(true);
	}
	
	private void layoutPage() {
		Pair<JPanel, GridBagConstraints> lblt = wp.panel_lblt();
		Pair<JPanel, GridBagConstraints> lblb = wp.panel_lblb();//repeat
		Pair<JPanel, GridBagConstraints> lbl = wp.panel_lbl();
		Pair<JPanel, GridBagConstraints> lbm = wp.panel_lbm();
		Pair<JPanel, GridBagConstraints> lbr = wp.panel_lbr();
		Pair<JPanel, GridBagConstraints> lb = wp.panel_lb();
		Pair<JPanel, GridBagConstraints> ltl = wp.panel_ltl();
		Pair<JPanel, GridBagConstraints> ltr = wp.panel_ltr();
		Pair<JPanel, GridBagConstraints> lt = wp.panel_lt();
		Pair<JPanel, GridBagConstraints> l = wp.panel_l();
		Pair<JPanel, GridBagConstraints> rt = wp.panel_rt();
		Pair<JPanel, GridBagConstraints> rm = wp.panel_rm();
		Pair<JPanel, GridBagConstraints> rb = wp.panel_rb();
		Pair<JPanel, GridBagConstraints> r = wp.panel_r();
		
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
		
		w_calendar = new CalendarWidget(clock);
		w_clock = new ClockWidget(clock);
		w_display = new DisplayWidget();
		rt.A().add(w_calendar, w_calendar.getConstraints());
		rt.A().add(w_clock, w_clock.getConstraints());
		ltr.A().add(w_display);
		
		clock.getLogger().registerListener(w_calendar);
		clock.getLogger().registerListener(w_clock);
	}
	
	private void updatePage() {
		//Is this even needed, now that we have the events system?
	}
	
	public void tick() {
		updatePage();
	}
}
