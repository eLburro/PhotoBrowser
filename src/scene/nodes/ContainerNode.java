package scene.nodes;

import java.awt.*;

public class ContainerNode extends Node {

    public ContainerNode(Node parent) {
        super(parent);
    }

    @Override
    public void paintNode(Graphics g) {
        // Container has no own paint
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
