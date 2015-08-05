package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ListIterator;
import java.util.Vector;

public class Game implements Runnable,KeyListener {

	MainClass graphic;
	Ui ui;
	
	Vector<Sprite> actors;

	Game(MainClass parent) {
		graphic = parent;
		graphic.canvas.addKeyListener(this);
		graphic.canvas.requestFocus();
		
		ui = new Ui();
		
		actors = new Vector<Sprite>();

		actors.add(new CivilBuilding(BiLoader.loadPics("grass.jpg", 1), 50, 50, 1));

	}

	@Override
	public void run() {
		
		doLogic();
		
		moveObjects();
		cloneVectors();
		
		try {
			Thread.sleep(6,250000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cloneVectors() {
		graphic.painter = (Vector<Sprite>) actors.clone();
	}

	private void moveObjects() {
		for(ListIterator<Sprite> it = actors.listIterator();it.hasNext();)
		{
			Sprite r = it.next();
			r.move();
		}
	}
	
	private void doLogic() {
		for(ListIterator<Sprite> it = actors.listIterator();it.hasNext();)
		{
			Sprite r = it.next();
			r.doLogic();
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
