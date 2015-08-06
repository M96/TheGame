package main;

import java.awt.image.BufferedImage;

public abstract class GameObject extends Sprite {

	protected int maxVelocity;
	protected boolean attackable;
	private int maxHealth,currentHealth,attValue,defValue;
	
	public GameObject(BufferedImage[] i,double posX, double posY, long delay, int maxVelocity, boolean attackable, int attValue, int defValue, int maxHealth, int currentHealth) {
		super(i, posX, posY, delay);
		this.maxVelocity = maxVelocity;
		this.attackable = attackable;
		this.attValue=attValue;
		this.defValue=defValue;
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
	}
	
	protected int getAttValue() {
		return attValue;
	}

	protected int getDefValue() {
		return defValue;
	}
	
	protected int getCurrentHealth() {
		return currentHealth;
	}
	
	protected boolean isAttackable() {
		return attackable;
	}
	
	protected void setCurrentHealth(int value) {
		currentHealth=value;
	}
	
	
	protected void underAttack(int remainingAtt) {
		if (isAttackable()) {
			int health = getCurrentHealth() - remainingAtt;
			if(health<=0) {
				setCurrentHealth(0);
			} else {
				setCurrentHealth(health);
			}
		}
	}
	
	abstract void destroy();
	
}
