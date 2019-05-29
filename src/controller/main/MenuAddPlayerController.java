package controller.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import controller.main.AbstractComponentController;
import model.interfaces.GameEngine;
import view.main.GameFrame;

public class MenuAddPlayerController extends AbstractComponentController 
{
	public MenuAddPlayerController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// trigger the existing add player button actionlistener
		getGameFrame().getSummaryPanel().getToolBarPanel().getAddPlayerButton().doClick();
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
