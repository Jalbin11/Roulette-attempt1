package view.addplayerdialog;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel 
{

	private JLabel nameLabel = new JLabel("Enter player name: ");
	private JTextField nameField = new JTextField();
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("Cancel");
	
	public InputPanel()
	{
		setLayout(new FlowLayout());
		add(nameLabel);
		add(nameField);
		add(okButton);
		add(cancelButton);
	}
}

