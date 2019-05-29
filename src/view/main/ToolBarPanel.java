package view.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;

import controller.main.AddPlayerButtonController;
import controller.main.RemovePlayerButtonController;
import controller.main.SpinButtonController;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class ToolBarPanel extends JPanel 
{
	private JToolBar toolBar = new JToolBar("Game Tasks");
	private JButton addPlayerButton = new JButton("  Add New Player  ");
	private JButton removePlayerButton = new JButton("  Remove Player  ");
	private JPanel spacePanel = new JPanel();
	private JButton spinButton = new JButton("   SPIN   ");

	public ToolBarPanel(GameEngine gameEngine, GameFrame gameFrame) 
	{
		setLayout(new FlowLayout());
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);	
		setBorder(blackBorder);
				
		toolBar.add(this.addPlayerButton);
		toolBar.add(this.removePlayerButton);
		spacePanel.setPreferredSize(new Dimension(35, 25));
		removePlayerButton.setEnabled(false);
		
		add(spinButton);
		add(spacePanel);
		add(toolBar);
		
		addPlayerButton.addActionListener(new AddPlayerButtonController(this.addPlayerButton, gameFrame, gameEngine));
		removePlayerButton.addActionListener(new RemovePlayerButtonController(this.removePlayerButton, gameFrame, gameEngine));
		spinButton.addActionListener(new SpinButtonController(this, gameFrame, gameEngine));
	}

	public JButton getAddPlayerButton() 
	{
		return addPlayerButton;
	}

	public JButton getRemovePlayerButton() 
	{
		return removePlayerButton;
	}

	public JButton getSpinButton() 
	{
		return spinButton;
	}
	
	public void lockButtons()
	{
		addPlayerButton.setEnabled(false);
		removePlayerButton.setEnabled(false);
		spinButton.setEnabled(false);
	}

	public void unlockButtons()
	{
		addPlayerButton.setEnabled(true);
		removePlayerButton.setEnabled(true);
		spinButton.setEnabled(true);
	}

	public void playerMaxReached(boolean b, GameFrame gameFrame) 
	{
		if(!b)
		{
			this.addPlayerButton.setText("Add New Player");
			this.addPlayerButton.setEnabled(true);			
			gameFrame.getSummaryPanel().getMenuBar().setAddPlayerLocked(false);
			
		}
		if(b)
		{
			this.addPlayerButton.setText("Max Players Reached");
			this.addPlayerButton.setEnabled(false);	
			gameFrame.getSummaryPanel().getMenuBar().setAddPlayerLocked(true);
		}
	}
	
	public void playerMinExceeded(boolean b, GameFrame gameFrame) 
	{
		if(b)
		{
			this.removePlayerButton.setEnabled(true);		
			gameFrame.getSummaryPanel().getMenuBar().setRemovePlayerLocked(false);
		}
		if(!b)
		{
			this.removePlayerButton.setEnabled(false);	
			gameFrame.getSummaryPanel().getMenuBar().setRemovePlayerLocked(true);
		}
	}

}
