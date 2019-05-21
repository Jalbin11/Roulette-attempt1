package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerSummaryPanel extends JPanel
{
	private JLabel statusLabel1 = new JLabel("status 1", JLabel.CENTER);
	private JLabel statusLabel2 = new JLabel("status 2", JLabel.CENTER);
	private JLabel statusLabel3 = new JLabel("status 3", JLabel.CENTER);
	private JLabel statusLabel4 = new JLabel("status 4", JLabel.CENTER);
	private JLabel statusLabel5 = new JLabel("status 5", JLabel.CENTER);
	private JLabel statusLabel6 = new JLabel("status 6", JLabel.CENTER);
	
	public PlayerSummaryPanel()
	{
		setLayout(new GridLayout(1, 6));
		add(statusLabel1);
		add(statusLabel2);
		add(statusLabel3);
		add(statusLabel4);
		add(statusLabel5);
		add(statusLabel6);
		
		// must show always visible, player names, their current points balance,
		// their current bet (including bet type) and their most recent win/loss calculated according to the betting
		// odds from assignment 1.
	}
}
