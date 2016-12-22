import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;

public class ScreenAnalyzer implements Runnable	
{
	private ConfigurationsLoader data;
	private Robot robot;
	private int analysisFramerate = 10;
	private boolean analyzing = false;
	
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
			
		}
		
	}
}