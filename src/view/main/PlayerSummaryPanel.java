package view.main;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.enumeration.BetType;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class PlayerSummaryPanel extends JPanel
{
	private JLabel nameLabel = new JLabel("Name: ", JLabel.CENTER);
	private JLabel pointsLabel = new JLabel("Current points: ", JLabel.CENTER);
	private JLabel currentBetLabel = new JLabel("Current bet: ", JLabel.CENTER);
	private JLabel lastOutcomeLabel = new JLabel("Last win/loss: ", JLabel.CENTER);
	private JLabel betAmountLabel = new JLabel("Edit bet amount: ", JLabel.RIGHT);
	private JTextField betAmountField = new JTextField();
	private JLabel betTypeLabel = new JLabel("Select bet type: ", JLabel.RIGHT);
	private JComboBox<BetType> betTypeComboBox = new JComboBox<BetType>();
	
	public PlayerSummaryPanel(Player newPlayer)
	{
		this.nameLabel.setText("Player name: " + newPlayer.getPlayerName()); 
		this.pointsLabel.setText("Points: " + newPlayer.getPoints());
		
		setLayout(new GridLayout(1, 8));
		add(this.nameLabel);
		add(this.pointsLabel);
		add(this.currentBetLabel);
		add(this.lastOutcomeLabel);
		add(this.betAmountLabel);
		add(this.betAmountField);
		add(this.betTypeLabel);
		add(this.betTypeComboBox);
	}
}
