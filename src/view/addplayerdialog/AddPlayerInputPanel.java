package view.addplayerdialog;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import controller.addplayerdialog.AddButtonController;
import controller.main.CancelButtonController;
import model.interfaces.GameEngine;
import view.main.GameFrame;

@SuppressWarnings("serial")
public class AddPlayerInputPanel extends JPanel 
{

	private JLabel nameLabel = new JLabel("Enter player name: ");
	private JTextField nameField = new JTextField();
	private JLabel pointsLabel = new JLabel("Enter starting points: ");
	private JTextField pointsField = new JTextField("750");
	private JButton addButton = new JButton("Add");
	private JButton cancelButton = new JButton("Cancel");
	
	public AddPlayerInputPanel(GameEngine gameEngine, AddPlayerDialog dialog, GameFrame gameFrame)
	{
		setLayout(new FlowLayout());
		this.nameField.setColumns(15);
		this.pointsField.setColumns(5);
		
		add(this.nameLabel);
		add(this.nameField);
		add(this.pointsLabel);
		add(this.pointsField);
		add(this.addButton);
		add(this.cancelButton);
		
		addButton.addActionListener(new AddButtonController(this.addButton, dialog, gameFrame, gameEngine));
		cancelButton.addActionListener(new CancelButtonController(this.cancelButton, dialog, gameFrame, gameEngine));
	}

	public JTextComponent getNameField() 
	{
		return this.nameField;
	}

	public JTextComponent getPointsField() 
	{
		return this.pointsField;
	}
}

