package main;

import java.awt.image.BufferedImage;

public abstract class MilitaryForce extends GameObject implements Military {

	private int maxHealth,currentHealth,attValue,defValue;
	
	public MilitaryForce(BufferedImage[] i, int posX, int posY, int attValue, int defValue, int maxHealth, int currentHealth) {
		super(i, posX, posY, defValue, maxHealth, true, attValue, defValue, maxHealth, currentHealth);
		
		this.attValue = attValue;
		this.defValue = defValue;
	}
	
	abstract void attack(Building victimMilitaryBuilding);
	abstract void attack(MilitaryForce victimMilitaryForce);
	abstract void underAttack(GameObject attacker);
	abstract void walk(int velocity, int direction);
	

}
