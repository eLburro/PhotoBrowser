package scene;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

}
