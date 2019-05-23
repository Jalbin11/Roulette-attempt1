package view.main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	  private JMenu fileMenu;
	  private JMenu editMenu;
	  private JMenuItem openMenuItem;
	  private JMenuItem cutMenuItem;
	  private JMenuItem copyMenuItem;
	  private JMenuItem pasteMenuItem;
	  
	  public MenuBar(GameEngine gameEngine, GameFrame gameFrame)
	  {
		  // build the File menu
		  this.fileMenu = new JMenu("File");
		  this.openMenuItem = new JMenuItem("Open");
		  this.fileMenu.add(this.openMenuItem);

		  // build the Edit menu
		  this.editMenu = new JMenu("Edit");
		  this.cutMenuItem = new JMenuItem("Cut");
		  this.copyMenuItem = new JMenuItem("Copy");
		  this.pasteMenuItem = new JMenuItem("Paste");
		  this.editMenu.add(this.cutMenuItem);
		  this.editMenu.add(this.copyMenuItem);
		  this.editMenu.add(this.pasteMenuItem);

		  // add menus to menubar
		  add(this.fileMenu);
		  add(this.editMenu);		  
	  }
}
