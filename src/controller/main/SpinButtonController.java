package controller.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JOptionPane;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import view.main.GameFrame;
import view.main.PlayerSummaryPanel;

public class SpinButtonController extends AbstractComponentController
{
	public SpinButtonController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// throw prompt dialog if no players exist
		if (getGameEngine().getAllPlayers().size() < 1)
		{
			JOptionPane.showMessageDialog(getGameFrame(), "Add at least one player before spinning!");
		}
		
		// check at least one player exists  
		if (getGameEngine().getAllPlayers().size() >= 1)
		{
			// if player has not bet, place a default bet of 0 and RED (i.e. no bet)
			for (PlayerSummaryPanel p : getGameFrame().getSummaryPanel().getStatsPanel().getAllPanels())
			{
				if (!p.getHasPlacedBet())
				{
					getGameEngine().getPlayer(String.valueOf(p.getId())).setBet(0);
					getGameEngine().getPlayer(String.valueOf(p.getId())).setBetType(BetType.RED);					
					p.lock(getGameEngine().getPlayer(String.valueOf(p.getId())));
				}
			}
			
			// update UI components 
			getGameFrame().preSpinUIUpdate();
			
			// call spin() in a separate thread
			new Thread()
			{
			@Override
			public void run()
			{
				getGameEngine().spin(getGameFrame().getInitialDelay(), getGameFrame().getFinalDelay(), getGameFrame().getDelayIncrement());
			}
			}.start();
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) 
	{
		
	}

	@Override
	public void focusGained(FocusEvent e) 
	{
		
	}

	@Override
	public void focusLost(FocusEvent e) 
	{
		
	}
}
