package dev.blue.tbg.window.widgets.calendarPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dev.blue.tbg.calendar.Clock;

public class CalendarWidget extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JLabel monthLabel;
	private GridBagConstraints bordergbc;
	private final SquareGridPanel dayGrid;
	private final JCell[] dayCells = new JCell[42];
	private int currentMonth;
	private Clock clock;
	private Font cellFont;
	private Color cellBG;
	private Color cellFG;

	public CalendarWidget(Clock clock) {
		this.currentMonth = clock.getMonth();
		this.clock = clock;
		
		this.cellBG = new Color(80, 80, 80);
		this.cellFG = new Color(200, 200, 200);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);

		monthLabel = new JLabel("", SwingConstants.CENTER);
		monthLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		monthLabel.setForeground(Color.WHITE);
		monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(monthLabel);

		dayGrid = new SquareGridPanel(7, 7, 2, 2);
		dayGrid.setPreferredSize(calculatePreferredGridSize(cellFont = new Font("SansSerif", Font.PLAIN, 12)));
		setupDayCells();
		add(dayGrid);
		
		this.bordergbc = new GridBagConstraints();
		this.bordergbc.fill = GridBagConstraints.BOTH;
		this.bordergbc.gridx = 0; this.bordergbc.gridy = 0;
		this.bordergbc.weightx = 0;
		this.bordergbc.weighty = 1;

		update();
	}
	
	public GridBagConstraints getConstraints() {
		return bordergbc;
	}
	
	private Dimension calculatePreferredGridSize(Font font) {
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	    String longestLabel = days[0];
	    FontMetrics metrics = getFontMetrics(font);
	    for(int i = 0; i < days.length; i++) {
	    	if(metrics.stringWidth(days[i]) > metrics.stringWidth(longestLabel)) {
	    		longestLabel = days[i];
	    	}
	    }
	    
	    int cellWidth = metrics.stringWidth(longestLabel)*2;
	    int cellHeight = metrics.getHeight() + 12;

	    return new Dimension(cellWidth * 7, cellHeight * 7);
	}

	private void setupDayCells() {
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

		for (int i = 0; i < 7; i++) {
			JPanel headerCell = new JPanel(new BorderLayout());
			headerCell.setOpaque(false);
			JLabel label = new JLabel(days[i], SwingConstants.CENTER);
			label.setFont(cellFont);
			label.setForeground(cellFG);
			headerCell.add(label, BorderLayout.CENTER);
			dayGrid.add(headerCell);
		}

		for (int i = 7; i < 49; i++) {//Skips the header
			JCell cell = new JCell(cellFont, "");
			cell.setBackground(cellBG);
			cell.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			cell.setFont(cellFont);
			cell.setColor(cellFG);

			cell.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(cell.getValue() != "") {
						System.out.println("Clicked day " + cell.getValue());
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					if(cell.getValue() != "") {
						cell.setBackground(cellFG);
						cell.setColor(cellBG);
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if(cell.getValue() != "") {
						cell.setBackground(cellBG);
						cell.setColor(cellFG);
					}
				}
			});

			dayCells[i - 7] = cell;
			dayGrid.add(cell);
		}
	}

	public void update() {
		this.currentMonth = clock.getMonth();
		int currentDay = clock.getDayOfMonth();
		int currentYear = clock.getYear();
		monthLabel.setText(clock.getMonthName() + " " + clock.getYear());

		int start = getDayOfWeek(currentDay, currentMonth + 1, currentYear);
		int days = clock.daysThisMonth();

		for (int day = 1; day <= days; day++) {
			int index = start + day - 1;
			
			dayCells[index].setValue(""+day);
		}
	}

	public int getDayOfWeek(int day, int month, int year) {
		if (month < 3) {
			month += 12;
			year -= 1;
		}
		int K = year % 100;
		int J = year / 100;

		int h = (day + (13 * (month + 1)) / 5 + K + (K / 4) + (J / 4) + 5 * J) % 7;
		return h; // 0 = Saturday
	}
}
