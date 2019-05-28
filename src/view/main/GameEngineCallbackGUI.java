package view.main;

import java.awt.Image;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.enumerations.GameStatus;
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
		// log results to summary object/panel/something
		// TODO send results and player summary strings wrapped in a results object
		// increment spincount on statusbar panel
		
		// update views
		gameFrame.getStatusBarPanel().getReadyStatusLabel().setText(GameStatus.GAMEOVER.statusString());
		gameFrame.getSummaryPanel().getToolBarPanel().unLockButtons();
				
		// update and unlock summary panel stats panels
		for(PlayerSummaryPanel panel : gameFrame.getSummaryPanel().getStatsPanel().getAllPanels())
		{
			panel.setHasPlacedBet(false);
			// TODO
			// update currentbet and last win/loss
		}
		gameFrame.getSummaryPanel().getStatsPanel().updatePanels(gameEngine, gameFrame);
		
		// A1 logger callback already calls resetBet() and calculateBet(), don't do it twice
	}

}
