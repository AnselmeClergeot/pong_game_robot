public class Main {
	
	public static void main(String args[])
	{
		PongRobot robot = new PongRobot();
		Thread pongRobot = new Thread(robot);
		pongRobot.setDaemon(false);
		pongRobot.start();
	}
}
