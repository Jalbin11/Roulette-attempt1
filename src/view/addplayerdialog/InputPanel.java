package view.addplayerdialog;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.addplayerdialog.CancelButtonController;
import controller.addplayerdialog.AddButtonController;
import model.interfaces.GameEngine;
import view.main.GameFrame;

@SuppressWarnings("serial")
public class InputPanel extends JPanel 
{

	private JLabel nameLabel = new JLabel("Enter player name: ");
	private JTextField nameField = new JTextField();
	private JButton addButton = new JButton("Add");
	private JButton cancelButton = new JButton("Cancel");
	
	public InputPanel(GameEngine gameEngine, AddPlayerDialog dialog, GameFrame gameFrame)
	{
		setLayout(new FlowLayout());
		this.nameField.setColumns(15);
		
		add(this.nameLabel);
		add(this.nameField);
		add(this.addButton);
		add(this.cancelButton);
		
		addButton.addActionListener(new AddButtonController(this.addButton, dialog, gameFrame, gameEngine));
		cancelButton.addActionListener(new CancelButtonController(this.cancelButton, dialog, gameFrame, gameEngine));
	}

	public JTextField getNameField() 
	{
		return this.nameField;
	}
}

