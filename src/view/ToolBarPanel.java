package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;

import controller.ButtonController;
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
	private JButton spinButton = new JButton("   SPIN!   ");

	public ToolBarPanel(GameEngine gameEngine, GameFrame gameFrame) 
	{
		setLayout(new FlowLayout());
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);	
		setBorder(blackBorder);
		
		addPlayerButton.addActionListener(new ButtonController(addPlayerButton, gameFrame, gameEngine));
		
		toolBar.add(addPlayerButton);
		toolBar.add(removePlayerButton);
		toolBar.add(summaryButton);
		toolBar.add(multiSpinButton);
		spacePanel.setPreferredSize(new Dimension(35, 25));
		add(spinButton);
		add(spacePanel);
		add(toolBar);
	}

}
