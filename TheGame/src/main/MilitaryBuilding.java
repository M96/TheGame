package main;

import java.awt.image.BufferedImage;

public abstract class MilitaryBuilding extends Building implements Military {

	public MilitaryBuilding(BufferedImage[] i,double posX, double posY, long delay, int attValue, int defValue, int maxHealth, int currentHealth, int buildingID) {
		super(i,posX,posY,delay,true,attValue,defValue,maxHealth,currentHealth,buildingID); 
	}

	@Override
	public void attack(GameObject victim) {
		if (victim.isAttackable()) {
			int att = getAttValue();
			int def = victim.getDefValue();
		
			int remainingAtt = def-att;
		
			victim.underAttack(remainingAtt);
		} else {
			System.out.println("Victim is not attackable!");
		}
	}

}
