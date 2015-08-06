package main;

import java.awt.image.BufferedImage;

public class Ui{
	
	BufferedImage image;
	Game theGame;
	
	Ui(Game parent)
	{
		image = BiLoader.loadPics("test.png", 1)[0];
		theGame = parent;
	}
	
	void elementClicked(int x, int y)
	{
		if(x < 100f * MainClass.scaleFactor && y < 100f * MainClass.scaleFactor)
		{
			System.out.println("Yay");
		}
	}
}
