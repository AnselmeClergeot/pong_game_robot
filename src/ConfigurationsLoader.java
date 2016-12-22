import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigurationsLoader implements Runnable {
	
	private String filePath = "game_infos/configurations.txt";
	private ScreenAnalyzer toLoad;
	
	public ConfigurationsLoader(ScreenAnalyzer toLoad)
	{
		this.toLoad = toLoad;
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
						this.toLoad.setGameCornerX(paramValue);
					break;
					
					case "gameCornerY" :
						this.toLoad.setGameCornerY(paramValue);
					break;
						
					case "ballWidth" :
						this.toLoad.setBallWidth(paramValue);
					break;
						
					case "padWidth" :
						this.toLoad.setPadWidth(paramValue);
					break;
						
					case "padHeight" :
						this.toLoad.setPadHeight(paramValue);
					break;
						
					case "topLimitY" :
						this.toLoad.setTopLimitY(paramValue);
					break;
					
					case "botLimitY" :
						this.toLoad.setBotLimitY(paramValue);
					break;
					
					case "enemyPadX" :
						this.toLoad.setEnemyPadX(paramValue);
					break;
						
					case "playerPadX" :
						this.toLoad.setPlayerPadX(paramValue);
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
}