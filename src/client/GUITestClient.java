package client;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

public class GUITestClient 
{
	 private static final Logger logger = Logger.getLogger(GUITestClient.class.getName());

	   public static void main(String args[])
	   {
	      final GameEngine gameEngine = new GameEngineImpl();

	      // create some test players
	      Player[] players = new Player[] { new SimplePlayer("1", "Come In Spinner", 1000),
	         new SimplePlayer("2", "The Loser", 750), new SimplePlayer("3", "The Dabbler", 500) };

	      // add logging callback
	      gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	      gameEngine.addGameEngineCallback(new GameEngineCallbackGUI());

	      // main loop to add players and place a bet
	      int enumOrdinal = 0;
	      for (Player player : players)
	      {
	         gameEngine.addPlayer(player);
	         // mod with BetType length so we always stay in range even if num players increases
	         // NOTE: we are passing a different BetType each time!
	         gameEngine.placeBet(player, 100, BetType.values()[enumOrdinal++ % BetType
	            .values().length]);
	      }

	      logger.log(Level.INFO, "SPINNING ...");
	      
	      gameEngine.spin(1, 100, 5);

	      // TODO reset bets for next round if you were playing again
	   }

	}