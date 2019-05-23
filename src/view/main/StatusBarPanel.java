package view.main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.GameEngine;
import view.enumerations.GameStatus;

@SuppressWarnings("serial")
public class StatusBarPanel extends JPanel 
{
	private JLabel playerCountStatusLabel = new JLabel("Players: 0", JLabel.CENTER);
	private JLabel readyStatusLabel = new JLabel(GameStatus.ADDPLAYERS.statusString(), JLabel.CENTER);
	private JLabel spinCountLabel = new JLabel("Total Spins: 0", JLabel.CENTER);

	private final int rows = 1;
	private final int cols = 3;
	
	public StatusBarPanel(GameEngine gameEngine, GameFrame gameFrame)
	{
		setLayout(new GridLayout(rows, cols));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		
		this.playerCountStatusLabel.setBorder(blackBorder);
		this.readyStatusLabel.setBorder(blackBorder);
		this.spinCountLabel.setBorder(blackBorder);

		add(this.playerCountStatusLabel);
		add(this.readyStatusLabel);
		add(this.spinCountLabel);
	}
		
	public JLabel getPlayerCountStatusLabel() 
	{
		return this.playerCountStatusLabel;
	}

	public JLabel getReadyStatusLabel() 
	{
		return this.readyStatusLabel;
	}

	public JLabel getSpinCountLabel() 
	{
		return this.spinCountLabel;
	}
}
