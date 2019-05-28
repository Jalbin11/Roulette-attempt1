package view.removeplayerdialog;

import model.interfaces.Player;

public class ComboObject 
{
    private String label;
	private Player player;
	
	// wrapper for specific combobox labeling
	public ComboObject(String label, Player player) 
	{
        this.player = player;
        this.label = label;
	}
	
    @Override
    public String toString() 
    {
        return label;
    }

    public String getLabel() 
    {
		return label;
	}

	public Player getPlayer() 
	{
		return player;
	}

}
