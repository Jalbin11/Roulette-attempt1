package view.addplayerdialog;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import model.interfaces.GameEngine;
import view.main.GameFrame;

@SuppressWarnings("serial")
public class AddPlayerDialog extends JDialog
{
	private InputPanel inputPanel;
	
	public AddPlayerDialog(GameEngine gameEngine, GameFrame gameFrame) 
	{
		super(gameFrame, "Add new player");
		
		// create dialog and contents
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		populateComponents(gameEngine, this, gameFrame);
		pack();
		
		// set default window position to center of screen
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void populateComponents(GameEngine gameEngine, AddPlayerDialog dialog, GameFrame gameFrame)
	{
		setLayout(new FlowLayout());
		this.inputPanel = new InputPanel(gameEngine, dialog, gameFrame);
		add(this.inputPanel);
	}

	public InputPanel getInputPanel() 
	{
		return this.inputPanel;
	}
}
