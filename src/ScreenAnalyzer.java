import java.awt.AWTException;
import java.awt.Color;
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
	private int analysisFramerate = 1;
	private boolean analyzing = false;
	private BufferedImage playerPadImage;
	private long last;
	
	private int lastPlayerY = 0;
	private int currentBallX = 0;
	private int currentBallY = 0;
	private int lastBallX = 0;
	private int lastBallY = 0;
	
	private int ballDirectionX = 0;
	private int ballDirectionY = 0;
	
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
		
		this.lastBallX = this.data.getGameWidth()/2-this.data.getBallWidth()/2;
		this.lastBallY = this.data.getGameHeight()/2-this.data.getBallWidth()/2;
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
				
				this.playerPadImage = this.robot.createScreenCapture(new Rectangle(this.data.getGameCornerX()+this.data.getGameWidth()-this.data.getPadWidth(), this.data.getGameCornerY(), 1, this.data.getGameHeight()));

				this.findLastPlayerY();
				this.findLastBallY();
				this.calculateBallDirection();

				
			}
			
		}
		
	}
	
	private void findLastPlayerY()
	{
		int lastPlayerY = 0;
		Color color;
		
		do
		{
			color = this.getColor(this.playerPadImage.getRGB(0, lastPlayerY));
			
			lastPlayerY++;
			  
		} while((color.getGreen() != 255 || color.getBlue() != 255 || color.getRed() != 255) && lastPlayerY < this.data.getGameHeight());
		
		this.lastPlayerY = lastPlayerY;
		System.out.println(this.lastPlayerY);
	}
	
	private void findLastBallY()
	{
	
		
		
	}
	
	private Color getColor(int color)
	{
		int red   = (color & 0x00ff0000) >> 16;
		int green = (color & 0x0000ff00) >> 8;
		int blue  =  color & 0x000000ff;
		
		return new Color(red, green, blue);
	}
	
	private void calculateBallDirection()
	{
		this.ballDirectionX = this.currentBallX - this.lastBallX;
		this.ballDirectionY = this.currentBallY - this.lastBallY;
		
	}
}