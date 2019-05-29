package view.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.interfaces.GameEngine;
import view.enumerations.GameStatus;

@SuppressWarnings("serial")
public class GameFrame extends JFrame
{
	private StatusBarPanel statusBarPanel;
	private WheelPanel wheelPanel;
	private SummaryPanel summaryPanel;
	
	private final int INITIAL_DELAY = 1;
	private final int FINAL_DELAY = 200;
	private final int DELAY_INCREMENT = 4;
	
	private Dimension minSize;
	
	public GameFrame(GameEngine gameEngine) 
	{	
		super("WheelGameGUI - Assignment 2");
		
		// determine minimum window size
		minSize = new Dimension(
				(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2, 
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);

		// set look and feel before initializing any components
		setUILookAndFeel(new javax.swing.plaf.FontUIResource("Segoe UI Semibold", Font.PLAIN,12));

		// create frame and contents
		setPreferredSize(new Dimension(900, 900));
		setMinimumSize(minSize);
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
		summaryPanel = new SummaryPanel(gameEngine, gameFrame);
		statusBarPanel = new StatusBarPanel();
		wheelPanel = new WheelPanel();
		
		add(summaryPanel, BorderLayout.NORTH);
		add(statusBarPanel, BorderLayout.SOUTH);
		add(wheelPanel, BorderLayout.CENTER);
	}
	
	// lock and update views during spin
	public void preSpinUIUpdate() 
	{
		statusBarPanel.setStatus(GameStatus.INPROGRESS);
		summaryPanel.getToolBarPanel().lockButtons();	
		summaryPanel.getMenuBar().setEnabled(false);
		statusBarPanel.incrementSpinCount();
	}
	
	// unlock and update views post spin
	public void postSpinUIUpdate() 
	{
		statusBarPanel.setStatus(GameStatus.GAMEOVER);
		summaryPanel.getToolBarPanel().unlockButtons();
		summaryPanel.getMenuBar().setEnabled(true);
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
	    while (keys.hasMoreElements()) 
	    {
	    	Object key = keys.nextElement();
	    	Object value = UIManager.get (key);
	    	
	    	if (value instanceof javax.swing.plaf.FontUIResource)
	    	{
	    		UIManager.put (key, f);
	    	}
	    }
	}

	public StatusBarPanel getStatusBarPanel() 
	{
		return statusBarPanel;
	}

	public WheelPanel getWheelPanel() 
	{
		return wheelPanel;
	}

	public SummaryPanel getSummaryPanel() 
	{
		return summaryPanel;
	}
	
	public int getInitialDelay() 
	{
		return INITIAL_DELAY;
	}

	public int getFinalDelay() 
	{
		return FINAL_DELAY;
	}

	public int getDelayIncrement() 
	{
		return DELAY_INCREMENT;
	}

}
