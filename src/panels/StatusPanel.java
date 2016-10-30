package panels;

import javax.swing.*;

/**
 * South region of the PhotoBrowser application.
 * The StatusPanel shows the current actions in the PhotoBrowser.
 */
public class StatusPanel extends JPanel {

    private JLabel statusBarLabel;

    private final String DEFAULT_TEXT = "Welcome";

    public StatusPanel() {
        statusBarLabel = new JLabel();
        this.add(statusBarLabel);
        this.setDefaultText();
    }

    public void setStatusBarLabelText(String labelText) {
        statusBarLabel.setText(labelText);
    }

    public String getStatusBarLabelText() {
        return statusBarLabel.getText();
    }

    public void setDefaultText() {
        setStatusBarLabelText(DEFAULT_TEXT);
    }
}
