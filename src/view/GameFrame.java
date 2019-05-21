package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame
{
	
	public GameFrame() 
	{	
		// create frame and contents
		super("Wheelgame - Assignment 2");
		setPreferredSize(new Dimension(1200, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populateComponents();
		pack();
		// set default window position to center of screen
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void populateComponents()
	{
		setLayout(new BorderLayout());
		add(new SummaryPanel(), BorderLayout.NORTH);
		add(new WheelPanel(), BorderLayout.CENTER);
		add(new StatusBarPanel(), BorderLayout.SOUTH);
	}

}
