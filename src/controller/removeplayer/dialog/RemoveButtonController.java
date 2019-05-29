package controller.removeplayer.dialog;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JDialog;

import controller.main.AbstractComponentController;
import model.interfaces.GameEngine;
import view.main.GameFrame;
import view.removeplayerdialog.RemovePlayerInputPanel;

public class RemoveButtonController extends AbstractComponentController {

	public RemoveButtonController(Component viewComponent, JDialog dialog, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, dialog, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// remove player from model
		RemovePlayerInputPanel panel = (RemovePlayerInputPanel) getViewComponent();
		getGameEngine().removePlayer(getGameEngine().getPlayer(panel.getSelection().getPlayerId()));

		// close dialog
		getDialog().dispose();
		
		// update view
		getGameFrame().getSummaryPanel().getStatsPanel().updatePanels(getGameEngine(), getGameFrame());
		getGameFrame().getSummaryPanel().getToolBarPanel().playerMaxReached(false, getGameFrame());
		getGameFrame().getStatusBarPanel().setPlayerCount(getGameEngine());
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
