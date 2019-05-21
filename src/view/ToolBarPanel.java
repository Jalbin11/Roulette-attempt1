package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class ToolBarPanel extends JPanel {

	private JToolBar toolBar = new JToolBar();
	private JButton button1 = new JButton("Button one");
	private JButton button2 = new JButton("Button two");
	private JButton button3 = new JButton("Button three");
	private JButton button4 = new JButton("Button four");
	private JButton button5 = new JButton("Button five");
	private JButton button6 = new JButton("Button six");
	private JButton spinButton = new JButton("Spin");

	public ToolBarPanel() {
		setLayout(new BorderLayout());
		toolBar.add(button1);
		toolBar.add(button2);
		toolBar.add(button3);
		toolBar.add(button4);
		toolBar.add(button5);
		toolBar.add(button6);
		add(toolBar, BorderLayout.CENTER);
		add(spinButton, BorderLayout.WEST);
	}

}
