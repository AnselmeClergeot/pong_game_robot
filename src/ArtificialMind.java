
public class ArtificialMind {
	
	private KeyboardPresser keyPresser;
	private ScreenAnalyzer screenAnalyzer;
	private ConfigurationsLoader loader;
	
	public ArtificialMind()
	{
		this.keyPresser = new KeyboardPresser();
		this.screenAnalyzer = new ScreenAnalyzer();
		this.loader = new ConfigurationsLoader(this.screenAnalyzer);
		
		Thread loadingThread = new Thread(this.loader);
		loadingThread.start();
	}
}
