package controller.addplayerdialog;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controller.main.AbstractComponentController;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.addplayerdialog.AddPlayerDialog;
import view.enumerations.GameStatus;
import view.main.GameFrame;

public class AddButtonController extends AbstractComponentController 
{	
	private final int minimumPoints = 100;
	private final String defaultPoints = "750";
	private final int playerMax = 4; 
	
	public AddButtonController(Component viewComponent, JDialog dialog, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, dialog, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		// cast dialog to local variable for convenience reference
		AddPlayerDialog dialog = (AddPlayerDialog) getDialog();
		
		String points = dialog.getInputPanel().getPointsField().getText();
		String name = dialog.getInputPanel().getNameField().getText(); 

		// validate points and name fields
		if (name.matches("^[a-zA-Z\\s+]+$") && points.matches("[0-9]+$"))
		{	
			// check entered points meets minimum
			if (Integer.parseInt(points) >= minimumPoints)
			{
				// determine player id based on number of existing players
				int playerCount = getGameEngine().getAllPlayers().size();
				String id = String.valueOf(playerCount++);		
				
				// add the player
				SimplePlayer newPlayer = new SimplePlayer(id, name, Integer.parseInt(points));
				getGameEngine().addPlayer(newPlayer);
				
				// close dialog
				getDialog().dispose();

				// update other view components
				getGameFrame().getSummaryPanel().getStatsPanel().updatePanels(getGameEngine(), getGameFrame());
				getGameFrame().getStatusBarPanel().setPlayerCount(getGameEngine());
				getGameFrame().getSummaryPanel().getToolBarPanel().playerMinExceeded(true, getGameFrame());	
				getGameFrame().getStatusBarPanel().setStatus(GameStatus.READY);

				// set a maximum player limit, disable add button when player limit met
				if(playerCount == playerMax)
				{
					getGameFrame().getSummaryPanel().getToolBarPanel().playerMaxReached(true, getGameFrame());
				}
			}
			else
			{
				// range error dialog
				JOptionPane.showMessageDialog(getGameFrame(), "Enter points value above 100.");
				dialog.getInputPanel().getPointsField().setText(defaultPoints);
			}
		}
		else
		{
			// type error dialog
			JOptionPane.showMessageDialog(getGameFrame(), "Enter valid name (a-z chars only) and points value (integer only).");
			dialog.getInputPanel().getNameField().setText("");
			dialog.getInputPanel().getPointsField().setText(defaultPoints);
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
