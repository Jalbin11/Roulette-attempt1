package view.main;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

	private GameFrame gameFrame;
	
	public GameEngineCallbackGUI(GameFrame gameFrame) 
	{
		this.gameFrame = gameFrame;
	}

	@Override
	public void nextSlot(Slot slot, GameEngine engine) 
	{	
		// update ball position	
		SwingUtilities.invokeLater(new Runnable()
		{
		@Override
		public void run()
		{
			gameFrame.getWheelPanel().updateBallPosition(slot);
		}
		});		
	}

	@Override
	public void result(Slot result, GameEngine gameEngine) 
	{	
		// update views
		gameFrame.postSpinUIUpdate();
				
		// update and unlock summary panel stats panels
		for(PlayerSummaryPanel panel : gameFrame.getSummaryPanel().getStatsPanel().getAllPanels())
		{
			panel.setHasPlacedBet(false);
			panel.update(gameEngine.getPlayer(String.valueOf(panel.getId())));
		}
		gameFrame.getSummaryPanel().getStatsPanel().updatePanels(gameEngine, gameFrame);
		
		// NOTE: A1 logger callback already calls calculateBet() and resetBet()
		// add calculateBet() and resetBet() here if removing A1 callback
	}

}
