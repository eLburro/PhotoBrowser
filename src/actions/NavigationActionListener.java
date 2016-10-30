package actions;

import base.PhotoBrowser;
import panels.NavigationPanel;
import widgets.NavigationItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Action listener for navigation elements.
 */
public class NavigationActionListener implements PhotoBroswerActionListener {

	@Override
	public void doAction(ActionEvent event) {
		List<String> selectedItems = new ArrayList<String>();
		
		// check which elements are active and update the content
		for (NavigationItem item : NavigationPanel.getNavigationItems()) {
			JToggleButton button = item.getToggleButton();
			
			if (button.isSelected()) {
				selectedItems.add(button.getText());
			}
		}
		
		if (!selectedItems.isEmpty()) {
			PhotoBrowser.statusPanel.setStatusBarLabelText("Navigation selected: " + selectedItems.toString());
		} else {
			PhotoBrowser.statusPanel.setDefaultText();
		}
	}
}
