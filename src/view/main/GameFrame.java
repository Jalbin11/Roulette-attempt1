package view.main;

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
	private StatusBarPanel statusBarPanel;
	private WheelPanel wheelPanel;
	private SummaryPanel summaryPanel;
	
	public GameFrame(GameEngine gameEngine) 
	{	
		super("WheelGameGUI - Assignment 2");
		
		// set default look and feel before initializing any components
		setUILookAndFeel(new javax.swing.plaf.FontUIResource("Segoe UI Semibold", Font.PLAIN,12));;

		// create frame and contents
		setPreferredSize(new Dimension(1200, 1000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		populateComponents(gameEngine, this);
		pack();
		
		// set default window position to center screen
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void populateComponents(GameEngine gameEngine, GameFrame gameFrame)
	{
		setLayout(new BorderLayout());
		
		// maintain reference to model and view for view sub-components
		this.summaryPanel = new SummaryPanel(gameEngine, gameFrame);
		this.statusBarPanel = new StatusBarPanel(gameEngine, gameFrame);
		this.wheelPanel = new WheelPanel();
		
		add(this.summaryPanel, BorderLayout.NORTH);
		add(this.statusBarPanel, BorderLayout.SOUTH);
		add(this.wheelPanel, BorderLayout.CENTER);
	}
	
	private void setUILookAndFeel(javax.swing.plaf.FontUIResource f)
	{
		// change default look and feet to system (windows) style
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

	public StatusBarPanel getStatusBarPanel() 
	{
		return this.statusBarPanel;
	}

	public WheelPanel getWheelPanel() 
	{
		return this.wheelPanel;
	}

	public SummaryPanel getSummaryPanel() 
	{
		return this.summaryPanel;
	}

}
