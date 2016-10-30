package scene;

import scene.nodes.Node;
import scene.nodes.RootNode;

import java.awt.*;

/**
 * SceneGraph is a graphic structure to handle multiple graphical elements on a canvas.
 */
public class SceneGraph {
    private RootNode rootNode;

    public SceneGraph() {
        rootNode = new RootNode();
    }

    /**
     * Paints the whole scene graph
     *
     * @param g The 2DGraphics Context
     */
    public void paint(Graphics g) {
        rootNode.paint(g);
    }

    /**
     * Adds a child node to the scene graph
     *
     * @param node The node to add
     */
    public void addChildNode(Node node) {
        rootNode.addChildNode(node);
    }

    /**
     * Removes a child node from the scene graph
     *
     * @param node The node to remove
     */
    public void removeChildNode(Node node) {
        rootNode.getChildNodes().remove(node);
    }

    public RootNode getRootNode() {
        return rootNode;
    }
}
