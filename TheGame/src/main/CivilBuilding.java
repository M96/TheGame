package main;

import java.awt.image.BufferedImage;

public class CivilBuilding extends Building {


	public CivilBuilding(BufferedImage[] i,double posX, double posY, long delay) {
		super(i,posX,posY,delay,false,0,0,0,0); 
	}

	@Override
	void destroy() {
		
	}

}
