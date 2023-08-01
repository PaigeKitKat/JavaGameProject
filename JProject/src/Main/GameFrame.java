package Main;

import javax.swing.JFrame;

public class GameFrame {
	private JFrame jframe;
	
	public GameFrame(GamePanel gamePanel,int xWidth, int yWidth) {
		jframe = new JFrame();
		
		jframe.setSize(32*xWidth,32*yWidth);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setVisible(true);
	}
}
