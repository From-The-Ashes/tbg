package dev.blue.tbg.window.widgets.calendarPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dev.blue.tbg.calendar.Clock;

public class CalendarWidget extends JPanel {
	private final JLabel monthLabel;
	private final JPanel weekdayHeader;
	private final SquareGridPanel dayGrid;
	private final JPanel[] dayCells = new JPanel[42];
	private int currentMonth;
	private Clock clock;

	public CalendarWidget(Clock clock) {
		this.currentMonth = clock.getMonth();
		this.clock = clock;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);

		// Month name
		monthLabel = new JLabel("", SwingConstants.CENTER);
		monthLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		monthLabel.setForeground(Color.WHITE);
		monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(monthLabel);

		// Weekday header
		weekdayHeader = createWeekdayHeader();
		add(weekdayHeader);

		// Day grid
		dayGrid = new SquareGridPanel(6, 7, 2, 2);
		dayGrid.setPreferredSize(new Dimension(280, 240)); // Ensures a usable size
		setupDayCells();
		add(dayGrid);

		updateCalendar(currentMonth);
	}

	private JPanel createWeekdayHeader() {
		JPanel header = new JPanel(new GridLayout(1, 7, 2, 2));
		header.setOpaque(false);
		header.setMaximumSize(new Dimension(Integer.MAX_VALUE, 24)); // Prevents it from stretching

		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		for (String day : days) {
			JLabel label = new JLabel(day, SwingConstants.CENTER);
			label.setFont(new Font("SansSerif", Font.BOLD, 12));
			label.setForeground(Color.LIGHT_GRAY);
			header.add(label);
		}
		return header;
	}

	private void setupDayCells() {
		for (int i = 0; i < 42; i++) {
			JPanel cell = new JPanel(new BorderLayout());
			cell.setBackground(Color.LIGHT_GRAY);
			cell.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			final int index = i;

			cell.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("Clicked day " + index);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					cell.setBackground(new Color(180, 180, 255));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					cell.setBackground(Color.LIGHT_GRAY);
				}
			});

			dayCells[i] = cell;
			dayGrid.add(cell);
		}
	}

	public void updateCalendar() {
		this.currentMonth = clock.getMonth();
		int currentDay = clock.getDayOfMonth();
		int currentYear = clock.getYear();
		monthLabel.setText(clock.getMonthName() + " " + clock.getYear());

		int start = getDayOfWeek(currentDay, currentMonth+1, currentYear);
		int days = month.lengthOfMonth();

		for (int i = 0; i < 42; i++) {
			JPanel cell = dayCells[i];
			cell.removeAll();
		}

		for (int day = 1; day <= days; day++) {
			int index = start + day - 1;
			JLabel label = new JLabel(String.valueOf(day), SwingConstants.CENTER);
			label.setFont(new Font("SansSerif", Font.PLAIN, 12));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			dayCells[index].add(label, BorderLayout.CENTER);
		}

		revalidate();
		repaint();
	}

	public int getDayOfWeek(int day, int month, int year) {
		if (month < 3) {
			month += 12;
			year -= 1;
		}
		int K = year % 100;
		int J = year / 100;

		int h = (day + (13 * (month + 1)) / 5 + K + (K / 4) + (J / 4) + 5 * J) % 7;
		return h; // 0 = Saturday, 1 = Sunday, ..., 6 = Friday
	}
}
