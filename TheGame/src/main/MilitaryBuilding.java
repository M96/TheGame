package main;

import java.awt.image.BufferedImage;

public class MilitaryBuilding extends Building{

	public MilitaryBuilding(BufferedImage[] i,double posX, double posY, long delay) {
		super(i,posX,posY,delay,true); 
	}

	@Override
	void destroy() {
		
	}
	
	void attack(Object victim) {
		
	}
	
	void underAttack(Object attacker) {
		
	}

}
