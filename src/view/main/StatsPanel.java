package view.main;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class StatsPanel extends JPanel 
{
	private ArrayList<PlayerSummaryPanel> panels = new ArrayList<PlayerSummaryPanel>();
	Border blackBorder;
	private PlayerSummaryPanel panel;
	private final int cols = 1;
	private final int border = 1;
	private int rows = 1;
	
	public StatsPanel(GameEngine gameEngine, GameFrame gameFrame)
	{	
		blackBorder = BorderFactory.createLineBorder(Color.BLACK);	
		setLayout(new GridLayout(rows, cols));
//		add(new PlayerSummaryPanel(new SimplePlayer("1", "jeff", 1000)));
	}
	
	public void updatePanels(GameEngine gameEngine)
	{
//		panels.clear();
		setBorder(blackBorder);
		
		// build panels from model data
		for (Player p : gameEngine.getAllPlayers())
		{
			panel = new PlayerSummaryPanel(p);
			panels.add(panel);	
			System.out.println("Panels.size() = " + panels.size());
			System.out.println("Player from model: " + p.toString());	
		}

	
		// determine layout config and add panels to parent container
		rows = panels.size(); 
		setLayout(new GridLayout(rows, cols));
		
		for (PlayerSummaryPanel p : panels)
		{
			this.add(p);	
		}	
	}
	

}
