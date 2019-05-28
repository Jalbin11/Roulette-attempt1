package view.main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	  private JMenu fileMenu;
	  private JMenu editMenu;
	  private JMenuItem exitMenuItem;
	  private JMenuItem addPlayerMenuItem;
	  private JMenuItem removePlayerMenuItem;
	  private JMenuItem summaryMenuItem;
	  
	  public MenuBar(GameEngine gameEngine, GameFrame gameFrame)
	  {
		  // Menu menu
		  this.fileMenu = new JMenu("Menu");
		  this.exitMenuItem = new JMenuItem("Exit");
		  this.fileMenu.add(this.exitMenuItem);

		  // Edit menu
		  this.editMenu = new JMenu("Edit");
		  this.addPlayerMenuItem = new JMenuItem("Add new player...");
		  this.removePlayerMenuItem = new JMenuItem("Remove a player...");
		  this.summaryMenuItem = new JMenuItem("Show all games summary");
		  this.editMenu.add(this.addPlayerMenuItem);
		  this.editMenu.add(this.removePlayerMenuItem);
		  this.editMenu.add(this.summaryMenuItem);

		  add(this.fileMenu);
		  add(this.editMenu);		  
	  }
}
