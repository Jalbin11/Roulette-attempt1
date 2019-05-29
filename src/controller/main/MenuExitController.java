package controller.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import controller.main.AbstractComponentController;
import model.interfaces.GameEngine;
import view.main.GameFrame;

public class MenuExitController extends AbstractComponentController 
{
	public MenuExitController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// close app
		System.exit(0);
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
