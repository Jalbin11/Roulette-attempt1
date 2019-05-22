package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class GameFrame extends JFrame
{
	public GameFrame(GameEngine gameEngine) 
	{	
		super("WheelGameGUI - Assignment 2");
		
		// set default look and feel before initialising any components
		setUILookAndFeel(new javax.swing.plaf.FontUIResource("Segoe UI Semibold", Font.PLAIN,12));;

		// create frame and contents
		setPreferredSize(new Dimension(1200, 1000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populateComponents(gameEngine, this);
		pack();
		
		// set default window position to center of screen
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void populateComponents(GameEngine gameEngine, GameFrame gameFrame)
	{
		setLayout(new BorderLayout());
		
		// maintain reference to model (gameEngine) and view (gameFrame) 
		// for relevant children view components
		
		// drop down menu, player stats and toolbar
		add(new SummaryPanel(gameEngine, gameFrame), BorderLayout.NORTH);
	
		// bottom-of-screen status bar
		add(new StatusBarPanel(gameEngine, gameFrame), BorderLayout.SOUTH);
		
		// main game wheel
		add(new WheelPanel(), BorderLayout.CENTER);
	}
	
	private void setUILookAndFeel(javax.swing.plaf.FontUIResource f)
	{
		// change default look and feet to system style
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) 
		{
			e.printStackTrace();
		}
		
		// change default UI font styling
	    Enumeration<Object> keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements()) {
	      Object key = keys.nextElement();
	      Object value = UIManager.get (key);
	      if (value instanceof javax.swing.plaf.FontUIResource)
	        UIManager.put (key, f);
	      }
	    }

}
