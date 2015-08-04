package main;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Sprite extends Rectangle2D.Double{

	long delay, animation;
	BufferedImage[] pics;
	int currentpic;
	
	double dx, dy;
	
	Sprite(BufferedImage[] i, double x, double y, long delay)
	{
		pics = i;
		this.x = x;
		this.y = y;
		this.delay = delay;
		this.width = pics[0].getWidth();
		this.height = pics[0].getHeight();
	}
	
	void drawObjects(Graphics g)
	{
		g.drawImage(pics[currentpic],(int) x, (int) y, null);
	}
	
	void move(long delta)
	{
		if(dx!=0)
		{
			x += dx *(delta/1e9);
		}
		
		if(dx!=0)
		{
			y += dy *(delta/1e9);
		}
	}
	
	void animate(long delta)
	{
		animation += (delta/1000000);
		if(animation > delay)
		{
			animation = 0;
			computeAnimation();
		}
	}

	private void computeAnimation() {
		currentpic++;
		
		if(currentpic >= pics.length)
		{
			currentpic = 0;
		}
	}
}
