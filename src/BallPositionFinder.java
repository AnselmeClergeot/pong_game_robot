import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BallPositionFinder {
	
	private BufferedImage screenCapture;
	private ScreenAnalyzer analyzer;
	private GameDisplayInfos infos;
	private Robot robot;
	
	public BallPositionFinder(ScreenAnalyzer analyzer, GameDisplayInfos infos)
	{
		this.analyzer = analyzer;
		this.infos = infos;
		
		try
		{
			this.robot = new Robot();
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
	}
	
	public void update()
	{
		this.screenCapture = this.robot.createScreenCapture(new Rectangle(this.infos.getGameCornerX(), this.infos.getGameCornerY()+this.infos.getBallZoneY(), this.infos.getBallZoneWidth(), this.infos.getGameHeight()-this.infos.getBallZoneY()));
		try
		{
			File f = new File("test.png");
			ImageIO.write(this.screenCapture, "png", f);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		int x = 0;
		int y = 0;
		
		boolean foundBall = false;
		
		for(y = 0; y < this.screenCapture.getHeight(); y++)
		{
			for(x = 0; x < this.screenCapture.getWidth(); x++)
			{
				Color color = this.getColor(this.screenCapture.getRGB(x, y));
				
				if(color.getRed() == 255 && color.getGreen() == 255)
				{
					if(this.isBall(x, y))
					{
						this.analyzer.setBallPosition(x, y);
						foundBall = true;
						break;
					}
					
				}
			}
			if(foundBall)
				break;
		}	
	}
	
	private Color getColor(int color)
	{
		int red   = (color & 0x00ff0000) >> 16;
		int green = (color & 0x0000ff00) >> 8;
		int blue  =  color & 0x000000ff;
		
		return new Color(red, green, blue);
	}
	
	public boolean isBall(int x, int y)
	{
		boolean isBall = true;
		
		int xi = 0;
		int yi  = 0;
		
		for(xi = 0; xi < this.infos.getBallWidth()-3; xi++)
		{
			for(yi = 0; yi < this.infos.getBallWidth()-3; yi++)
			{
				if(x+xi < this.screenCapture.getWidth() && y+yi < this.screenCapture.getHeight())
				{
					Color color = this.getColor(this.screenCapture.getRGB(x+xi, y+yi));
					if(color.getGreen() != 255 || color.getBlue() != 255 || color.getRed() != 255)
					{
						isBall = false;
					}
				}
				
			}
		}
		return isBall;
	}
}
