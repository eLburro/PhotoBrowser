package panels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JToolBar;

import actions.NavigationActionListener;
import widgets.NavigationItem;

public class NavigationPanel extends JPanel {
	
	public static List<NavigationItem> navigationItemList = new ArrayList<NavigationItem>(); 

	public NavigationPanel() {
		// create the navigation item instances
		NavigationActionListener actionListener = new NavigationActionListener();
		navigationItemList.add(new NavigationItem("Family", "TODO", actionListener));
		navigationItemList.add(new NavigationItem("Vacation", "TODO", actionListener));
		navigationItemList.add(new NavigationItem("School", "TODO", actionListener));
		
		JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
		toolbar.setFloatable(false);
		
		// add toggle buttons
		for (NavigationItem item : navigationItemList) {
			toolbar.add(item.getToggleButton());
		}
	    
	    this.add(toolbar);
	}
	
	public static List<NavigationItem> getNavigationItems() {
		return navigationItemList;
	}
}