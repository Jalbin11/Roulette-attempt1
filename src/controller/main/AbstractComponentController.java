package controller.main;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.main.GameFrame;

public abstract class AbstractComponentController implements ActionListener, PropertyChangeListener, FocusListener
{
	// implement relevant event handlers as one convenient controller superclass.
	
	private Component viewComponent;
	private GameEngine gameEngine;
	private GameFrame gameFrame;
	private JDialog dialog;

	// constructor for whole app view controllers (dialogs and main frame)
	public AbstractComponentController(Component viewComponent, JDialog dialog, GameFrame gameFrame, GameEngine gameEngine)
	{
		this.viewComponent = viewComponent;
		this.dialog = dialog;
		this.gameEngine = gameEngine;
		this.gameFrame = gameFrame;
	}
	
	// constructor for main gameframe controllers only 
	public AbstractComponentController(Component viewComponent, GameFrame gameFrame, GameEngine gameEngine)
	{
		this.viewComponent = viewComponent;
		this.gameFrame = gameFrame;
		this.gameEngine = gameEngine;
	}
	
	// constructor for dialog controllers only
	public AbstractComponentController(Component viewComponent, JDialog dialog, GameEngine gameEngine)
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
	
	public JDialog getDialog() 
	{
		return this.dialog;
	}
	
	public GameFrame getGameFrame() 
	{
		return this.gameFrame;
	}	

}