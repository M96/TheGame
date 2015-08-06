package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass implements Runnable {

	static int width, height;
	static double scaleFactor;
	
	private Game game;
	
	JFrame frame;
	Canvas canvas;

	private BufferStrategy buffer;
	private Graphics graphics;
	private Graphics2D g2d;
	private BufferedImage bi;

	Vector<Sprite> painter;

	private int fps, frames;

	private long totalTime, curTime, lastTime;

	public MainClass() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		width = (int) dim.getWidth();
		height = (int) dim.getHeight();
		
		scaleFactor = (float)width/1920f;
		
		// Canvas initialisieren
		canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setSize(width, height);

		// Jframe initialisieren
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIgnoreRepaint(true);
		frame.setUndecorated(true);

		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

		// Backbuffer erstellen
		canvas.createBufferStrategy(2);
		buffer = canvas.getBufferStrategy();

		// Graphicsachen kriegen
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();

		//Fullscreen
		gd.setFullScreenWindow(frame);
		
		if (gd.isDisplayChangeSupported()) {
			gd.setDisplayMode(new DisplayMode(width, height, 32, DisplayMode.REFRESH_RATE_UNKNOWN));
		}

		//Mehr Graphicsachen
		bi = gc.createCompatibleImage(width, height);
		graphics = null;
		g2d = null;

		//Spiel initialisieren
		game = new Game(this);

		painter = new Vector<Sprite>();

		//Für den Timer
		curTime = System.currentTimeMillis();
		lastTime = curTime;

		//Grahic und GameThread starten
		Thread tgraphic = new Thread(this);
		tgraphic.start();

		Thread tgame = new Thread(game);
		tgame.start();
	}

	public static void main(String[] args) {
		new MainClass();
	}

	@Override
	public void run() {
		while (frame.isVisible()) {
			try {
				computeDelta();

				g2d = bi.createGraphics();

				g2d.drawRect(0, 0, width, height);
				
				//Skalierung auf Bildschirmgröße
				//g2d.scale(scaleFactor, scaleFactor);
				
				//Alle Sprites malen
				if (painter != null) {
					for (ListIterator<Sprite> it = painter.listIterator(); it.hasNext();) {
						Sprite r = it.next();
						r.drawObjects(g2d);
					}
				}

				g2d.setFont(new Font("Courier New", Font.PLAIN, 12));

				g2d.drawImage(game.ui.image, 0,0,null);
				
				g2d.setColor(Color.GREEN);

				g2d.drawString(String.format("FPS: %s", fps), 20, 20);
				
				// Mehr graphic zeugs
				graphics = buffer.getDrawGraphics();
				graphics.drawImage(bi, 0, 0, null);
				if (!buffer.contentsLost())
					buffer.show();

				Thread.yield();

			} finally {
				// release resources

				if (graphics != null)
					graphics.dispose();

				if (g2d != null)
					g2d.dispose();

			}
		}

	}

	private void computeDelta() {
		// FPS berechnen
		lastTime = curTime;

		curTime = System.currentTimeMillis();

		totalTime += curTime - lastTime;

		if (totalTime > 1000) {

			totalTime -= 1000;

			fps = frames;

			frames = 0;

		}

		++frames;
	}
}
