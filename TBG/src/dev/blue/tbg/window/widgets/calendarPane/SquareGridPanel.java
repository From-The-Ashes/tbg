package dev.blue.tbg.window.widgets.calendarPane;

import javax.swing.*;
import java.awt.*;

public class SquareGridPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int rows;
	private final int cols;
	private int value;

	public SquareGridPanel(int rows, int cols, int hgap, int vgap) {
		super(new GridLayout(rows, cols, hgap, vgap));
		this.rows = rows;
		this.cols = cols;
		this.setOpaque(false);
	}
	
	public void setValue(int i) {
		this.value = i;
	}
	
	public int getValue() {
		return this.value;
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		int cellSize = Math.min(width / cols, height / rows);
		int totalWidth = cellSize * cols;
		int totalHeight = cellSize * rows;

		int offsetX = x + (width - totalWidth) / 2;
		int offsetY = y + (height - totalHeight) / 2;

		super.setBounds(offsetX, offsetY, totalWidth, totalHeight);
	}
}
