package view.main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class StatsPanel extends JPanel 
{
	private JPanel panel;
	private Border blackBorder;
	private final int cols = 1;
	private int rows = 1;
	
	public StatsPanel(GameEngine gameEngine, GameFrame gameFrame)
	{	
		blackBorder = BorderFactory.createLineBorder(Color.BLACK);	
		setLayout(new GridLayout(rows, cols));
		setBorder(blackBorder);
	}
	
	public void updatePanels(GameEngine gameEngine, GameFrame gameFrame)
	{
		// clear existing panels
		this.removeAll();
		
		// determine layout config
		rows = gameEngine.getAllPlayers().size(); 
		setLayout(new GridLayout(rows, cols));
		
		// build panels from model data
		for (Player p : gameEngine.getAllPlayers())
		{
			panel = new PlayerSummaryPanel(p, gameEngine, gameFrame);
			this.add(panel);	
		}
		
		// re-pack main app window
		gameFrame.pack();
	}
	

}
