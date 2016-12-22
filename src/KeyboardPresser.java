import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardPresser {
	
	private Robot robot;
	
	public KeyboardPresser()
	{
		try
		{
			robot = new Robot();
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
	}

	public void movePadDown()
	{	
		this.robot.keyPress(KeyEvent.VK_M);
		this.robot.keyRelease(KeyEvent.VK_M);
	}
	
	public void movePadUp()
	{
		this.robot.keyPress(KeyEvent.VK_K);
		this.robot.keyRelease(KeyEvent.VK_K);
	}
}
