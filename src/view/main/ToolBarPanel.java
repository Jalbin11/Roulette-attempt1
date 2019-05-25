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
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class ToolBarPanel extends JPanel 
{
	private JToolBar toolBar = new JToolBar("Game Tasks");
	private JButton addPlayerButton = new JButton("  Add New Player  ");
	private JButton removePlayerButton = new JButton("  Remove Player  ");
	private JButton summaryButton = new JButton("  All Games Stats  ");
	private JButton multiSpinButton = new JButton("  Spin Multiple Times  ");
	private JPanel spacePanel = new JPanel();
	private JButton spinButton = new JButton("   SPIN   ");

	public ToolBarPanel(GameEngine gameEngine, GameFrame gameFrame) 
	{
		setLayout(new FlowLayout());
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);	
		setBorder(blackBorder);
		
		this.addPlayerButton.addActionListener(new AddPlayerButtonController(this.addPlayerButton, gameFrame, gameEngine));
		
		this.toolBar.add(this.addPlayerButton);
		this.toolBar.add(this.removePlayerButton);
		this.toolBar.add(this.summaryButton);
		this.toolBar.add(this.multiSpinButton);
		this.spacePanel.setPreferredSize(new Dimension(35, 25));
		add(this.spinButton);
		add(this.spacePanel);
		add(this.toolBar);
	}
	
	public JToolBar getToolBar() 
	{
		return this.toolBar;
	}

	public JButton getAddPlayerButton() 
	{
		return this.addPlayerButton;
	}

	public JButton getRemovePlayerButton() 
	{
		return this.removePlayerButton;
	}

	public JButton getSummaryButton() 
	{
		return this.summaryButton;
	}

	public JButton getMultiSpinButton() 
	{
		return this.multiSpinButton;
	}

	public JPanel getSpacePanel() 
	{
		return this.spacePanel;
	}

	public JButton getSpinButton() 
	{
		return this.spinButton;
	}

}
