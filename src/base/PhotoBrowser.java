package base;

import panels.ContentPanel;
import panels.MenuBar;
import panels.NavigationPanel;
import panels.StatusPanel;

import javax.swing.*;
import java.awt.*;

/**
 * PhotoBrowser Application
 * Application to display images and draw annotations on them.
 */
public class PhotoBrowser {

    private static final String WINDOW_NAME = "eL burro's Photo Browser";

    private MenuBar menuBarPanel;

    public static ContentPanel contentPanel;

    private NavigationPanel navigationPanel;

    public static StatusPanel statusPanel = new StatusPanel();

    public PhotoBrowser() {
        menuBarPanel = new MenuBar();
        navigationPanel = new NavigationPanel();
        contentPanel = new ContentPanel();
    }

    /**
     * Draws the structure of the PhotoBrowser.
     */
    public void drawCanvas() {
        // create the frame
        JFrame frame = new JFrame(WINDOW_NAME);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1200, 800));

        // create a border layout to split the UI into different parts
        Container mainPane = frame.getContentPane();
        mainPane.setLayout(new BorderLayout());

        // NORTH: create the menu bar in the north region
        mainPane.add(menuBarPanel, BorderLayout.NORTH);

        // WEST: create the navigation menu in the west region
        mainPane.add(navigationPanel, BorderLayout.WEST);

        // CENTER: content area
        mainPane.add(contentPanel, BorderLayout.CENTER);

        // SOUTH: create the status bar in the south
        mainPane.add(statusPanel, BorderLayout.SOUTH);

        // draw the canvas
        frame.pack();
        frame.setVisible(true);
    }
}
