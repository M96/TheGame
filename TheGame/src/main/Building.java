package main;

import java.awt.image.BufferedImage;

abstract public class Building extends GameObject {

	private boolean manned;

	private boolean destroyed;
	
	private int constructionTime;
	
	public Building(BufferedImage[] i,double posX, double posY, long delay, boolean attackable) {
		super(i,posX,posY, delay, 0,attackable);
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
