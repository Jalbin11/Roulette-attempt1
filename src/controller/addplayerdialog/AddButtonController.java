package controller.addplayerdialog;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import controller.main.AbstractComponentController;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.addplayerdialog.AddPlayerDialog;
import view.enumerations.GameStatus;
import view.main.GameFrame;

public class AddButtonController extends AbstractComponentController 
{	
	private final int defaultPoints = 1000;

	public AddButtonController(Component viewComponent, AddPlayerDialog dialog, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, dialog, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// validate name field for a-z characters only
		String name = getDialog().getInputPanel().getNameField().getText(); 
		if (name.matches("^[a-zA-Z]+$"))
		{	
			// start players with 1000 points by default
			int points = defaultPoints;
			
			// determine player id based on number of existing players
			int playerCount = getGameEngine().getAllPlayers().size();
			String id = String.valueOf(playerCount + 1);		
			
			// add the player
			SimplePlayer newPlayer = new SimplePlayer(id, name, points);
			getGameEngine().addPlayer(newPlayer);
			
			// close dialog
			JOptionPane.showMessageDialog(getGameFrame(), "Player " + id + " " + name + " added.");
			getDialog().dispose();
			
		
			// do a bit later
//			getGameFrame().getStatusBarPanel().getReadyStatusLabel().setText(GameStatus.READY.statusString());
			
			// update other view components
			getGameFrame().getSummaryPanel().getStatsPanel().updatePanels(getGameEngine());
		}
		else
		{
			JOptionPane.showMessageDialog(getGameFrame(), "Enter a valid name (only chars a-z).");
			getDialog().getInputPanel().getNameField().setText("");
		}
		
		
	}

}
