package view.main;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.main.SubmitBetButtonController;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class PlayerSummaryPanel extends JPanel
{	
	private int id;
	private JPanel lockPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private boolean hasPlacedBet = false;
	private CardLayout cardLayout = new CardLayout();

	private final int rows = 1;
	private final int cols = 8;
	private JLabel lockLabel = new JLabel("");
	private JLabel nameLabel = new JLabel("", JLabel.CENTER);
	private JLabel pointsLabel = new JLabel("", JLabel.CENTER);
	private JLabel currentBetLabel = new JLabel("Current bet: none", JLabel.CENTER);
	private JLabel lastOutcomeLabel = new JLabel("Last win/loss: none", JLabel.CENTER);
	private JLabel betAmountLabel = new JLabel("Bet amount and type: ", JLabel.RIGHT);
	private JTextField betAmountField = new JTextField("0");
	private JButton submitBetButton = new JButton("PLACE BET");
	private JComboBox<BetType> betTypeComboBox = new JComboBox<BetType>(BetType.values());
	
	public PlayerSummaryPanel(Player newPlayer, GameEngine gameEngine, GameFrame gameFrame)
	{
		nameLabel.setText(newPlayer.getPlayerName()); 
		pointsLabel.setText("Points: " + newPlayer.getPoints());
		id = Integer.parseInt(newPlayer.getPlayerId());
	
		// use cardlayout to hot swap panels
		setLayout(cardLayout);
		
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
		
		add(mainPanel, "Main panel");
		add(lockPanel, "Lock panel");
			
		// listeners
		submitBetButton.addActionListener(new SubmitBetButtonController(this, gameFrame, gameEngine));
	}
	
	public void update(Player player)
	{
		// panel will still have old points and bet values, compare
		// with new player values to derive outcomes
		
		int prevPoints = 0;
		int newPoints = player.getPoints();
		prevPoints = Integer.parseInt(pointsLabel.getText().replaceAll("[\\D]", ""));
		pointsLabel.setText("Points: " + newPoints);
		
		if (newPoints > prevPoints)
		{
			lastOutcomeLabel.setText("Last spin: WIN +" + (newPoints - prevPoints));		
		}
		
		if (newPoints < prevPoints)
		{
			lastOutcomeLabel.setText("Last spin: LOSS " + (newPoints - prevPoints));		
		}
		
		if (newPoints == prevPoints)
		{
			lastOutcomeLabel.setText("Last spin: No bet");
		}	
	}
		
	// swap panels to show "locked" panel
	public void lock(Player player) 
	{
		// update the panel label to reflect bet status
		if(hasPlacedBet)
		{
			lockLabel.setText(player.getPlayerName() + " places a " + player.getBet() + " point bet on " + player.getBetType()); 
			cardLayout.show(this, "Lock panel");		
		}		
		
		// if no bet placed show NO BET
		if(!hasPlacedBet)
		{
			lockLabel.setText(player.getPlayerName() + " places no bet"); 
			cardLayout.show(this, "Lock panel");	
		}
	}
	
	// swap panels to show functional panel
	public void unlock()
	{
		cardLayout.show(this, "Main panel");	
	}
	
	// boolean flag, panel should be locked once player places bet if true
	public void setHasPlacedBet(boolean b) 
	{
		this.hasPlacedBet = b;
	}

	public void setBet(int bet) 
	{
		this.currentBetLabel.setText("Current bet: " + bet);
	}
	
	public boolean getHasPlacedBet() 
	{
		return this.hasPlacedBet;
	}
	
	public JTextField getBetAmountField() 
	{
		return betAmountField;
	}

	public JComboBox<BetType> getBetTypeComboBox() 
	{
		return betTypeComboBox;
	}
	
	public int getId() 
	{
		return id;
	}


}
