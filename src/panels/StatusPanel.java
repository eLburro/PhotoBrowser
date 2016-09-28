package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel {
	
	private JLabel statusBarLabel;
	
	private final String DEFAULT_TEXT = "South";

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
