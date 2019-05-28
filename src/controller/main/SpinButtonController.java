package controller.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JOptionPane;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import view.enumerations.GameStatus;
import view.main.GameFrame;
import view.main.PlayerSummaryPanel;

public class SpinButtonController extends AbstractComponentController
{
	public SpinButtonController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine) 
	{
		super(viewComponent, gameFrame, gameEngine);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// prompt the user to place all player bets 
		if (false)
		{

		}
		else
		{
			// prompt dialog
			JOptionPane.showMessageDialog(getGameFrame(), "Submit all player bets before spinning!");
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
