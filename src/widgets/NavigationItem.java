package widgets;

import javax.swing.JToggleButton;

import actions.PhotoBroswerActionListener;

/**
 * A Navigation Item contains a JToggleButton, a button too tip and the an Action.
 */
public class NavigationItem {
	
	private JToggleButton navigationItem;
	
	public NavigationItem(String displayName, String description, PhotoBroswerActionListener actionListener) {
		this.navigationItem = new JToggleButton(displayName);
		this.navigationItem.setToolTipText(description);
		this.navigationItem.addActionListener(event -> actionListener.doAction(event));
	}

	public JToggleButton getToggleButton() {
		return navigationItem;
	}
}
