package scene;

import scene.nodes.RootNode;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SceneGraph {
	private RootNode rootNode;
	
	public SceneGraph() {
		rootNode = new RootNode();
	}

	public RootNode getRootNode() {
		return rootNode;
	}
}
