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
		this.menuBar = new MenuBar(gameEngine, gameFrame);
		this.statsPanel = new StatsPanel(gameEngine, gameFrame);
		this.toolBarPanel = new ToolBarPanel(gameEngine, gameFrame);
				
		add(this.menuBar, BorderLayout.NORTH);
		add(this.statsPanel, BorderLayout.SOUTH);
		add(this.toolBarPanel, BorderLayout.CENTER);
	}
	
	public MenuBar getMenuBar() 
	{
		return this.menuBar;
	}

	public StatsPanel getStatsPanel() 
	{
		return this.statsPanel;
	}

	public ToolBarPanel getToolBarPanel() 
	{
		return this.toolBarPanel;
	}
}
