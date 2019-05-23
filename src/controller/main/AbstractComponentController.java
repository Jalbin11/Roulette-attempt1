package controller.main;

import java.awt.Component;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.dialog.AddPlayerDialog;
import view.main.GameFrame;

public abstract class AbstractComponentController implements ActionListener
{
	private Component viewComponent;
	private GameEngine gameEngine;
	private GameFrame gameFrame;
	private AddPlayerDialog dialog;

	// constructor for whole app view controllers
	public AbstractComponentController(Component viewComponent, AddPlayerDialog dialog, GameFrame gameFrame, GameEngine gameEngine)
	{
		this.viewComponent = viewComponent;
		this.dialog = dialog;
		this.gameEngine = gameEngine;
	}
	
	// constructor for main gameframe controllers only 
	public AbstractComponentController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine)
	{
		this.viewComponent = viewComponent;
		this.gameFrame = gameFrame;
		this.gameEngine = gameEngine;
	}
	
	// constructor for dialog controllers only
	public AbstractComponentController(Component viewComponent, AddPlayerDialog dialog, GameEngine gameEngine)
	{
		this.viewComponent = viewComponent;
		this.dialog = dialog;
		this.gameEngine = gameEngine;
	}
	
	public GameEngine getGameEngine() 
	{
		return this.gameEngine;
	}

	public Component getViewComponent() 
	{
		return this.viewComponent;
	}
	
	public AddPlayerDialog getDialog() 
	{
		return this.dialog;
	}
	
	public GameFrame getGameFrame() 
	{
		return this.gameFrame;
	}	

}