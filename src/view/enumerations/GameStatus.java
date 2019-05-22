package view.enumerations;

public enum GameStatus 
{
	ADDPLAYERS
	{
		@Override
		public String statusString() {
			return "Add players to begin game.";
		}
	},
	READY
	{
		@Override
		public String statusString() {
			return "Ready to spin!";
		}
	},
	INPROGRESS
	{
		@Override
		public String statusString() {
			return "Spin in progress...";
		}
	},
	GAMEOVER
	{

		@Override
		public String statusString() {
			return "Game finished. Spin again?";
		}
	};
	public abstract String statusString();
}