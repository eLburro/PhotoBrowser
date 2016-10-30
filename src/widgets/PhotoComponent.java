package widgets;

import scene.SceneGraph;
import scene.nodes.ImageNode;
import scene.nodes.LineNode;
import scene.nodes.PathNode;
import scene.nodes.TextNode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * PhotoComponent draws an image to the canvas.
 * It allows to add annotations to the back of the image.
 */
public class PhotoComponent extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

    // ----- CONSTANTS

    private final int MIN_WIDTH = 800;
    private final int MIN_HEIGHT = 600;

    private final String BACKGROUND_TILE_PATH = "./res/tile.jpg";

    // ----- MEMBERS

    private boolean flipped = false;

    private BufferedImage img;

    private BufferedImage tileImg;

    // scene graph helpers
    private SceneGraph scene = new SceneGraph();

    private TextNode textNode;

    private PathNode pathNode;

    private Point lastPos = new Point();


    // ----- CONSTRUCTOR

    public PhotoComponent(BufferedImage bufferedImg) {
        img = bufferedImg;
        loadBackgroundImg();
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

        // draw a background
        createBackground(g2);

        if (flipped) {
            // annotation canvas
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, img.getWidth(), img.getHeight());
            this.setBounds(0, 0, img.getWidth(), img.getHeight());

            scene.paint(g2);

        } else {
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
        this.setPreferredSize(prefSize);
    }

    private void loadBackgroundImg() {
        try {
            tileImg = ImageIO.read(new File(BACKGROUND_TILE_PATH));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createBackground(Graphics2D g2) {
        int tileWidth = tileImg.getWidth();
        int tileHeight = tileImg.getHeight();

        if (tileWidth > 0 && tileHeight > 0) {
            for (int x = 0; x < getWidth(); x += tileWidth) {
                for (int y = 0; y < getHeight(); y += tileHeight) {
                    g2.drawImage(tileImg, x, y, tileWidth, tileHeight, this);
                }
            }
        }
    }

    // ----- Annotations
    private void addLine(MouseEvent e) {
        Point currPos = new Point(e.getX(), e.getY());
        Point startPos = new Point(lastPos.x, lastPos.y);
        Point endPos = new Point(currPos.x, currPos.y);

        pathNode.addLineNode(new LineNode(pathNode, startPos, endPos));

        lastPos = currPos;
    }

    private void createText(MouseEvent e) {
        Point pos = new Point(e.getX(), e.getY());
        textNode = new TextNode(scene.getRootNode(), pos, getGraphics());
        textNode.setStrokeColor(Color.BLACK);
        scene.addChildNode(textNode);
    }

    private void createAnnotation(MouseEvent e) {
        try {
            BufferedImage bufImg = ImageIO.read(new File("./res/annotations/smiley_1.jpg"));
            ImageNode imgNode = new ImageNode(scene.getRootNode(), lastPos, bufImg);
            scene.addChildNode(imgNode);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void createPath(MouseEvent e) {
        requestFocus();

        lastPos.x = e.getX();
        lastPos.y = e.getY();

        pathNode = new PathNode(scene.getRootNode(), lastPos);
        pathNode.setStrokeColor(Color.RED);
        scene.addChildNode(pathNode);
    }


    // ----- Event Listeners

    @Override
    public void mouseDragged(MouseEvent e) {
        if (flipped) {

            if (pathNode == null) {
                createPath(e);
            }

            addLine(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (flipped && e.isControlDown()) {
            createAnnotation(e);

        } else if (flipped && e.getClickCount() == 1) {
            createText(e);

        } else if (e.getClickCount() == 2) {
            // switch from photo view annotation view and vise versa
            flipped = !flipped;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key != KeyEvent.VK_CONTROL) {

            if (flipped && textNode != null) {
                textNode.appendChar(e.getKeyChar());
            }
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
        pathNode = null;
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
}
