package panels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Center region of the PhotoBrowser application.
 * The ContentPanel is the main canvas of the PhotoBrowser.
 */
public class ContentPanel extends JPanel {

    public ContentPanel() {
        this.setLayout(new BorderLayout());

        // add a border
        this.setBorder(LineBorder.createGrayLineBorder());
    }

}
