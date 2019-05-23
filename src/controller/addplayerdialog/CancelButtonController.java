package controller.addplayerdialog;

import java.awt.Component;
import java.awt.event.ActionEvent;


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

}
