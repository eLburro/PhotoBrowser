package widgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PhotoComponent extends JPanel {
	
	private boolean flipped = false;
	
	private Dimension imgSize;
	
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
    	
    	// draw a background
    	g2.setColor(Color.black);
    	g2.fillRect(0, 0, getWidth(), getHeight());
    	
    	//g2.drawImage(img, 0, 0, null);
    }

	@Override
	public Dimension getPreferredSize() {
		return (img != null) ? imgSize : new Dimension(400, 400);
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

	public Dimension getImgSize() {
		return imgSize;
	}

	public void setSizes(int width, int height) {
		this.imgSize = new Dimension(width, height);
		//this.setSize(imgSize);
		
		int minWidth = (width < MIN_WIDTH) ? MIN_WIDTH : width;
		int minfHeight = (height < MIN_HEIGHT) ? MIN_HEIGHT : height;
		this.setMinimumSize(new Dimension(minWidth, minfHeight));
	}
	
}
