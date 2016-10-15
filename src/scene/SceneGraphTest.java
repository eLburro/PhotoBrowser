package scene;

import scene.nodes.RootNode;

import java.awt.*;

import javax.swing.*;

public class SceneGraphTest {

	public static void main(String[] args) {
		// create the frame
		JFrame frame = new JFrame("Scene Graph Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1200, 800));
		
		Container mainPane = frame.getContentPane();
		SceneGraphComponent component = new SceneGraphComponent();
		mainPane.add(component);
		
		// draw the canvas
		frame.pack();
        frame.setVisible(true);
	}

	private static class SceneGraphComponent extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			SceneGraph sceneGraph = new SceneGraph();
			RootNode rootNode = sceneGraph.getRootNode();

			// add other nodes

			rootNode.paint(g);
		}
	}
}
