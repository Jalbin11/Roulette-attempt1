package controller.addplayerdialog;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import controller.main.AbstractComponentController;
import model.interfaces.GameEngine;
import view.addplayerdialog.AddPlayerDialog;
import view.main.GameFrame;

public class CancelButtonController extends AbstractComponentController 
{
	public CancelButtonController(Component viewComponent, AddPlayerDialog dialog, GameFrame gameFrame, GameEngine gameEngine)
	{
		super(viewComponent, dialog, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getDialog().dispose();
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
