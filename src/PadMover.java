import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class PadMover {
	
	private Robot robot;
	
	public PadMover()
	{
		try
		{
			this.robot = new Robot();
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
	}
	
	public void goDown()
	{
		this.robot.keyRelease(KeyEvent.VK_K);
		this.robot.keyPress(KeyEvent.VK_M);
	}
	

	
	public void goUp()
	{
		this.robot.keyRelease(KeyEvent.VK_M);
		this.robot.keyPress(KeyEvent.VK_K);
	}
	
	public void releaseAll()
	{
		this.robot.keyRelease(KeyEvent.VK_M);
		this.robot.keyRelease(KeyEvent.VK_K);
	}
	
	
	
}
