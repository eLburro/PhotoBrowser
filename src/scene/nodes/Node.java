package scene.nodes;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

/**
 * Node is the base class for all the possible nodes inside a scene graph.
 * Node classes have to provide a paint method.
 */
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

    /**
     * Adds a child node.
     *
     * @param child The node to add
     */
    public void addChildNode(Node child) {
        child.setParentNode(this);
        childNodes.add(child);
    }

    /**
     * Removes a child node.
     *
     * @param child The node to remove
     */
    public void removeChildNode(Node child) {
        childNodes.remove(child);
    }

    /**
     * Paints the current node and its children.
     *
     * @param g The 2D Graphics Context
     */
    public void paint(Graphics g) {
        // paint the current node
        paintNode(g);

        // paint all the children
        for (Node child : childNodes) {
            child.paint(g);
        }
    }

    /**
     * Get the node transformation based on the parent node.
     *
     * @return A transformation
     */
    public AffineTransform getNodeTransformation() {
        if (getParentNode() != null) {
            AffineTransform parentTransform = (AffineTransform) getParentNode().getNodeTransformation().clone();
            parentTransform.concatenate(transformation);

            return parentTransform;
        } else {

            return getTransformation();
        }
    }

    /**
     * Gets the bounds of the node.
     *
     * @return Rectangle containing the bounds
     */
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

    /**
     * Painting the node.
     *
     * @param g The 2D Graphics Context
     */
    public abstract void paintNode(Graphics g);

    /**
     * Get the bounds of the node.
     *
     * @return rectangle with the node bounds.
     */
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
