package widgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PhotoComponent extends JPanel {
	
	private boolean flipped = false;
	
	private BufferedImage img;
	
	private final int MIN_WIDTH = 800;
	
	private final int MIN_HEIGHT = 600;
	
	public PhotoComponent(BufferedImage bufferedImg) {
		setImg(bufferedImg);

		setSizes(img.getWidth(), img.getHeight());
	}
	
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	Graphics2D g2 = (Graphics2D) g;
    	
    	// draw a background on 100% width and height
    	g2.setColor(Color.black);
    	g2.fillRect(0, 0, 2000, 1000);

		// draw an image in the middle of the panel
    	g2.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
    }
	
	public boolean isFlipped() {
		return flipped;
	}

	public void setFlipped(boolean flipped) {
		this.flipped = flipped;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	private void setSizes(int width, int height) {
		int prefWidth = (width < MIN_WIDTH) ? MIN_WIDTH : width;
		int prefHeight = (height < MIN_HEIGHT) ? MIN_HEIGHT : height;

		Dimension prefSize = new Dimension(prefWidth, prefHeight);
		this.setSize(prefSize);
		this.setPreferredSize(prefSize);
	}
	
}
