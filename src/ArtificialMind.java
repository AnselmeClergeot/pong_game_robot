
public class ArtificialMind {
	
	private KeyboardPresser keyPresser;
	private ScreenAnalyzer screenAnalyzer;
	private ConfigurationsLoader data;
	
	public ArtificialMind()
	{
		this.data = new ConfigurationsLoader();
		this.keyPresser = new KeyboardPresser();
		this.screenAnalyzer = new ScreenAnalyzer(this.data);
		
		
		Thread loadingThread = new Thread(this.data);
		loadingThread.start();
	}
	
	
}
