import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class ScreenAnalyzer
{
	private PadPositionFinder padPosFinder;
	private BallPositionFinder ballPositionFinder;
	private GameDisplayInfos infos;
	
	private Robot robot;
	
	private int playerY = 0;
	private int ballX = 0;
	private int ballY = 0;
	private boolean ballFound = false;
	
	public ScreenAnalyzer(GameDisplayInfos infos)
	{
		this.infos = infos;
		
		try
		{
			this.robot = new Robot();
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
		
		
		this.padPosFinder = new PadPositionFinder(this, this.infos);
		this.ballPositionFinder = new BallPositionFinder(this, this.infos);
	}
	
	public void setBallFound(boolean found)
	{
		this.ballFound = found;
	}
	
	public void update()
	{
		this.padPosFinder.update();
		this.ballPositionFinder.update();
	}
	
	public void setPlayerY(int y)
	{
		this.playerY = y;
	}
	
	public void setBallPosition(int x, int y)
	{
		this.ballX = x;
		this.ballY = y;
	}
	
	public int getPlayerY()
	{
		return this.playerY;
	}
	
	public int getBallX()
	{
		return this.ballX;
	}
	
	public int getBallY()
	{
		return this.ballY;
	}
}