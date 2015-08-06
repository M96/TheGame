package main;

import java.awt.image.BufferedImage;

public abstract class CivilBuilding extends Building {
	
	public CivilBuilding(BufferedImage[] i,double posX, double posY, long delay, int buildingID) {
		super(i,posX,posY,delay,false,0,0,0,0,buildingID);
	}

	@Override
	void destroy() {
		
	}



}
