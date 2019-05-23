package client;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;
import view.main.GameEngineCallbackGUI;
import view.main.GameFrame;

public class GUITestClient 
{
	 
	@SuppressWarnings("unused")
	public static void main(String args[])
	{	
		final GameEngine gameEngine = new GameEngineImpl();
	    final GameFrame gameFrame = new GameFrame(gameEngine);

	    gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	    gameEngine.addGameEngineCallback(new GameEngineCallbackGUI());	    
	    
	   }
	}