public class Main {
	
	public static void main(String args[])
	{
		ScreenAnalyzer eyesOfPlayer = new ScreenAnalyzer();
		ConfigurationsLoader loader = new ConfigurationsLoader(eyesOfPlayer);
		loader.load();
	}
}
