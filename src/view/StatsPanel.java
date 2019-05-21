package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class StatsPanel extends JPanel {

	public StatsPanel()
	{
		setLayout(new GridLayout(3, 1, 2, 2));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);		
	
		PlayerSummaryPanel playerSummaryPanel1 = new PlayerSummaryPanel();
		PlayerSummaryPanel playerSummaryPanel2 = new PlayerSummaryPanel();
		PlayerSummaryPanel playerSummaryPanel3 = new PlayerSummaryPanel();
		
		playerSummaryPanel1.setBorder(blackBorder);
		playerSummaryPanel2.setBorder(blackBorder);
		playerSummaryPanel3.setBorder(blackBorder);
		
		add(playerSummaryPanel1);
		add(playerSummaryPanel2);
		add(playerSummaryPanel3);

	}
}
