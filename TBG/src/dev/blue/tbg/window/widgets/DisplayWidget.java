package dev.blue.tbg.window.widgets;

import dev.blue.tbg.Action;
import dev.blue.tbg.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayWidget extends JPanel {
	private static final long serialVersionUID = 1L;
	private List<Action> actives = new ArrayList<Action>();
	private final List<Pair<JLabel, JLabel>> entries = new ArrayList<>();
    private final JPanel container;

    public DisplayWidget() {
        setLayout(new BorderLayout());

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        add(container, BorderLayout.CENTER);
    }

    public void addEntry(String labelText, Action action) {
        JLabel label = new JLabel(labelText);
        JLabel bar = new JLabel("0%");

        entries.add(new Pair<>(label, bar));
        container.add(label);
        container.add(bar);
    }

    public void removeEntry(int index) {
        if (index >= 0 && index < entries.size()) {
            Pair<JLabel, JLabel> pair = entries.remove(index);
            container.remove(pair.A());
            container.remove(pair.B());
            revalidate();
            repaint();
        }
    }
    
    public Action getEntry(int index) {
    	return actives.get(index);
    }

    public List<Pair<JLabel, JLabel>> getEntries() {
        return entries;
    }
}
