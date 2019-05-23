package view.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WheelPanel extends JPanel 
{
	// background scaling fields/objects
    private Image background;
    private Image scaledBackground;
    private double scaleCoefficient;
    private int scaleWidth;
    private int scaleHeight;
    private int x;
    private int y;
        	
	public WheelPanel() 
	{
		this.background = loadBackgroundImage();
		setBackground(new Color(0, 153, 0));
	}
	

	@Override
    public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		
		// determine scaling coefficient and dimensions from size of background image and parent component
		this.scaleCoefficient = Math.min(1, getScaleCoefficient(new Dimension(this.background.getWidth(null), this.background.getHeight(null)), getSize()));
		this.scaleWidth = (int) Math.round(this.background.getWidth(null) * this.scaleCoefficient);
		this.scaleHeight = (int) Math.round(this.background.getHeight(null) * this.scaleCoefficient);
		
		// scale the image to appropriate new size
		this.scaledBackground = this.background.getScaledInstance(this.scaleWidth, this.scaleHeight, Image.SCALE_SMOOTH);
		
		// determine where to draw image from, accounting for border pixels
		this.x = ((getWidth() -1) - this.scaledBackground.getWidth(this)) / 2;
		this.y = ((getHeight() -1) - this.scaledBackground.getHeight(this)) / 2;
		
		// paint the scaled image at the appropriate coordinates
	    g.drawImage(this.scaledBackground, this.x, this.y, this);
    }
	
	public double getScaleCoefficient(Dimension start, Dimension finish) 
	{	
		// calculate the background scaling coefficient from start and end dimension values
	    double scaleFactor = 1;
        double scaleFactorWidth = getScaleDegree(start.width, finish.width);
	    double scaleFactorHeight = getScaleDegree(start.height, finish.height);
	    scaleFactor = Math.min(scaleFactorHeight, scaleFactorWidth);
	    return scaleFactor;
	}

	// helper method for getScaleCoefficient
	public double getScaleDegree(int startSize, int targetSize) 
	{
		// calculate degree of scaling, or return neutral (1) if no change
	    double scaleFactor = 1;
	    if (startSize != targetSize) 
	    {
	    	scaleFactor = (double) targetSize / startSize;
	    }
	    return scaleFactor;
	}
	
	private Image loadBackgroundImage()
	{
		Image image = null;
		try
		{
			image = ImageIO.read(new File("Basic_roulette_wheel_1024x1024.png"));
		} 
		catch (IOException e) 
		{
		
		}
		return image;
	}
}
