package scene.nodes;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageNode extends Node {
    private BufferedImage img;


    public ImageNode(Node parent, Point pos, BufferedImage img) {
        super(parent);

        this.img = img;
        getNodeTransformation().setToTranslation(pos.x, pos.y);
    }

    @Override
    public void paintNode(Graphics g) {
        g.drawImage(img, getX(), getY(), img.getWidth(), img.getHeight(), null);
    }

    @Override
    public Rectangle getNodeBounds() {
        Point startPos = new Point(getX(), getY());
        Dimension dimension = new Dimension(img.getWidth(), img.getHeight());
        return new Rectangle(startPos, dimension);
    }

    public int getX() {
        return (int) getNodeTransformation().getTranslateX();
    }

    public int getY() {
        return (int) getNodeTransformation().getTranslateY();
    }

}
