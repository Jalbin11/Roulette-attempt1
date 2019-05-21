package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	  private JMenu fileMenu;
	  private JMenu editMenu;
	  private JMenuItem openMenuItem;
	  private JMenuItem cutMenuItem;
	  private JMenuItem copyMenuItem;
	  private JMenuItem pasteMenuItem;
	  
	  public MenuBar()
	  {
		  // build the File menu
		  fileMenu = new JMenu("File");
		  openMenuItem = new JMenuItem("Open");
		  fileMenu.add(openMenuItem);

		  // build the Edit menu
		  editMenu = new JMenu("Edit");
		  cutMenuItem = new JMenuItem("Cut");
		  copyMenuItem = new JMenuItem("Copy");
		  pasteMenuItem = new JMenuItem("Paste");
		  editMenu.add(cutMenuItem);
		  editMenu.add(copyMenuItem);
		  editMenu.add(pasteMenuItem);

		  // add menus to menubar
		  add(fileMenu);
		  add(editMenu);		  
	  }
}
