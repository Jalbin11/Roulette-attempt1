package controller.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import controller.main.AbstractComponentController;
import model.interfaces.GameEngine;
import view.addplayerdialog.AddPlayerDialog;
import view.main.GameFrame;

public class AddPlayerButtonController extends AbstractComponentController 
{
	public AddPlayerButtonController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, gameFrame, gameEngine);
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// create add player dialog 
		AddPlayerDialog addPlayerDialog = new AddPlayerDialog(getGameEngine(), getGameFrame());
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
