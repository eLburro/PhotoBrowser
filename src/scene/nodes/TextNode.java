package scene.nodes;

import java.awt.*;

public class TextNode extends Node {
    private StringBuffer text = new StringBuffer("");

    private Graphics textGraphics;

    public TextNode(Node parent, Point pos, Graphics g) {
        super(parent);

        getNodeTransformation().setToTranslation(pos.x, pos.y);
        textGraphics = g;
    }

    public int getX() {
        return (int) getNodeTransformation().getTranslateX();
    }

    public int getY() {
        return (int) getNodeTransformation().getTranslateY();
    }

    public void appendChar(char c) {
        this.text.append(c);
    }

    @Override
    public void paintNode(Graphics g) {
        g.setColor(getStrokeColor());
        g.drawString(getText(), getX(), getY());
    }

    @Override
    public Rectangle getNodeBounds() {
        Point startPos = new Point(getX(), getY());
        Dimension dimension = new Dimension(getX() + textGraphics.getFontMetrics().stringWidth(getText()), getY() + 20);
        return new Rectangle(startPos, dimension);
    }

    public String getText() {
        return text.toString();
    }

    public void setText(String text) {
        this.text = new StringBuffer(text);
    }
}
