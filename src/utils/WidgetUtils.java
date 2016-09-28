package utils;

import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import actions.PhotoBroswerActionListener;

public final class WidgetUtils {
	
	public static JMenuItem createMenuItem(String displayText, String toolTip, PhotoBroswerActionListener actionListener) {
		JMenuItem item = new JMenuItem(displayText);
		item.setToolTipText(toolTip);
		item.addActionListener(event -> actionListener.doAction(event));
		
		return item;
	}

	public static JRadioButtonMenuItem createRadioButtonMenuItem(String displayText, String toolTip, PhotoBroswerActionListener actionListener) {
		JRadioButtonMenuItem item = new JRadioButtonMenuItem(displayText);
		item.setToolTipText(toolTip);
		item.addActionListener(event -> actionListener.doAction(event));
		
		return item;
	}
}
