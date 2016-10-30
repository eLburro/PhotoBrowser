package scene.nodes;

import java.awt.*;

/**
 * The PathNode is a collection of multiple LineNode strokes.
 */
public class PathNode extends Node {

    public PathNode(Node parent, Point pos) {
        super(parent);

        getNodeTransformation().setToTranslation(pos.x, pos.y);
    }

    @Override
    public void addChildNode(Node child) {
        if (child instanceof LineNode) {
            addLineNode((LineNode) child);
        }
    }

    public void addLineNode(LineNode node) {
        node.setParentNode(this);
        getChildNodes().add(node);
    }

    @Override
    public void paintNode(Graphics g) {
        for (Node node : getChildNodes()) {
            LineNode line = (LineNode) node;
            line.paintNode(g);
        }
    }

    @Override
    public Rectangle getNodeBounds() {
        return null;
    }
}
