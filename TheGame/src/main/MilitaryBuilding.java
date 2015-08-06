package main;

import java.awt.image.BufferedImage;

public class MilitaryBuilding extends Building implements Military {

	public MilitaryBuilding(BufferedImage[] i,double posX, double posY, long delay, int attValue, int defValue, int maxHealth, int currentHealth, int buildingID) {
		super(i,posX,posY,delay,true,attValue,defValue,maxHealth,currentHealth,buildingID); 
	}

	@Override
	void destroy() {
		
	}
	
	void attack(GameObject victim) {
		
	}
	
	void underAttack(GameObject attacker) {
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

}
