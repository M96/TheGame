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
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass implements Runnable {

	Game game;

	JFrame frame;
	Canvas canvas;

	BufferStrategy buffer;
	Graphics graphics;
	Graphics2D g2d;
	BufferedImage bi;

	Vector<Sprite> painter;

	int fps, frames;

	long totalTime, curTime, lastTime;

	public MainClass() {

		// Canvas initialisieren
		canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setSize(1280, 720);

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

		gd.setFullScreenWindow(frame);

		if (gd.isDisplayChangeSupported()) {
			gd.setDisplayMode(new DisplayMode(1280, 720, 32, DisplayMode.REFRESH_RATE_UNKNOWN));
		}

		bi = gc.createCompatibleImage(1280, 720);
		graphics = null;
		g2d = null;

		game = new Game(this);

		painter = new Vector<Sprite>();

		curTime = System.currentTimeMillis();
		lastTime = curTime;

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

				if (painter != null) {
					for (ListIterator<Sprite> it = painter.listIterator(); it.hasNext();) {
						Sprite r = it.next();
						r.drawObjects(g2d);
					}
				}

				g2d.setFont(new Font("Courier New", Font.PLAIN, 12));

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
