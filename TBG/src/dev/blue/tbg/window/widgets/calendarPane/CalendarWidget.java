package dev.blue.tbg.window.widgets.calendarPane;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import dev.blue.tbg.calendar.Clock;

public class CalendarWidget extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JLabel monthLabel;
	private final SquareGridPanel dayGrid;
	private final JCell[] dayCells = new JCell[42];
	private final GridBagConstraints bordergbc;
	private final Font cellFont;
	private final Color cellBG = new Color(80, 80, 80);
	private final Color cellFG = new Color(200, 200, 200);
	private Clock clock;
	private int currentMonth;
	private int columns = 7, rows = 6;

	public CalendarWidget(Clock clock) {
		this.clock = clock;
		this.currentMonth = clock.getMonth();
		this.cellFont = new Font("SansSerif", Font.PLAIN, 12);

		// Layout for this widget
		setLayout(new GridBagLayout());
		setOpaque(false);

		// GridBagConstraints for this widget's container
		this.bordergbc = new GridBagConstraints();
		this.bordergbc.fill = GridBagConstraints.BOTH;
		this.bordergbc.gridx = 0;
		this.bordergbc.gridy = 0;
		this.bordergbc.weightx = 1;
		this.bordergbc.weighty = 1;
		this.bordergbc.insets = new Insets(2, 2, 2, 2);

		// Month label
		monthLabel = new JLabel("", SwingConstants.CENTER);
		monthLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		monthLabel.setForeground(Color.WHITE);

		GridBagConstraints gbcMonth = new GridBagConstraints();
		gbcMonth.gridx = 0;
		gbcMonth.gridy = 0;
		gbcMonth.weightx = 1;
		gbcMonth.weighty = 0.1;
		gbcMonth.fill = GridBagConstraints.BOTH;
		add(monthLabel, gbcMonth);

		// Grid of days
		dayGrid = new SquareGridPanel(rows+1, columns, 2, 2);
		dayGrid.setPreferredSize(calculatePreferredGridSize(cellFont));
		setupDayCells();

		GridBagConstraints gbcGrid = new GridBagConstraints();
		gbcGrid.gridx = 0;
		gbcGrid.gridy = 1;
		gbcGrid.weightx = 1;
		gbcGrid.weighty = 0.9;
		gbcGrid.fill = GridBagConstraints.BOTH;
		add(dayGrid, gbcGrid);

		update();
	}

	public GridBagConstraints getConstraints() {
		return bordergbc;
	}

	private Dimension calculatePreferredGridSize(Font font) {
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		FontMetrics metrics = getFontMetrics(font);
		int cellWidth = 0;
		for (String day : days) {
			cellWidth = Math.max(cellWidth, metrics.stringWidth(day));
		}
		int cellHeight = metrics.getHeight() + 12;
		return new Dimension(cellWidth * columns, cellHeight * (rows+1));
	}

	private void setupDayCells() {
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

		for (String day : days) {
			JPanel headerCell = new JPanel(new BorderLayout());
			headerCell.setOpaque(false);
			JLabel label = new JLabel(day, SwingConstants.CENTER);
			label.setFont(cellFont);
			label.setForeground(cellFG);
			headerCell.add(label, BorderLayout.CENTER);
			dayGrid.add(headerCell);
		}

		for (int i = 0; i < columns*rows; i++) {
			JCell cell = new JCell(cellFont, "");
			cell.setBackground(cellBG);
			cell.setBorder(null);
			cell.setColor(cellFG);

			cell.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (!cell.getValue().isEmpty()) {
						System.out.println("Clicked day " + cell.getValue());
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					if (!cell.getValue().isEmpty()) {
						cell.setBackground(cellFG);
						cell.setColor(cellBG);
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (!cell.getValue().isEmpty()) {
						cell.setBackground(cellBG);
						cell.setColor(cellFG);
					}
				}
			});

			dayCells[i] = cell;
			dayGrid.add(cell);
		}
	}

	public void update() {
		if (clock.dayLapse() || clock.getTimeRaw() <= 1) {
			this.currentMonth = clock.getMonth();
			int currentDay = clock.getDayOfMonth();
			int currentYear = clock.getYear();
			monthLabel.setText(clock.getMonthName() + ", " + clock.getYear());

			int start = getDayOfWeek(1, currentMonth + 1, currentYear);
			int days = clock.daysThisMonth();

			// Clear all cells
			for (JCell cell : dayCells) {
				cell.setValue("");
				cell.setSelected(false);
			}

			// Populate active days
			for (int day = 1; day <= days; day++) {
				int index = start + day - 1;
				dayCells[index].setValue("" + day);
				if (day == currentDay) {
					dayCells[index].setSelected(true);
				}
			}
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
