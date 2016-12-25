import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class ScreenAnalyzer
{
	private PadPositionFinder padPosFinder;
	private BallPositionFinder ballPositionFinder;
	private GameDisplayInfos infos;
	
	private int playerY = 0;
	private int ballX = 0;
	private int ballY = 0;
	
	public ScreenAnalyzer(GameDisplayInfos infos)
	{
		this.infos = infos;
		
		
		this.padPosFinder = new PadPositionFinder(this, this.infos);
		this.ballPositionFinder = new BallPositionFinder(this, this.infos);
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