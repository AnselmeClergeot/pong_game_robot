import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class PadPositionFinder {
	
	private BufferedImage screenCapture;
	private ScreenAnalyzer analyzer;
	private GameDisplayInfos infos;
	private Robot robot;
	
	public PadPositionFinder(ScreenAnalyzer analyzer, GameDisplayInfos infos)
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
		this.screenCapture = this.robot.createScreenCapture(new Rectangle(this.infos.getGameCornerX() + this.infos.getGameWidth()-this.infos.getPadWidth(), this.infos.getGameCornerY(), 1, this.infos.getGameHeight()));
		
		int playerY = 0;
		
		Color color;
		
		do
		{
			color = this.getColor(this.screenCapture.getRGB(0, playerY));
			
			playerY++;
			  
		} while((color.getGreen() != 255 || color.getBlue() != 255 || color.getRed() != 255) && playerY < this.screenCapture.getHeight());
		
		this.analyzer.setPlayerY(playerY);
	}
	
	private Color getColor(int color)
	{
		int red   = (color & 0x00ff0000) >> 16;
		int green = (color & 0x0000ff00) >> 8;
		int blue  =  color & 0x000000ff;
		
		return new Color(red, green, blue);
	}
	
	
}
