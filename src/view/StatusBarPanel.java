package view;

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

	public StatusBarPanel(GameEngine gameEngine, GameFrame gameFrame)
	{
		setLayout(new GridLayout(1, 3));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		playerCountStatusLabel.setBorder(blackBorder);
		readyStatusLabel.setBorder(blackBorder);
		spinCountLabel.setBorder(blackBorder);

		add(playerCountStatusLabel);
		add(readyStatusLabel);
		add(spinCountLabel);
	}

}
