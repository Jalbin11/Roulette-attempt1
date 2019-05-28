package view.removeplayerdialog;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import model.interfaces.GameEngine;
import view.main.GameFrame;

@SuppressWarnings("serial")
public class RemovePlayerDialog extends JDialog
{
	private RemovePlayerInputPanel inputPanel;
	
	public RemovePlayerDialog(GameEngine gameEngine, GameFrame gameFrame) 
	{
		super(gameFrame, "Remove a player");
		
		// create dialog and contents
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		populateComponents(gameEngine, this, gameFrame);
		pack();
		
		// set default window position to center of screen
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void populateComponents(GameEngine gameEngine, RemovePlayerDialog dialog, GameFrame gameFrame)
	{
		setLayout(new FlowLayout());
		this.inputPanel = new RemovePlayerInputPanel(gameEngine, dialog, gameFrame);
		add(this.inputPanel);
	}

	public RemovePlayerInputPanel getInputPanel() 
	{
		return this.inputPanel;
	}
}
