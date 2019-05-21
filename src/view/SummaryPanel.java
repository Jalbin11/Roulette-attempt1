package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel 
{

	public SummaryPanel() 
	{
		setLayout(new BorderLayout());
		add(new MenuBar(), BorderLayout.NORTH);
		add(new StatsPanel(), BorderLayout.SOUTH);
		add(new ToolBarPanel(), BorderLayout.CENTER);
	}

}
