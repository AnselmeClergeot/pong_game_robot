import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigurationsLoader implements Runnable {
	
	private String filePath = "game_infos/configurations.txt";
	
	private int gameCornerX = 0;
	private int gameCornerY = 0;
	private int ballWidth = 0;
	private int padWidth = 0;
	private int padHeight = 0;
	private int topLimitY = 0;
	private int botLimitY = 0;
	private int enemyPadX = 0;
	private int playerPadX = 0;
	
	public ConfigurationsLoader()
	{
		
	}
	
	public void run()
	{
		try(Scanner scanner = new Scanner(new File(this.filePath)))
		{
			while(scanner.hasNext())
			{
				String parameter = scanner.next();
				int paramValue = scanner.nextInt();
				
				switch(parameter)
				{
					case "gameCornerX" :
						this.gameCornerX = paramValue;
					break;
					
					case "gameCornerY" :
						this.gameCornerY = paramValue;
					break;
						
					case "ballWidth" :
						this.ballWidth = paramValue;
					break;
						
					case "padWidth" :
						this.padWidth = paramValue;
					break;
						
					case "padHeight" :
						this.padHeight = paramValue;
					break;
						
					case "topLimitY" :
						this.topLimitY = paramValue;
					break;
					
					case "botLimitY" :
						this.botLimitY = paramValue;
					break;
					
					case "enemyPadX" :
						this.enemyPadX = paramValue;
					break;
						
					case "playerPadX" :
						this.playerPadX = paramValue;
					break;
						
					default :
						
					break;
				}
			}
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public int getGameCornerX()
	{
		return this.gameCornerX;
	}
	public int getGameCornerY()
	{
		return this.gameCornerY;
	}
	public int getBallWidth()
	{
		return this.ballWidth;
	}
	public int getPadWidth()
	{
		return this.padWidth;
	}
	public int getPadHeight()
	{
		return this.padHeight;
	}
	public int getTopLimitY()
	{
		return this.topLimitY;
	}
	public int getBotLimitY()
	{
		return this.botLimitY;
	}
	public int getEnemyPadX()
	{
		return this.enemyPadX;
	}
	public int getPlayerPadX()
	{
		return this.playerPadX;
	}
}