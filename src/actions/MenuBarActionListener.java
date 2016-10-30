package actions;

import base.PhotoBrowser;
import widgets.PhotoComponent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Action listener for menu elements.
 */
public class MenuBarActionListener implements PhotoBroswerActionListener {

    @Override
    public void doAction(ActionEvent event) {
        // delegate the actions depending the triggered component
        if (event.getSource() instanceof JRadioButtonMenuItem) {
            handleViewAction(event);

        } else if (event.getSource() instanceof JMenuItem) {
            JMenuItem item = (JMenuItem) event.getSource();

            switch (item.getText()) {
                case "Import":
                    handleFileImportAction(event);
                    break;
                case "Delete":
                    handleFileDeleteAction();
                    break;
                case "Quit":
                    handleExitAction();
                    break;
            }
        }
    }

    /**
     * Imports and opens a picture into the photo canvas.
     *
     * @param event The ActionEvent
     */
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

                JScrollPane scrollPane = new JScrollPane(new PhotoComponent(img));
                scrollPane.revalidate();

                PhotoBrowser.contentPanel.removeAll();
                PhotoBrowser.contentPanel.add(scrollPane);
                PhotoBrowser.contentPanel.revalidate();
                PhotoBrowser.contentPanel.repaint();

                PhotoBrowser.statusPanel.setStatusBarLabelText("Import: " + file.getName());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Deletes the uploaded picture and sets the PhotoBrowser back to default.
     */
    private void handleFileDeleteAction() {
        PhotoBrowser.contentPanel.removeAll();
        PhotoBrowser.statusPanel.setStatusBarLabelText("Delete");
    }

    /**
     * Exit and close the PhotoViwer application.
     */
    private void handleExitAction() {
        System.exit(0);
    }

    /**
     * Switch between different view modes in the PhotoBrowser.
     *
     * @param event The ActionEvent
     */
    private void handleViewAction(ActionEvent event) {
        JRadioButtonMenuItem menuItem = (JRadioButtonMenuItem) event.getSource();

        PhotoBrowser.statusPanel.setStatusBarLabelText("View: " + menuItem.getText());
    }
}
