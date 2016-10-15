package scene.nodes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Node {

    private Node parentNode;

    private List<Node> childNodes = new ArrayList<>();

    private boolean visible = true;

    // ------ CONSTRUCTOR

    public Node(Node parent) {
        this.parentNode = parent;
    }


    // ------ METHODS

    public void addChildNode(Node child) {
        childNodes.add(child);
    }

    public void removeChildNode(Node child) {
        childNodes.remove(child);
    }

    public void paint(Graphics g) {
        // paint the current node
        paintNode(g);

        // paint all the children
        for (Node child : childNodes) {
            child.paint(g);
        }
    }


    // ------- ABSTRACT METHODS

    public abstract void paintNode(Graphics g);

    public abstract Rectangle getBounds();


    // ------- GETTER AND SETTER

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<Node> childNodes) {
        this.childNodes = childNodes;
    }

}
