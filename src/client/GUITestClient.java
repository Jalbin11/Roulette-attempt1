package client;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.GameEngineCallbackImpl;
import view.main.GameEngineCallbackGUI;
import view.main.GameFrame;

public class GUITestClient 
{
	public static void main(String args[])
	{	
		final GameEngine gameEngine = new GameEngineImpl();
		
		// pass GUI view a reference to the model
	    final GameFrame gameFrame = new GameFrame(gameEngine);
	   
	    gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	    gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(gameFrame));	       
	   }
	}