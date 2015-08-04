package main;

import java.awt.image.BufferedImage;

public class GameObject extends Sprite {

	protected int maxVelocity;
	protected boolean attackable;
	
	public GameObject(BufferedImage[] i,double posX, double posY, long delay, int maxVelocity, boolean attackable) {
		super(i, posX, posY, delay);
		this.maxVelocity = maxVelocity;
		this.attackable = attackable;
	}
	
	
	
}
