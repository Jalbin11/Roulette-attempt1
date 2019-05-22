package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel 
{

	public SummaryPanel(GameEngine gameEngine, GameFrame gameFrame) 
	{
		setLayout(new BorderLayout());
		
		// maintain a reference to the model (gameEngine) for relevant components
		add(new MenuBar(gameEngine, gameFrame), BorderLayout.NORTH);
		add(new StatsPanel(gameEngine, gameFrame), BorderLayout.SOUTH);
		add(new ToolBarPanel(gameEngine, gameFrame), BorderLayout.CENTER);
	}
}
