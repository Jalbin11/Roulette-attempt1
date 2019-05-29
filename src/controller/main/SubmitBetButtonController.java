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

public class SubmitBetButtonController extends AbstractComponentController
{
	private int betAmount;
	private int currentPoints;
	private String betString;
	private BetType betType;
	private PlayerSummaryPanel panel;
	private boolean allBetsPlaced = false;
	
	public SubmitBetButtonController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// get references
		panel = (PlayerSummaryPanel) getViewComponent();
		currentPoints = getGameEngine().getPlayer(String.valueOf(panel.getId())).getPoints();
		betString = panel.getBetAmountField().getText();
		betType =  (BetType) panel.getBetTypeComboBox().getSelectedItem();
		
		// validate entered bet range and type (must be >= 1 and <= points)
		// check values only if player entered an integer value
		if (checkStringContainsValidInt(betString))
		{
			betAmount = Integer.valueOf(betString);
	
			// check entered value is in range
			if(betAmount <= currentPoints && betAmount >= 0)
			{
				// set bet and bet type
				getGameEngine().getPlayer(String.valueOf(panel.getId())).setBet(betAmount);
				getGameEngine().getPlayer(String.valueOf(panel.getId())).setBetType(betType);

				// update other UI components	
				panel.setHasPlacedBet(true);
				panel.setBet(betAmount);
				panel.lock(getGameEngine().getPlayer(String.valueOf(panel.getId())));	
				
				// check if all players have bet
				allBetsPlaced = true;
				for (PlayerSummaryPanel p : getGameFrame().getSummaryPanel().getStatsPanel().getAllPanels())
				{
					if(!p.getHasPlacedBet())
					{
						allBetsPlaced = false;
					}
				}
				
				// call spin() and update view components if all players have placed a bet
				if(allBetsPlaced)
				{
					getGameFrame().preSpinUIUpdate();
					
					// call spin() on a separate thread
					new Thread()
					{
						@Override
						public void run()
						{
							getGameEngine().spin(getGameFrame().getInitialDelay(), 
												getGameFrame().getFinalDelay(), 
												getGameFrame().getDelayIncrement());
						}
					}.start();
				}
			}
			else
			{
				// bet range error dialog
				JOptionPane.showMessageDialog(getGameFrame(), "Enter a bet between 0 and " + currentPoints);
				panel.getBetAmountField().setText("0");				
			}
		}
		else
		{
			// type error dialog
			JOptionPane.showMessageDialog(getGameFrame(), "Enter a valid bet (integer only)");
			panel.getBetAmountField().setText("0");;
		}
	}

	// helper method for type-checking player input betAmount
	private boolean checkStringContainsValidInt(String string) 
	{
		try 
		{ 
			Integer.parseInt(string); 
		} 
		catch(NumberFormatException e) 
		{ 
			return false; 
		} 
		catch(NullPointerException e) 
		{
			return false;
		}
			return true;
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
