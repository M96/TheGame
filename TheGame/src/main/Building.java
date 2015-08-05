package main;

import java.awt.image.BufferedImage;

abstract public class Building extends GameObject {

	private boolean manned;

	private boolean destroyed;
	
	private int constructionTime;
	
	public Building(BufferedImage[] i,double posX, double posY, long delay, boolean attackable, int attValue, int defValue, int maxHealth, int currentHealth) {
		super(i,posX,posY, delay, 0,attackable,attValue,defValue,maxHealth,currentHealth);
		this.manned=false;
	}

	void man() {
		manned=true;
	};
	
	boolean isManned() {
		return manned;
	}
	
	boolean isAttackable() {
		return attackable;
	}
	
	boolean isDestroyed() {
		return destroyed;
	}
	
	abstract void destroy();
	
}
