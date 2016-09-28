package widgets;

import javax.swing.JToggleButton;

import actions.PhotoBroswerActionListener;

public class NavigationItem {
	
	private String displayName;
	
	private String description;
	
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
