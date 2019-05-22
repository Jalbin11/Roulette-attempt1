package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.interfaces.GameEngine;

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
		background = loadBackgroundImage();
		setBackground(new Color(0, 153, 0));
	}
	

	@Override
    public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		
		// determine scaling coefficient and dimensions from size of background image and parent component
		scaleCoefficient = Math.min(1, getScaleCoefficient(new Dimension(background.getWidth(null), background.getHeight(null)), getSize()));
		scaleWidth = (int) Math.round(background.getWidth(null) * scaleCoefficient);
		scaleHeight = (int) Math.round(background.getHeight(null) * scaleCoefficient);
		
		// scale the image to appropriate new size
		scaledBackground = background.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);
		
		// determine where to draw image from, accounting for border pixels
		x = ((getWidth() -1) - scaledBackground.getWidth(this)) / 2;
		y = ((getHeight() -1) - scaledBackground.getHeight(this)) / 2;
		
		// paint the scaled image at the appropriate coordinates
	    g.drawImage(scaledBackground, x, y, this);
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
