package main;

import java.awt.image.BufferedImage;

abstract public class Building extends GameObject {

	private boolean manned;

	private boolean destroyed;
	
	private int constructionTime;
	protected int buildingID;
	
	//buildingIDs 
	static final int MANSION = 9000;
	static final int FARM = 9001;
	static final int TOWER = 9002;
	
	
	public Building(BufferedImage[] i,double posX, double posY, long delay, boolean attackable, int attValue, int defValue, int maxHealth, int currentHealth, int buildingID) {
		super(i,posX,posY, delay, 0,attackable,attValue,defValue,maxHealth,currentHealth);
		this.manned=false;
		this.buildingID = buildingID;
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
