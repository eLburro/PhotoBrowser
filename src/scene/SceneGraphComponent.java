package scene;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SceneGraphComponent extends JPanel {
	private RootNode root;
	
	public SceneGraphComponent() {
		root = new RootNode(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	
}
