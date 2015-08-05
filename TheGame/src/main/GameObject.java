package main;

import java.awt.image.BufferedImage;

public abstract class GameObject extends Sprite {

	protected int maxVelocity;
	protected boolean attackable;
	protected int maxHealth,currentHealth,attValue,defValue;
	
	public GameObject(BufferedImage[] i,double posX, double posY, long delay, int maxVelocity, boolean attackable, int attValue, int defValue, int maxHealth, int currentHealth) {
		super(i, posX, posY, delay);
		this.maxVelocity = maxVelocity;
		this.attackable = attackable;
		this.attValue=attValue;
		this.defValue=defValue;
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
	}
	
	abstract void destroy();
	
}
