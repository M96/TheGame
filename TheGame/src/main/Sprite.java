package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	void drawObjects(Graphics2D g2d)
	{
		g2d.drawImage(pics[currentpic],(int) x, (int) y, null);
	}
	
	void move()
	{
		if(dx!=0)
		{
			x += dx;
		}
		
		if(dx!=0)
		{
			y += dy;
		}
	}
	
	void doLogic()
	{
		
	}
}
