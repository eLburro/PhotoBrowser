package widgets;

import scene.SceneGraph;
import scene.nodes.LineNode;
import scene.nodes.PathNode;
import scene.nodes.TextNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class PhotoComponent extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

    // ----- CONSTANTS

    private final int MIN_WIDTH = 800;

    private final int MIN_HEIGHT = 600;


    // ----- MEMBERS

    private boolean flipped = false;

    private BufferedImage img;

    // scene graph helpers
    SceneGraph scene = new SceneGraph();

    TextNode textNode;

    PathNode pathNode;

    private Point lastPos = new Point();


    // ----- CONSTRUCTOR

    public PhotoComponent(BufferedImage bufferedImg) {
        setImg(bufferedImg);

        setSizes(img.getWidth(), img.getHeight());

        scene = new SceneGraph();

        // add event listeners
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
    }


    // ----- METHODS
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (flipped) {
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, 2000, 1000);

            scene.paint(g2);

        } else {
            // draw a background on 100% width and height
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, 2000, 1000);

            // draw an image in the middle of the panel
            g2.drawImage(img, 0, 0, null);
        }

        revalidate();
        repaint();
    }

    private void setSizes(int width, int height) {
        int prefWidth = (width < MIN_WIDTH) ? MIN_WIDTH : width;
        int prefHeight = (height < MIN_HEIGHT) ? MIN_HEIGHT : height;

        Dimension prefSize = new Dimension(prefWidth, prefHeight);
        this.setSize(prefSize);
        this.setPreferredSize(prefSize);
    }


    // ----- Event Listeners

    @Override
    public void mouseDragged(MouseEvent e) {
        if (flipped && pathNode != null) {
            Point currPos = new Point(e.getX(), e.getY());
            Point startPos = new Point(lastPos.x, lastPos.y);
            Point endPos = new Point(currPos.x, currPos.y);

            pathNode.addLineNode(new LineNode(pathNode, startPos, endPos));

            lastPos = currPos;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (flipped && e.getClickCount() == 1) {
            Point pos = new Point(e.getX(), e.getY());
            textNode = new TextNode(scene.getRootNode(), pos, getGraphics());
            textNode.setStrokeColor(Color.BLACK);
            scene.addChildNode(textNode);

        } else {
            // switch from photo view annotation view and vise versa
            flipped = !flipped;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (flipped) {
            requestFocus();

            lastPos.x = e.getX();
            lastPos.y = e.getY();

            pathNode = new PathNode(scene.getRootNode(), lastPos);
            pathNode.setStrokeColor(Color.RED);
            scene.addChildNode(pathNode);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (flipped && textNode != null) {
            textNode.appendChar(e.getKeyChar());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    // ----- GETTER & SETTER

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
