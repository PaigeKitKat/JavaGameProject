package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import Inputs.*;

public class GamePanel extends JPanel {
	
	private KeyboardInput keyboardInput;
	private MouseInput mouseInput;
	private int xDel = 0,yDel = 0;


	public GamePanel() {
		keyboardInput = new KeyboardInput(this);
		mouseInput = new MouseInput(this);
	
		addKeyListener(keyboardInput);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}
	
	public void changeXDelta(float x) {
		this.xDel += x;
	}
	
	public void changeYDelta(float y) {
		this.yDel += y;
	}
	
	public void setRectPos(int x, int y) {
		int dX = ((int)(x / 32.0f)) * 32;
		int dY = ((int)(y / 32.0f)) * 32;
		this.xDel = dX;
		this.yDel = dY;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//		   XPOS|YPOS|YSZ|XSZ
		g.setColor(new Color(0,0,0));
		g.fillRect(xDel, yDel, 32, 32);
		

	}
}
