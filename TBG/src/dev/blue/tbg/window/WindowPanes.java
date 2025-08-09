package dev.blue.tbg.window;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import dev.blue.tbg.Pair;

public class WindowPanes {
	Pair<JPanel, GridBagConstraints> panel_lblt() {
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
	Pair<JPanel, GridBagConstraints> panel_lblb() {
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
	Pair<JPanel, GridBagConstraints> panel_lbl() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	Pair<JPanel, GridBagConstraints> panel_lbm() {
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
	Pair<JPanel, GridBagConstraints> panel_lbr() {
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
	Pair<JPanel, GridBagConstraints> panel_lb() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	Pair<JPanel, GridBagConstraints> panel_ltl() {
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
	Pair<JPanel, GridBagConstraints> panel_ltr() {
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
	Pair<JPanel, GridBagConstraints> panel_lt() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 1; gbc.weighty = 2.5;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	Pair<JPanel, GridBagConstraints> panel_l() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.weightx = 6; gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
	Pair<JPanel, GridBagConstraints> panel_rt() {
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
	Pair<JPanel, GridBagConstraints> panel_rm() {
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
	Pair<JPanel, GridBagConstraints> panel_rb() {
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
	Pair<JPanel, GridBagConstraints> panel_r() {//container
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		panel.setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1; gbc.gridy = 0;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		return new Pair<JPanel, GridBagConstraints>(panel, gbc);
	}
}
