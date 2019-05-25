package controller.addplayerdialog;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JOptionPane;

import controller.main.AbstractComponentController;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.addplayerdialog.AddPlayerDialog;
import view.main.GameFrame;

public class AddButtonController extends AbstractComponentController 
{	
	public AddButtonController(Component viewComponent, AddPlayerDialog dialog, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, dialog, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		@SuppressWarnings("unused")
		final int minimumPoints = 100;
		final String defaultPoints = "750";
		
		String points = getDialog().getInputPanel().getPointsField().getText();
		String name = getDialog().getInputPanel().getNameField().getText(); 

		// validate points and name fields
		if (name.matches("^[a-zA-Z]+$") && points.matches("[0-9]+$"))
		{	
			// check entered points meets minimum
			if (Integer.parseInt(points) >= 100 )
			{
				// determine player id based on number of existing players
				int playerCount = getGameEngine().getAllPlayers().size();
				String id = String.valueOf(playerCount++);		
				
				// add the player
				SimplePlayer newPlayer = new SimplePlayer(id, name, Integer.parseInt(points));
				getGameEngine().addPlayer(newPlayer);
				
				// debug
				System.out.println("Total players: " + getGameEngine().getAllPlayers().size());
				
				// close dialog
				getDialog().dispose();

				// update other view components
				getGameFrame().getSummaryPanel().getStatsPanel().updatePanels(getGameEngine(), getGameFrame());
			}
			else
			{
				// range error dialog
				JOptionPane.showMessageDialog(getGameFrame(), "Enter points value above 100.");
				getDialog().getInputPanel().getPointsField().setText(defaultPoints);
			}
		}
		else
		{
			// type error dialog
			JOptionPane.showMessageDialog(getGameFrame(), "Enter valid name (a-z chars only) and points value (integer only).");
			getDialog().getInputPanel().getNameField().setText("");
			getDialog().getInputPanel().getPointsField().setText(defaultPoints);
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
