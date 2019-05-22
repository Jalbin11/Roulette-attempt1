package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class StatsPanel extends JPanel {

	public StatsPanel(GameEngine gameEngine, GameFrame gameFrame)
	{
		setLayout(new GridLayout(3, 1, 0, 0));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);		
	
		PlayerSummaryPanel playerSummaryPanel1 = new PlayerSummaryPanel();
		PlayerSummaryPanel playerSummaryPanel2 = new PlayerSummaryPanel();
		PlayerSummaryPanel playerSummaryPanel3 = new PlayerSummaryPanel();
		
		setBorder(blackBorder);
		
		add(playerSummaryPanel1);
		add(playerSummaryPanel2);
		add(playerSummaryPanel3);

	}
}
