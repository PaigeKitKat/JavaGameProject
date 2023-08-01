package Main;

public class Game implements Runnable {
	private GamePanel gamePanel;
	private GameFrame gameFrame;
	private Thread gameThread;
	
	private final int FPSSET = 144; 

	
	public Game() {
		gamePanel = new GamePanel();
		gameFrame = new GameFrame(gamePanel,10,10);
		gamePanel.requestFocus();
		startGameLoop();
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		int frames = 0;
		long lastCheck = System.currentTimeMillis();
		
		double timePerFrame = 1000000000.0/FPSSET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		while(true) {
			now = System.nanoTime();
			if(now - lastFrame >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = now;
				frames++;
			}
			
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		

	}
}
