package dev.blue.tbg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dev.blue.tbg.calendar.Clock;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private MouseManager mouseManager;
	private KeyboardManager keyboardManager;
	private Dimension dim;
	private Clock clock;
	
	private JTextArea clockDisplay;
	
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
		
		this.getContentPane().setBackground(new Color(80, 80, 80));
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
		JPanel lblt = panel_lblt();
		JPanel lblb = panel_lblt();//repeat
		JPanel lbl = panel_lblt();
		
		GridBagConstraints gbc_lblt = new GridBagConstraints();
		GridBagConstraints gbc_lblb = new GridBagConstraints();
		gbc_lblt.gridx = 0; gbc_lblt.gridy = 0;
		gbc_lblt.weightx = 1; gbc_lblt.weighty = 1;
		gbc_lblt.fill = GridBagConstraints.BOTH;
		gbc_lblb.gridx = 0; gbc_lblb.gridy = 1;
		gbc_lblb.weightx = 1; gbc_lblb.weighty = 1;
		gbc_lblb.fill = GridBagConstraints.BOTH;
		lbl.add(lblt, gbc_lblt);
		lbl.add(lblb, gbc_lblb);
		
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		GridBagConstraints gbc_lbm = new GridBagConstraints();
		GridBagConstraints gbc_lbr = new GridBagConstraints();
		gbc_lbl.gridx = 0; gbc_lbl.gridy = 0;
		gbc_lbl.weightx = 1; gbc_lbl.weighty = 1;
		gbc_lbl.fill = GridBagConstraints.BOTH;
		gbc_lbm.gridx = 1; gbc_lbm.gridy = 0;
		gbc_lbm.weightx = 1; gbc_lbm.weighty = 1;
		gbc_lbm.fill = GridBagConstraints.BOTH;
		gbc_lbr.gridx = 2; gbc_lbr.gridy = 0;
		gbc_lbr.weightx = 1; gbc_lbr.weighty = 1;
		gbc_lbr.fill = GridBagConstraints.BOTH;
		panel_lb().add(panel_lbl(), gbc_lbl);
		panel_lb().add(panel_lbm(), gbc_lbm);
		panel_lb().add(panel_lbr(), gbc_lbr);
		
		GridBagConstraints gbc_ltl = new GridBagConstraints();
		GridBagConstraints gbc_ltr = new GridBagConstraints();
		gbc_ltl.gridx = 0; gbc_ltl.gridy = 0;
		gbc_ltl.weightx = 1; gbc_ltl.weighty = 1;
		gbc_ltl.fill = GridBagConstraints.BOTH;
		gbc_ltr.gridx = 1; gbc_ltr.gridy = 0;
		gbc_ltr.weightx = 1; gbc_ltr.weighty = 1;
		gbc_ltr.fill = GridBagConstraints.BOTH;
		panel_lt().add(panel_ltl(), gbc_ltl);
		panel_lt().add(panel_ltr(), gbc_ltr);
		
		GridBagConstraints gbc_lt = new GridBagConstraints();
		GridBagConstraints gbc_lb = new GridBagConstraints();
		gbc_lt.gridx = 0; gbc_lt.gridy = 0;
		gbc_lt.weightx = 1; gbc_lt.weighty = 1;
		gbc_lt.fill = GridBagConstraints.BOTH;
		gbc_lb.gridx = 0; gbc_lb.gridy = 1;
		gbc_lb.weightx = 1; gbc_lb.weighty = 1;
		gbc_lb.fill = GridBagConstraints.BOTH;
		panel_l().add(panel_lt(), gbc_lt);
		panel_l().add(panel_lb(), gbc_lb);
		
		GridBagConstraints gbc_rt = new GridBagConstraints();
		GridBagConstraints gbc_rm = new GridBagConstraints();
		GridBagConstraints gbc_rb = new GridBagConstraints();
		gbc_rt.gridx = 0; gbc_rt.gridy = 0;
		gbc_rt.weightx = 1; gbc_rt.weighty = 1;
		gbc_rt.fill = GridBagConstraints.BOTH;
		gbc_rm.gridx = 0; gbc_rm.gridy = 1;
		gbc_rm.weightx = 1; gbc_rm.weighty = 1;
		gbc_rm.fill = GridBagConstraints.BOTH;
		gbc_rb.gridx = 0; gbc_rb.gridy = 2;
		gbc_rb.weightx = 1; gbc_rb.weighty = 1;
		gbc_rb.fill = GridBagConstraints.BOTH;
		panel_r().add(panel_rt(), gbc_rt);
		panel_r().add(panel_rm(), gbc_rm);
		panel_r().add(panel_rb(), gbc_rb);
		
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc_l = new GridBagConstraints();
		GridBagConstraints gbc_r = new GridBagConstraints();
		gbc_l.gridx = 0; gbc_l.gridy = 0;
		gbc_l.weightx = 1; gbc_l.weighty = 1;
		gbc_l.fill = GridBagConstraints.BOTH;
		gbc_r.gridx = 1; gbc_r.gridy = 0;
		gbc_r.weightx = 1; gbc_r.weighty = 1;
		gbc_r.fill = GridBagConstraints.BOTH;
		getContentPane().add(panel_l(), gbc_l);
		getContentPane().add(panel_r(), gbc_r);
		
		clockDisplay = new JTextArea(""+clock.getTimeRaw());
		//clockDisplay.setEditable(false);
		//clockDisplay.setMinimumSize(new Dimension(100, 30));
		//getContentPane().add(clockDisplay);
	}
	
	private JPanel panel_lblt() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(new Color(30, 30, 30));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_lblb() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(new Color(80, 30, 30));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_lbl() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_lbm() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(new Color(30, 30, 80));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_lbr() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(new Color(80, 80, 30));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_lb() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_ltl() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(new Color(80, 30, 80));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_ltr() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(new Color(80, 80, 80));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_lt() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_l() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_rt() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(new Color(80, 80, 120));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_rm() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(new Color(120, 80, 120));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_rb() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(new Color(120, 120, 80));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	private JPanel panel_r() {
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setOpaque(true);
		panel.setVisible(true);
		return panel;
	}
	
	private void updatePage() {
		clockDisplay.setText(clock.getDate()+" | "+clock.getTime());
	}
	
	public void tick() {
		updatePage();
	}
}
