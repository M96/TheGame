package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ListIterator;
import java.util.Vector;

public class Game implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	private MainClass graphic;
	Ui ui;
	Map map;

	int mouseX, mouseY;
	static int posXonMap, posYonMap;

	private Vector<Sprite> actors;
	
	private static Vector<Sprite> actorsToAdd;

	Game(MainClass parent) {
		graphic = parent;
		graphic.canvas.addKeyListener(this);
		graphic.canvas.addMouseListener(this);
		graphic.canvas.addMouseMotionListener(this);
		graphic.canvas.requestFocus();

		ui = new Ui(this);
		
		map = new Map();
		actors = new Vector<Sprite>();
		actorsToAdd = new Vector<Sprite>();
		
		posXonMap = 0;
		posYonMap = 0;
	}

	@Override
	public void run() {
		while (graphic.frame.isVisible()) {
			doLogic();

			moveObjects();
			cloneVectors();

			try {
				Thread.sleep(6, 250000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	@SuppressWarnings("unchecked")
	private void cloneVectors() {
		graphic.painter = (Vector<Sprite>) actors.clone();
	}

	private void moveObjects() {
		for (ListIterator<Sprite> it = actors.listIterator(); it.hasNext();) {
			Sprite r = it.next();
			r.move();
		}
	}

	private void doLogic() {
		actors.addAll(actorsToAdd);
		actorsToAdd.clear();
		
		for (ListIterator<Sprite> it = actors.listIterator(); it.hasNext();) {
			Sprite r = it.next();
			r.doLogic();
		}
	}

	static void addGameObject(GameObject go) {
		actorsToAdd.addElement(go);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_ESCAPE) {
			System.exit(0);
		}
		if (e.getKeyCode() == e.VK_RIGHT)
		{
			if(posXonMap < 5000 - MainClass.width) posXonMap += 10;
		}
		if (e.getKeyCode() == e.VK_LEFT)
		{
			if(posXonMap > 0) posXonMap -= 10;
		}
		if (e.getKeyCode() == e.VK_UP)
		{
			if(posYonMap > 0) posYonMap -= 10;
		}
		if (e.getKeyCode() == e.VK_DOWN)
		{
			if(posYonMap < 5000 - MainClass.height)posYonMap += 10;
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

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		ui.elementClicked(mouseX, mouseY);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();

	}
}
