package panels;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

import actions.MenuBarActionListener;
import utils.WidgetUtils;

public class MenuBar extends JMenuBar {

	public MenuBar() {
		MenuBarActionListener actionListener = new MenuBarActionListener();
		
		// File menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(WidgetUtils.createMenuItem("Import", "Import a file from your computer", actionListener));
		fileMenu.add(WidgetUtils.createMenuItem("Delete", "Delete a file?", actionListener));
		fileMenu.add(WidgetUtils.createMenuItem("Quit", "Exit the application", actionListener));
		this.add(fileMenu);
		
		// View menu
		JMenu viewMenu = new JMenu("View");
		JRadioButtonMenuItem photoViewerMenuItem = WidgetUtils.createRadioButtonMenuItem("Photo Viewer", "TODO", actionListener);
		JRadioButtonMenuItem browserMenuItem = WidgetUtils.createRadioButtonMenuItem("Browser", "TODO", actionListener);
		JRadioButtonMenuItem splitModeMenuItem = WidgetUtils.createRadioButtonMenuItem("Split Mode", "TODO", actionListener);
		
		ButtonGroup viewGroup = new ButtonGroup();
		viewGroup.add(photoViewerMenuItem);
		viewGroup.add(browserMenuItem);
		viewGroup.add(splitModeMenuItem);
				
		viewMenu.add(photoViewerMenuItem);
		viewMenu.add(browserMenuItem);
		viewMenu.add(splitModeMenuItem);

		this.add(viewMenu);
	}
}
