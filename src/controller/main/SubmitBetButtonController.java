package controller.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JOptionPane;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import view.enumerations.GameStatus;
import view.main.GameFrame;
import view.main.PlayerSummaryPanel;

public class SubmitBetButtonController extends AbstractComponentController
{
	private final int INITIAL_DELAY = 1;
	private final int FINAL_DELAY = 500;
	private final int DELAY_INCREMENT = 25;
	
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
		// assign references for convenience
		panel = (PlayerSummaryPanel) getViewComponent();
		currentPoints = Integer.valueOf(panel.getPointsLabel().getText().replaceAll("\\D+",""));
		betString = panel.getBetAmountField().getText();
		betType =  (BetType) panel.getBetTypeComboBox().getSelectedItem();
		
		// validate entered bet range and type (must be >= 1 and <= points)
		// check values only if player entered an integer value
		if (checkStringContainsValidInt(betString))
		{
			int betAmount = Integer.valueOf(betString);
	
			// check entered value is in range
			if(betAmount <= Integer.valueOf(currentPoints) && betAmount >= 1)
			{
				// set bet and bet type
				getGameEngine().getPlayer(String.valueOf(panel.getId())).setBet(betAmount);
				getGameEngine().getPlayer(String.valueOf(panel.getId())).setBetType(betType);
				
				// update other UI components
				panel.lock(getGameEngine().getPlayer(String.valueOf(panel.getId())));			
				panel.setHasPlacedBet(true);
				
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
					getGameFrame().getStatusBarPanel().getReadyStatusLabel().setText(GameStatus.INPROGRESS.statusString());
					getGameFrame().getSummaryPanel().getToolBarPanel().lockButtons();		
					
					// call spin() on a separate thread
					new Thread()
					{
					@Override
					public void run()
					{
						getGameEngine().spin(INITIAL_DELAY, FINAL_DELAY, DELAY_INCREMENT);
					}
					}.start();
				}
			}
			else
			{
				// range error dialog
				JOptionPane.showMessageDialog(getGameFrame(), "Enter a bet between 1 and " + currentPoints);
				panel.getBetAmountField().setText("1");				
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
