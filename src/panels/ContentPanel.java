package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ContentPanel extends JPanel {
	
	public ContentPanel() {		
		// add a border
		this.setBorder(LineBorder.createGrayLineBorder());
		
		JLabel placeholderText = new JLabel("Placeholder Content");
		this.add(placeholderText);
	}

}
