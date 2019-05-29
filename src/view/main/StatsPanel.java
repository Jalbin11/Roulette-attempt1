package view.main;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class StatsPanel extends JPanel 
{
	private List<PlayerSummaryPanel> panels = new ArrayList<PlayerSummaryPanel>();
	private Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
	private boolean panelExists = false;
	
	// use Collections for convenient access to retainAll() method when difference-checking
	private List<Integer> panelIds = new ArrayList<Integer>();
	private List<Integer> playerIds = new ArrayList<Integer>();	
	private List<Integer> difference = new ArrayList<Integer>();	
	private List<Integer> intersection;
	
	private final int cols = 1;
	private int playerCount = 1;
	
	public StatsPanel(GameEngine gameEngine, GameFrame gameFrame)
	{	
		setLayout(new GridLayout(playerCount, cols));
	}
	
	public void updatePanels(GameEngine gameEngine, GameFrame gameFrame)
	{
		// set layout config as panels update
		setBorder(blackBorder);
		playerCount = gameEngine.getAllPlayers().size(); 
		setLayout(new GridLayout(playerCount, cols));
		
		// clear Lists 
		panelIds.clear();
		playerIds.clear();
		difference.clear();		
		
		// get list of panelId's
		for (PlayerSummaryPanel panel : panels)
		{
			panelIds.add(panel.getId());
		}
		
		// get list of playerId's
		for (Player player : gameEngine.getAllPlayers())
		{
			playerIds.add(Integer.parseInt(player.getPlayerId()));
		}
		
		// create new panel if there is no existing panel with same id
		for (Player player : gameEngine.getAllPlayers())
		{
			panelExists = false;
			
			for (PlayerSummaryPanel panel : panels)
			{
				if(Integer.valueOf(player.getPlayerId()).equals(panel.getId()))
				{
					panelExists = true;
				}				
			}
			
			if(!panelExists)
			{
				panels.add(new PlayerSummaryPanel(player, gameEngine, gameFrame));	
			}
		}

		// compare panel and player id's to check for redundant panels 
		// i.e. panel ids that exist that do not exist for a player		
		intersection = new ArrayList<Integer>(panelIds);
		intersection.retainAll(playerIds);
		
		for(Integer id : panelIds) 
		    if(!intersection.contains(id))
		    {
		    	difference.add(id);
		    }
		
		// if a panel exists with no shared player id, remove the panel
		if(!difference.isEmpty())
		{
			for(Integer id : difference)
			{
				Iterator<PlayerSummaryPanel> iterator = panels.iterator();
				while(iterator.hasNext())
				{
					if (iterator.next().getId() == id)
					{
						iterator.remove();		
					}
				}			
			}
		}
		
		// remove and re-add updated panels to parent
		this.removeAll();
		for (PlayerSummaryPanel panel : panels)
		{
			panel.unlock();
			add(panel);
			panel.repaint();
		}
		
		revalidate();
	}
	
	// return only a reference
	public List<PlayerSummaryPanel> getAllPanels() 
	{	
		List<PlayerSummaryPanel> allPanels = new ArrayList<PlayerSummaryPanel>(panels);
		return allPanels;
	}
}
