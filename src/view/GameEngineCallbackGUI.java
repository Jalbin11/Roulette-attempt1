package view;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

	public GameEngineCallbackGUI() 
	{
		
	}

	@Override
	public void nextSlot(Slot slot, GameEngine engine) 
	{
		// call methods to update view components
		
	}

	@Override
	public void result(Slot result, GameEngine engine) 
	{
		// calculate player betting results
		// first callback will have already done the calculation. 
		// simply get (already updated) player data from engine.getAllPlayers()
	    // then update relevant view components
	    // first callback will resetbet(), dont do twice
	}

}
