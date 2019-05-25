package view.main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.main.BetAmountFieldController;
import controller.main.SubmitBetButtonController;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class PlayerSummaryPanel extends JPanel
{	
	private String id = "";
	private JPanel lockPanel = new JPanel();;
	private JPanel mainPanel = new JPanel();
	private boolean locked = false;
	private final int rows = 1;
	private final int cols = 8;
	
	private JLabel lockLabel = new JLabel("");
	private JLabel nameLabel = new JLabel("", JLabel.CENTER);
	private JLabel pointsLabel = new JLabel("", JLabel.CENTER);
	private JLabel currentBetLabel = new JLabel("Current bet: none", JLabel.CENTER);
	private JLabel lastOutcomeLabel = new JLabel("Last win/loss: none", JLabel.CENTER);
	private JLabel betAmountLabel = new JLabel("Bet amount and type: ", JLabel.RIGHT);
	private JTextField betAmountField = new JTextField("1");
	private JButton submitBetButton = new JButton("PLACE BET");
	private JComboBox<BetType> betTypeComboBox = new JComboBox<BetType>(BetType.values());
	
	public PlayerSummaryPanel(Player newPlayer, GameEngine gameEngine, GameFrame gameFrame)
	{
		nameLabel.setText(newPlayer.getPlayerName()); 
		pointsLabel.setText("Points: " + newPlayer.getPoints());
		id = newPlayer.getPlayerId();
		
		// use a CardLayout to swap the panel between functional and locked views when bet is finalised
		
		// lock panel
		lockPanel.add(lockLabel);
		
		// main panel
		mainPanel.setLayout(new GridLayout(rows, cols));
		mainPanel.add(nameLabel);
		mainPanel.add(pointsLabel);
		mainPanel.add(currentBetLabel);
		mainPanel.add(lastOutcomeLabel);
		mainPanel.add(betAmountLabel);
		mainPanel.add(betAmountField);
		mainPanel.add(betTypeComboBox);
		mainPanel.add(submitBetButton);
		
		// listeners
		submitBetButton.addActionListener(new SubmitBetButtonController(this, gameFrame, gameEngine));
		betAmountField.addFocusListener(new BetAmountFieldController(this, gameFrame, gameEngine));
	}
		
	public void lock(Player player) 
	{
		this = lockPanel;
		if (!this.locked)
		{
			
			
		}
	}
	
	public void unlock()
	{
		if (this.locked)
		{
			
		}		
	}
	
	public JTextField getBetAmountField() 
	{
		return betAmountField;
	}
	
	public JLabel getPointsLabel() 
	{
		return pointsLabel;
	}

	public JComboBox<BetType> getBetTypeComboBox() 
	{
		return betTypeComboBox;
	}
	
	public String getId() 
	{
		return id;
	}

}
