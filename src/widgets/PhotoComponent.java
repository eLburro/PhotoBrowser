package widgets;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PhotoComponent extends JPanel {
	
	private boolean flipped = false;
	
	private Dimension imgSize;
	
	private BufferedImage img;
	
	public PhotoComponent(BufferedImage bufferedImg) {
		setImg(bufferedImg);
		
		setImgSize(new Dimension(img.getWidth(), img.getHeight()));
		
		this.setSize(imgSize);	
	}
	
    @Override
    protected void paintComponent(Graphics g) {   
    	super.paintComponent(g);
    	
    	Graphics2D g2 = (Graphics2D) g;
    	
    	g2.drawImage(img, 0, 0, this);
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

	public void setImgSize(Dimension imgSize) {
		this.imgSize = imgSize;
	}
	
}
