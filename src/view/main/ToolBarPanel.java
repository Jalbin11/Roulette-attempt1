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
	private JButton summaryButton = new JButton("  All Games Stats  ");
	private JPanel spacePanel = new JPanel();
	private JButton spinButton = new JButton("   SPIN   ");

	public ToolBarPanel(GameEngine gameEngine, GameFrame gameFrame) 
	{
		setLayout(new FlowLayout());
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);	
		setBorder(blackBorder);
				
		toolBar.add(this.addPlayerButton);
		toolBar.add(this.removePlayerButton);
		toolBar.add(this.summaryButton);
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

	public JButton getSummaryButton() 
	{
		return summaryButton;
	}

	public JButton getSpinButton() 
	{
		return spinButton;
	}
	
	public void lockButtons()
	{
		addPlayerButton.setEnabled(false);
		removePlayerButton.setEnabled(false);
		summaryButton.setEnabled(false);
		spinButton.setEnabled(false);
	}

	public void unLockButtons()
	{
		addPlayerButton.setEnabled(true);
		removePlayerButton.setEnabled(true);
		summaryButton.setEnabled(true);
		spinButton.setEnabled(true);
	}

}
