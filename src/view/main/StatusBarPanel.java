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
	private final int rows = 1;
	private final int cols = 3;
	private int spinCount= 0;
	
	private JLabel playerCountStatusLabel = new JLabel("Players: 0", JLabel.CENTER);
	private JLabel readyStatusLabel = new JLabel(GameStatus.ADDPLAYERS.statusString(), JLabel.CENTER);
	private JLabel spinCountLabel = new JLabel("Total Spins: " + spinCount, JLabel.CENTER);
	
	public StatusBarPanel()
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
		
	public void setPlayerCount(GameEngine gameEngine) 
	{
		this.playerCountStatusLabel.setText("Players: " + gameEngine.getAllPlayers().size());
	}

	public void setStatus(GameStatus status) 
	{
		this.readyStatusLabel.setText(status.statusString());
	}

	public void incrementSpinCount() 
	{
		this.spinCount++;
		this.spinCountLabel.setText("Total Spins: " + spinCount);
	}
}
