
public class PongRobot implements Runnable {
	private GameDisplayInfos infos;
	private ScreenAnalyzer analyzer;
	private DecisionMaker decisionMaker;
	
	private boolean running = false;
	private int updateSpeed = 20;
	private long lastTime = 0;
	
	public PongRobot()
	{
		this.infos = new GameDisplayInfos();
		this.infos.loadConfiguration();
		this.analyzer = new ScreenAnalyzer(this.infos);
		this.decisionMaker = new DecisionMaker(this.analyzer, this.infos);
	}
	
	public void setUpdateSpeed(int speed)
	{
		this.updateSpeed = speed;
	}
	
	public void stop()
	{
		this.running = false;
	}
	
	public void run()
	{
		this.running = true;
		
		while(this.running)
		{
			if(System.currentTimeMillis() - lastTime > this.updateSpeed)
			{
				this.lastTime = System.currentTimeMillis();
				this.analyzer.update();
				this.decisionMaker.makeDecision();
			}
		}
	}
}
