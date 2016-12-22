import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenAnalyzer implements Runnable	
{
	private ConfigurationsLoader data;
	private Robot robot;
	private int analysisFramerate = 10;
	private boolean analyzing = false;
	private BufferedImage screenImage;
	private long last;
	
	private int lastPlayerY = 0;
	
	public ScreenAnalyzer(ConfigurationsLoader data)
	{
		this.data = data;
		try
		{
			this.robot = new Robot();
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setAnalysisFramerate(int rate)
	{
		this.analysisFramerate = rate;
	}
	
	public void stopAnalyzing()
	{
		this.analyzing = false;
	}
	
	public void run()
	{
		
		this.analyzing = true;
		
		while(this.analyzing)
		{
			if(System.currentTimeMillis() - this.last > this.analysisFramerate)
			{
				this.last = System.currentTimeMillis();
				
				this.screenImage = this.robot.createScreenCapture(new Rectangle(this.data.getGameCornerX(), this.data.getGameCornerY(), this.data.getGameWidth(), this.data.getGameHeight()));
				findLastPlayerY();
			}
			
		}
		
	}
	
	private void findLastPlayerY()
	{
		int lastPlayerY = this.data.getTopLimitY();
		int color = 0;
		int  red   = 0;
		int  green = 0;
		int  blue  = 0;
		
		do
		{
			color = this.screenImage.getRGB(this.data.getPlayerPadX(), lastPlayerY);
			
			red   = (color & 0x00ff0000) >> 16;
			green = (color & 0x0000ff00) >> 8;
			blue  =  color & 0x000000ff;
			
			lastPlayerY++;
			  
		} while(red != 255 || green != 255 || blue != 255 && lastPlayerY > this.data.getBotLimitY());
		
		this.lastPlayerY = lastPlayerY;
	}
}