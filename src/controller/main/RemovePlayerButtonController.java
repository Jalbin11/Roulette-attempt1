package controller.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import controller.main.AbstractComponentController;
import model.interfaces.GameEngine;
import view.main.GameFrame;
import view.removeplayerdialog.RemovePlayerDialog;

public class RemovePlayerButtonController extends AbstractComponentController 
{
	public RemovePlayerButtonController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// create add player dialog if more than one player exists
		if(getGameEngine().getAllPlayers().size() > 0)
		{
			@SuppressWarnings("unused")
			RemovePlayerDialog removePlayerDialog = new RemovePlayerDialog(getGameEngine(), getGameFrame());	
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
