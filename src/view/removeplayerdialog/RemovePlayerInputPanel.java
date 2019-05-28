package view.removeplayerdialog;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import controller.main.CancelButtonController;
import controller.removeplayer.dialog.RemoveButtonController;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.main.GameFrame;

@SuppressWarnings("serial")
public class RemovePlayerInputPanel extends JPanel 
{
	private JComboBox<Object> playerSelectComboBox = new JComboBox<Object>();
	private JButton removeButton = new JButton("Remove");
	private JButton cancelButton = new JButton("Cancel");
	
	public RemovePlayerInputPanel(GameEngine gameEngine, RemovePlayerDialog dialog, GameFrame gameFrame)
	{
		setLayout(new FlowLayout());

		for (Player player : gameEngine.getAllPlayers())
		{
			// use a wrapper class to provide readable toString based labels to the user
			playerSelectComboBox.addItem(new ComboObject(player.getPlayerName(), player));
		}
		
		add(this.playerSelectComboBox);
		add(this.removeButton);
		add(this.cancelButton);
		
		removeButton.addActionListener(new RemoveButtonController(this, dialog, gameFrame, gameEngine));
		cancelButton.addActionListener(new CancelButtonController(this.cancelButton, dialog, gameFrame, gameEngine));
	}

	public Player getSelection() 
	{
		return ((ComboObject) playerSelectComboBox.getSelectedItem()).getPlayer();
	}
}

