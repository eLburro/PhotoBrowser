package actions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import base.PhotoBrowser;

public class MenuBarActionListener implements PhotoBroswerActionListener {

	@Override
	public void doAction(ActionEvent event) {
		// delegate the actions depending the triggered component
		if (event.getSource() instanceof JRadioButtonMenuItem) {
			handleViewAction(event);
			
		} else if (event.getSource() instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) event.getSource();
			
			switch (item.getText()) {
				case "Import": handleFileImportAction(event); break;
				case "Delete": handleFileDeleteAction(); break;
				case "Quit": handleExitAction(); break;
			}
		}
	}
	
	private void handleFileImportAction(ActionEvent event) {
		final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog((JMenuItem) event.getSource());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            // TODO: What ever we want to do with the file
            PhotoBrowser.statusPanel.setStatusBarLabelText("Import: " + file.getName());
        }
	}
	
	private void handleFileDeleteAction() {
		PhotoBrowser.statusPanel.setStatusBarLabelText("Delete");
	}
	
	private void handleExitAction() {
		// TODO: Maybe save some states?
		 System.exit(0);
	}
	
	private void handleViewAction(ActionEvent event) {
		JRadioButtonMenuItem menuItem = (JRadioButtonMenuItem) event.getSource();
		// TODO: Switch case to further define the action
		PhotoBrowser.statusPanel.setStatusBarLabelText("View: " + menuItem.getText());
	}
}
