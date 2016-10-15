package scene.nodes;

import java.awt.*;
import java.util.ArrayList;

public class PathNode extends Node {

    private ArrayList<Line> pathArray = new ArrayList<>();

    public PathNode(Node parent) {
        super(parent);
    }

    public void addLine(Point startPoint, Point endPoint) {
        pathArray.add(new Line(startPoint, endPoint));
    }

    @Override
    public void paintNode(Graphics g) {
        // TODO paint pathPointArray
        int currX = 0;
        int currY = 0;
        int lastX = 0;
        int lastY = 0;
    }

    @Override
    public Rectangle getBounds() {
        // TODO
        return null;
    }

    private class Line {

        private Point start;
        private Point end;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

    }

}
