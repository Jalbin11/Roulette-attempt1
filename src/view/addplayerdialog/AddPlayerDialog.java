package view.addplayerdialog;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AddPlayerDialog extends JFrame
{
	public AddPlayerDialog() 
	{
		// create frame and contents
		setPreferredSize(new Dimension(200, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populateComponents();
		pack();
		
		// set default window position to center of screen
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void populateComponents()
	{
		setLayout(new FlowLayout());
		
		// player detail input components
		add(new InputPanel());
	}
}
