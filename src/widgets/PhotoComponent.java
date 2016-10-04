package widgets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class PhotoComponent extends JComponent {
	
	private boolean flipped = false;
	
	private Dimension imgSize;
	
	private JLabel imgLabel;
	
	private BufferedImage img;
	
	public PhotoComponent(BufferedImage img) {
		setImg(img);
		Dimension imgSize = new Dimension(img.getWidth(), img.getHeight());
		setImgSize(imgSize);
		
    	ImageIcon imgIcon = new ImageIcon(img);
        imgLabel.setIcon(imgIcon);
        this.setSize(imgSize);	
        
		imgLabel = new JLabel("Test");
		this.add(imgLabel);
	}
	
    @Override
    protected void paintComponent(Graphics g) {   
    	super.paintComponent(g);
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
