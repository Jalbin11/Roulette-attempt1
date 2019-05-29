package view.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.interfaces.Slot;

@SuppressWarnings("serial")
public class WheelPanel extends JPanel 
{
    private Image background;
    private Image scaledBackground;
    private Slot currentSlot;
    private Color bgColour = new Color(0, 153, 0);
    private Color ballColour = new Color(255, 204, 0);
    
    private double scaleCoefficient;
    private int scaleWidth;
    private int scaleHeight;
    private double factor;
    private double factorWidth;
    private double factorHeight;
    private int backGroundX;
    private int backGroundY;
    
    private final double RADIUS_ADJUST = 0.92; 
    private final double DEGREES = 360.d; 
    private final double DEGREE_ADJUST = 80.52631; 
    private final int BALL_DIAMETER = 20;
    private double ballX;
    private double ballY;
    private double angle;
    private double radius;
    private double centerX;
    private double centerY;
        	    
	public WheelPanel() 
	{
		background = loadBackgroundImage();
		setBackground(bgColour);
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
		scaledBackground = this.background.getScaledInstance(this.scaleWidth, this.scaleHeight, Image.SCALE_SMOOTH);
		
		// determine where to draw image from, accounting for border pixels
		backGroundX = ((getWidth() -1) - this.scaledBackground.getWidth(this)) / 2;
		backGroundY = ((getHeight() -1) - this.scaledBackground.getHeight(this)) / 2;
		
		// paint the scaled image at the appropriate coordinates
	    g.drawImage(this.scaledBackground, backGroundX, backGroundY, this);
	    
	    // draw the ball
	    drawBall(g);
    }
	
	private void drawBall(Graphics g)
	{	
		if (currentSlot != null)
		{
			// derive adjusted radius from scaledBackground size
			radius = (((scaledBackground.getHeight(null) / 2) + (scaledBackground.getHeight(null) / 2)) / 2) * RADIUS_ADJUST;

			// get center of scaledBackground
			centerX = backGroundX + this.scaledBackground.getWidth(this) / 2;
			centerY = backGroundY + this.scaledBackground.getHeight(this) / 2;
 
			// find theta as radians, adjusting for wheel orientation
			angle = Math.toRadians(currentSlot.getPosition() * (DEGREES / Slot.WHEEL_SIZE) - DEGREE_ADJUST);
			
			// translate co-ords
			ballX = radius * Math.cos(angle) + centerX;
			ballY = radius * Math.sin(angle) + centerY;
			
			// draw ball at new position, adjusting for width of ball
			g.setColor(ballColour);
			g.drawOval((int)ballX - BALL_DIAMETER / 2, (int) ballY - BALL_DIAMETER / 2, BALL_DIAMETER, BALL_DIAMETER);	
		    g.fillOval((int)ballX - BALL_DIAMETER / 2, (int) ballY - BALL_DIAMETER / 2, BALL_DIAMETER, BALL_DIAMETER);	
		}
	}

	public void updateBallPosition(Slot slot)
	{
		// increment slot
		currentSlot = slot;
	}
	
	public double getScaleCoefficient(Dimension start, Dimension finish) 
	{	
		// calculate the background scaling coefficient from start and finish dimension values
	    factor = 1;
        factorWidth = getScaleDegree(start.width, finish.width);
	    factorHeight = getScaleDegree(start.height, finish.height);
	    factor = Math.min(factorHeight, factorWidth);
	    return factor;
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
