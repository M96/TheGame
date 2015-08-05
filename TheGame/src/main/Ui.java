package main;

import java.awt.image.BufferedImage;

public class Ui {
	
	BufferedImage image;
	
	Ui()
	{
		image = BiLoader.loadPics("test.png", 1)[0];
	}
	
}
