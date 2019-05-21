package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WheelPanel extends JPanel {

	private JLabel background;
	
	public WheelPanel() {
		background = new JLabel(loadBackgroundImage());
	}

	private ImageIcon loadBackgroundImage()
	{
		ImageIcon image = null;
		try
		{
			image = new ImageIcon("Basic_roulette_wheel_1024x1024.png");
		} 
		catch (Exception e) 
		{
		
		}
		return image;
	}
}
