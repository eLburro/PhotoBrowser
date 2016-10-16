package scene;

import scene.nodes.Node;
import scene.nodes.RootNode;

import javax.swing.*;
import java.awt.*;

public class SceneGraph {
    private RootNode rootNode;

    public SceneGraph() {
        rootNode = new RootNode();
    }

    public void paint(Graphics g) {
        rootNode.paint(g);
    }

    public void addChildNode(Node node) {
        rootNode.addChildNode(node);
    }

    public void removeChildNode(Node node) {
        rootNode.getChildNodes().remove(node);
    }

    public RootNode getRootNode() {
        return rootNode;
    }
}
