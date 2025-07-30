package dev.blue.tbg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import dev.blue.tbg.calendar.Clock;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private MouseManager mouseManager;
	private KeyboardManager keyboardManager;
	private GridBagLayout layout;
	private GridBagConstraints gbc;
	private Dimension dim;
	private Clock clock;
	
	private JTextArea clockDisplay;
	
	public Window(Engine engine) {
		this.mouseManager = new MouseManager();
		this.keyboardManager = new KeyboardManager();
		layout = new GridBagLayout();
		gbc = new GridBagConstraints();
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
		
		this.getContentPane().setBackground(new Color(80, 80, 80));
		this.getContentPane().setForeground(new Color(200, 200, 200));
		this.setLayout(layout);
		
		this.addMouseListener(mouseManager);
		this.addMouseMotionListener(mouseManager);
		this.addMouseWheelListener(mouseManager);
		this.addKeyListener(keyboardManager);
		
		layoutPage();
		
		this.pack();
		this.setVisible(true);
	}
	
	private void layoutPage() {
		clockDisplay = new JTextArea(""+clock.getTimeRaw());
		clockDisplay.setEditable(false);
		clockDisplay.setMinimumSize(new Dimension(100, 30));
		getContentPane().add(clockDisplay);
	}
	
	private void updatePage() {
		//clockDisplay.setText(""+clock.getTimeRaw());
		clockDisplay.setText(clock.getDate()+" | "+clock.getTime());
	}
	
	public void tick() {
		updatePage();
	}
}
