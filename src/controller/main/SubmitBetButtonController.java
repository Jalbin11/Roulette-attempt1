package controller.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.main.GameFrame;
import view.main.PlayerSummaryPanel;

public class SubmitBetButtonController extends AbstractComponentController
{

	public SubmitBetButtonController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		PlayerSummaryPanel panel = (PlayerSummaryPanel) getViewComponent();
		int currentPoints = Integer.valueOf(panel.getPointsLabel().getText().replaceAll("\\D+",""));
		String betString = panel.getBetAmountField().getText();

		// validate entered bet range and type (must be >= 1 and <= points)
		// check values only if player entered an integer value
		if (checkStringContainsValidInt(betString))
		{
			int betAmount = Integer.valueOf(betString);
	
			// check entered value is in range
			if(betAmount <= Integer.valueOf(currentPoints) && betAmount >= 1)
			{
				// set bet and bet type
				getGameEngine().getPlayer(panel.getId()).setBet(betAmount);
				getGameEngine().getPlayer(panel.getId()).setBetType();
				
				// update relevant UI components
				panel.lock(getGameEngine().getPlayer(panel.getId()));
				
				// call spin() if all players have placed a bet
				
			}
			else
			{
				// range error dialog
				JOptionPane.showMessageDialog(getGameFrame(), "Enter a bet between 1 and " + currentPoints);
				panel.getBetAmountField().setText("1");;				
			}
		}
		else
		{
			// type error dialog
			JOptionPane.showMessageDialog(getGameFrame(), "Enter a valid bet (integer only)");
			panel.getBetAmountField().setText("1");;
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
