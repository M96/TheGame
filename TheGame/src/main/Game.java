package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements Runnable,KeyListener {

	MainClass graphic;
	
	Game(MainClass parent) {
		graphic = parent;
		graphic.canvas.addKeyListener(this);
		graphic.canvas.requestFocus();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==e.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
