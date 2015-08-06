package main;

import java.awt.image.BufferedImage;

public abstract class MilitaryForce extends GameObject implements Military {
	
	public MilitaryForce(BufferedImage[] i, int posX, int posY, int attValue, int defValue, int maxHealth, int currentHealth) {
		super(i, posX, posY, defValue, maxHealth, true, attValue, defValue, maxHealth, currentHealth);
	}
	
	abstract void walk(int velocity, int direction);
	
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
