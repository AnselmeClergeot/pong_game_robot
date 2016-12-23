import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigurationsLoader implements Runnable {
	
	private String filePath = "game_infos/configurations.txt";
	
	private int gameCornerX = 0;
	private int gameCornerY = 0;
	private int gameWidth = 0;
	private int gameHeight = 0;
	private int ballWidth = 0;
	private int padWidth = 0;
	private int padHeight = 0;
	private int ballZoneY = 0;
	private int ballZoneWidth = 0;
	
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
					
					case "gameWidth" :
						this.gameWidth = paramValue;
					break;
					
					case "gameHeight" :
						this.gameHeight = paramValue;
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
					
					case "ballZoneY" :
						this.ballZoneY = paramValue;
					break;
					
					case "ballZoneWidth" :
						this.ballZoneWidth = paramValue;
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
	public int getGameWidth()
	{
		return this.gameWidth;
	}
	public int getGameHeight()
	{
		return this.gameHeight;
	}
	public int getBallZoneY()
	{
		return this.ballZoneY;
	}
	public int getBallZoneWidth()
	{
		return this.ballZoneWidth;
	}
}