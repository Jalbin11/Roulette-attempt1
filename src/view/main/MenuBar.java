package view.main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.main.MenuAddPlayerController;
import controller.main.MenuExitController;
import controller.main.MenuRemovePlayerController;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	  private JMenu gameMenu;
	  private JMenu tasksMenu;
	  private JMenuItem exitMenuItem;
	  private JMenuItem addPlayerMenuItem;
	  private JMenuItem removePlayerMenuItem;
	  
	  public MenuBar(GameEngine gameEngine, GameFrame gameFrame)
	  {
		  // Game menu
		  gameMenu = new JMenu("Game");
		  exitMenuItem = new JMenuItem("Exit");
		  gameMenu.add(this.exitMenuItem);

		  // Edit menu
		  tasksMenu = new JMenu("Tasks");
		  addPlayerMenuItem = new JMenuItem("Add new player...");
		  removePlayerMenuItem = new JMenuItem("Remove a player...");
		  removePlayerMenuItem.setEnabled(false);
		  tasksMenu.add(addPlayerMenuItem);
		  tasksMenu.add(removePlayerMenuItem);

		  add(gameMenu);
		  add(tasksMenu);		  
		  
		  // listeners
		  exitMenuItem.addActionListener(new MenuExitController(this, gameFrame, gameEngine));
		  addPlayerMenuItem.addActionListener(new MenuAddPlayerController(this, gameFrame, gameEngine));
		  removePlayerMenuItem.addActionListener(new MenuRemovePlayerController(this, gameFrame, gameEngine));
	  }
	    
	  // lock or unlock add player menu item
	  public void setAddPlayerLocked(boolean b)
	  {
			if(b)
			{
				addPlayerMenuItem.setEnabled(false);
			}			
		
			if(!b)
			{
				addPlayerMenuItem.setEnabled(true);
			}
	  }

	  // lock or unlock remove player menu item
	  public void setRemovePlayerLocked(boolean b)
	  {
			if(b)
			{
				removePlayerMenuItem.setEnabled(false);
			}			
		
			if(!b)
			{
				removePlayerMenuItem.setEnabled(true);
			}
	  }
	  
}
