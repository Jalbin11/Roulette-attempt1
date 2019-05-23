package controller.addplayerdialog;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import controller.main.AbstractComponentController;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.dialog.AddPlayerDialog;
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
		// validate name field
		String name = getDialog().getInputPanel().getNameField().getText(); 
		if (name.matches("^[a-zA-Z]+$"))
		{	
			// start players with 1000 points by default
			int points = 1000;
			
			// determine player id based on number of existing players
			String id = String.valueOf(getGameEngine().getAllPlayers().size() + 1);		
			
			// add the player
			getGameEngine().addPlayer(new SimplePlayer(id, name, points));
			
			JOptionPane.showMessageDialog(getGameFrame(), "Player " + id + " " + name + " added.");
			getDialog().dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(getGameFrame(), "Enter a valid name (only chars a-z).");
			getDialog().getInputPanel().getNameField().setText("");
		}
		
		
	}

}
