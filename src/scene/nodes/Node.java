package scene.nodes;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public abstract class Node {

    private Node parentNode;

    private List<Node> childNodes = new ArrayList<>();

    private boolean visible = true;

    private Color fillColor;

    private Color strokeColor;

    private AffineTransform transformation = new AffineTransform();

    // ----- CONSTRUCTOR

    public Node(Node parent) {
        if (parent != null) {
            this.fillColor = parent.getFillColor();
            this.strokeColor = parent.getStrokeColor();
        }
    }


    // ----- METHODS

    public void addChildNode(Node child) {
        child.setParentNode(this);
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

    public AffineTransform getNodeTransformation() {
        if (getParentNode() != null) {
            AffineTransform parentTransform = (AffineTransform) getParentNode().getNodeTransformation().clone();
            parentTransform.concatenate(transformation);

            return parentTransform;
        } else {

            return getTransformation();
        }
    }

    public Rectangle getBounds() {
        List<Node> branch = (ArrayList<Node>) getChildNodes();
        branch.add(this);

        Point min = new Point(0, 0);
        Point max = new Point(0, 0);
        for (Node node : branch) {
            Rectangle bounds = node.getBounds();

            if (bounds != null) {
                if (min.x > bounds.x) {
                    min.x = bounds.x;
                }

                if (min.y > bounds.y) {
                    min.y = bounds.y;
                }

                int endX = bounds.x + bounds.width;
                if (max.x > endX) {
                    max.x = endX;
                }

                int endY = bounds.y + bounds.height;
                if (max.y > endY) {
                    max.y = endY;
                }
            }
        }

        return new Rectangle(min, new Dimension(max.x, max.y));
    }


    // ----- ABSTRACT METHODS

    public abstract void paintNode(Graphics g);

    public abstract Rectangle getNodeBounds();


    // ----- GETTER AND SETTER

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

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public AffineTransform getTransformation() {
        return transformation;
    }

    public void setTransformation(AffineTransform transformation) {
        this.transformation = transformation;
    }
}
