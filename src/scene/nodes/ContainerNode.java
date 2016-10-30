package scene.nodes;

import java.awt.*;

/**
 * The ContainerNode is a node to group different child nodes together.
 * This can be used to apply transformations to a specific node group.
 */
public class ContainerNode extends Node {

    public ContainerNode(Node parent) {
        super(parent);
    }

    @Override
    public void paintNode(Graphics g) {
        // Container has no own paint
    }

    @Override
    public Rectangle getNodeBounds() {
        return null;
    }
}
