public class DecisionMaker {
	private PadMover mover;
	private ScreenAnalyzer analyzer;
	private int lastBallX = 0;
	private int lastBallY = 0;
	private GameDisplayInfos infos;
	
	private double lastBallDirectionX = 0;
	private double lastBallDirectionY = 0;
	
	
	public DecisionMaker(ScreenAnalyzer analyzer, GameDisplayInfos infos)
	{
		this.analyzer = analyzer;
		this.mover = new PadMover();
		this.infos = infos;
	}
	
	public void makeDecision()
	{
		int playerY = this.analyzer.getPlayerY();
		double ballX = this.lastBallX;
		double ballY = this.lastBallY;
		
		
		this.lastBallX = this.analyzer.getBallX();
		this.lastBallY = this.analyzer.getBallY();

		
		double ballDirectionX = this.lastBallX - ballX;
		double ballDirectionY = this.lastBallY - ballY;
		
		double magnitude = Math.sqrt(Math.pow(ballDirectionX, 2) + Math.pow(ballDirectionY, 2)); 
		
		if(magnitude > 0)
		{
			ballDirectionX/=magnitude;
			ballDirectionY/=magnitude;
		}
		
		if(this.lastBallDirectionX != 0 && this.lastBallDirectionY != 0 && ballDirectionX != 0 && ballDirectionY != 0 && Math.abs(this.lastBallDirectionX-ballDirectionX) < 0.01f && Math.abs(this.lastBallDirectionY-ballDirectionY) < 0.01f)
		{
			if(ballDirectionX > 0)
			{
				while(ballX+this.infos.getBallWidth() < this.infos.getGameWidth()-this.infos.getPadWidth())
				{
					ballX+=ballDirectionX;
					ballY+=ballDirectionY;
					
					if(ballY < 0 || ballY+this.infos.getBallWidth() > this.infos.getGameHeight())
						ballDirectionY = -ballDirectionY;
				}

				
				while(!(ballY+this.infos.getBallWidth() > playerY && ballY < playerY+this.infos.getPadHeight()))
				{
					
					if(ballY + this.infos.getBallWidth() < playerY)
					{
						this.mover.goUp();
					}
					
					else
					{
						this.mover.goDown();
					}
					
					this.analyzer.update();
					playerY = this.analyzer.getPlayerY();
					this.mover.releaseAll();
				}
			}
		}
		
		this.lastBallDirectionX = ballDirectionX;
		this.lastBallDirectionY = ballDirectionY;
	}
}
