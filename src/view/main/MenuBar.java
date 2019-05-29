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

	  private JMenu gameMenu = new JMenu("Game");
	  private JMenu tasksMenu = new JMenu("Tasks");
	  private JMenuItem exitMenuItem = new JMenuItem("Exit");
	  private JMenuItem addPlayerMenuItem = new JMenuItem("Add new player...");
	  private JMenuItem removePlayerMenuItem = new JMenuItem("Remove a player...");
	  
	  public MenuBar(GameEngine gameEngine, GameFrame gameFrame)
	  {
		  // build menus
		  gameMenu.add(this.exitMenuItem);		  
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
