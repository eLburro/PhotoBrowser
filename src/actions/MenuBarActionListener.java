package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import base.PhotoBrowser;
import widgets.PhotoComponent;

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
        
        // set filters
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fc.setFileFilter(imageFilter);

        int returnVal = fc.showOpenDialog((JMenuItem) event.getSource());
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            BufferedImage img; 
            try {
				img = ImageIO.read(file);
				
				PhotoBrowser.contentPanel.removeAll();
				PhotoBrowser.contentPanel.add(new PhotoComponent(img));
				PhotoBrowser.contentPanel.revalidate();
				PhotoBrowser.contentPanel.repaint();
				
				PhotoBrowser.statusPanel.setStatusBarLabelText("Import: " + file.getName());
				
			} catch (IOException e) {
				// TODO Throw exception that image could not be loaded
			}
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
