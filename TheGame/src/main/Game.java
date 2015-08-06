package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ListIterator;
import java.util.Vector;

public class Game implements Runnable,KeyListener,MouseListener,MouseMotionListener {

	private MainClass graphic;
	Ui ui;
	
	int mouseX, mouseY;
	
	Vector<Sprite> actors;

	Game(MainClass parent) {
		graphic = parent;
		graphic.canvas.addKeyListener(this);
		graphic.canvas.addMouseListener(this);
		graphic.canvas.addMouseMotionListener(this);
		graphic.canvas.requestFocus();
		
		ui = new Ui(this);
		
		actors = new Vector<Sprite>();

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
	
	void addGameObject(GameObject go)
	{
		actors.addElement(go);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		ui.elementClicked(mouseX,mouseY);
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
