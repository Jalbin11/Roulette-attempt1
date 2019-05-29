package view.main;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel 
{
	private MenuBar menuBar;
	private StatsPanel statsPanel;
	private ToolBarPanel toolBarPanel;
	
	public SummaryPanel(GameEngine gameEngine, GameFrame gameFrame) 
	{
		setLayout(new BorderLayout());
		
		// maintain reference to model and view for view sub-components
		menuBar = new MenuBar(gameEngine, gameFrame);
		statsPanel = new StatsPanel(gameEngine, gameFrame);
		toolBarPanel = new ToolBarPanel(gameEngine, gameFrame);
				
		add(menuBar, BorderLayout.NORTH);
		add(statsPanel, BorderLayout.SOUTH);
		add(toolBarPanel, BorderLayout.CENTER);
	}
	
	public MenuBar getMenuBar() 
	{
		return menuBar;
	}

	public StatsPanel getStatsPanel() 
	{
		return statsPanel;
	}

	public ToolBarPanel getToolBarPanel() 
	{
		return toolBarPanel;
	}
}
