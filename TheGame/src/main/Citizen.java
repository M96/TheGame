package main;

import java.awt.image.BufferedImage;

public class Citizen extends GameObject {

	public Citizen(BufferedImage[] i,double posX, double posY, long delay, int maxVelocity) {
		super(i,posX,posY,delay,0,false,0,0,0,0);
	}
	
	protected void walk(int velocity, int direction) {
		//...
	}

	@Override
	void destroy() {
		
	}

}
