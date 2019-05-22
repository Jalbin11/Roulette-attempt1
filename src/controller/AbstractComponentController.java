package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import model.interfaces.GameEngine;
import view.GameFrame;

public abstract class AbstractComponentController extends MouseAdapter implements ActionListener
{
	private Component viewComponent;
	private GameFrame gameFrame;
	private GameEngine gameEngine;

	// references to model and views
	public AbstractComponentController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine)
	{
		this.viewComponent = viewComponent;
		this.gameFrame = gameFrame;
		this.gameEngine = gameEngine;
	}

	public abstract void actionPerformed(ActionEvent e);
}