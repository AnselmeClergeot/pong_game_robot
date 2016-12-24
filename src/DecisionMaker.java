
public class DecisionMaker {
	private PadMover mover;
	private ScreenAnalyzer analyzer;
	private BallPositionPredictor predictor;	
	private int lastBallX = 0;
	private int lastBallY = 0;
	private GameDisplayInfos infos;
	
	public DecisionMaker(ScreenAnalyzer analyzer, GameDisplayInfos infos)
	{
		this.analyzer = analyzer;
		this.mover = new PadMover();
		this.predictor = new BallPositionPredictor(infos);
		this.infos = infos;
	}
	
	public void makeDecision()
	{
		
		int playerY = this.analyzer.getPlayerY();
		double ballX = this.lastBallX;
		double ballY = this.lastBallY;
		
		
		this.lastBallX = this.analyzer.getBallX();
		this.lastBallY = this.analyzer.getBallY();
		
		
		int y = 0;
		double ballDirectionX = this.lastBallX - ballX;
		double ballDirectionY = this.lastBallY - ballY;
		
		double magnitude = Math.sqrt(Math.pow(ballDirectionX, 2) + Math.pow(ballDirectionY, 2)); 
		
		if(magnitude > 0)
		{
			ballDirectionX/=magnitude;
			ballDirectionY/=magnitude;
		}
		
		if(ballDirectionX > 0)
		{
			while(ballX < this.infos.getGameWidth()-this.infos.getPadWidth())
			{
				ballX+=ballDirectionX;
				ballY+=ballDirectionY;
				
				if(ballY < 0 || ballY > this.infos.getGameHeight())
					ballDirectionY = -ballDirectionY;
			}
			
			System.out.println(ballY);
			
			while(!(playerY > ballY - 100 && playerY < ballY+100))
			{
				
				if(playerY > ballY)
				{
					this.mover.goUp();
				}
				else
				{
					this.mover.goDown();
				}
				
				this.analyzer.update();
				playerY = this.analyzer.getPlayerY();
			}
			this.mover.releaseAll();
		}
		
		
	}
}
