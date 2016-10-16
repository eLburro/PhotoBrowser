package scene.nodes;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class LineNode extends Node {

    private Point start;
    private Point end;

    public LineNode(Node parent, Point start, Point end) {
        super(parent);

        this.start = start;
        this.end = end;
    }

    @Override
    public void paintNode(Graphics g) {
        g.setColor(getStrokeColor());
        AffineTransform transform = new AffineTransform();
        int startX = (int) transform.getTranslateX() + start.x;
        int startY = (int) transform.getTranslateX() + start.y;
        int endX = (int) transform.getTranslateX() + end.x;
        int endY = (int) transform.getTranslateX() + end.y;

        g.drawLine(startX, startY, endX, endY);
    }

    @Override
    public Rectangle getNodeBounds() {
        return new Rectangle(start, new Dimension(end.x, end.y));
    }
}
