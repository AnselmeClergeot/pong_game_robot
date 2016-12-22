
public class ScreenAnalyzer {
	
	private int gameCornerX = 0;
	private int gameCornerY = 0;
	private int ballWidth = 0;
	private int padWidth = 0;
	private int padHeight = 0;
	private int topLimitY = 0;
	private int botLimitY = 0;
	private int enemyPadX = 0;
	private int playerPadX = 0;
	
	
	public ScreenAnalyzer()
	{
		
	}
	
	public void setGameCornerX(int value)
	{
		
		this.gameCornerX = value;
	}
	public void setGameCornerY(int value)
	{
		this.gameCornerY = value;
	}
	public void setBallWidth(int value)
	{
		this.ballWidth = value;
	}
	public void setPadWidth(int value)
	{
		this.padWidth = value;
	}
	public void setPadHeight(int value)
	{
		this.padHeight = value;
	}
	public void setTopLimitY(int value)
	{
		this.topLimitY = value;
	}
	public void setBotLimitY(int value)
	{
		this.botLimitY = value;
	}
	public void setEnemyPadX(int value)
	{
		this.enemyPadX = value;
	}
	public void setPlayerPadX(int value)
	{
		this.playerPadX = value;
	}
	
	public void debug()
	{
		System.out.println(this.gameCornerX);
		System.out.println(this.gameCornerY);
		System.out.println(this.ballWidth);
		System.out.println(this.padWidth);
		System.out.println(this.padHeight);
		System.out.println(this.topLimitY);
		System.out.println(this.botLimitY);
		System.out.println(this.enemyPadX);
		System.out.println(this.playerPadX);
	}
}
