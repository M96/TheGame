package main;

public  abstract class MilitaryForce {

	private int maxHealth,currentHealth,attValue,defValue;
	
	public MilitaryForce(int maxHealth, int attValue, int defValue) {
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
		this.attValue = attValue;
		this.defValue = defValue;
	}
	
	abstract void attack(Building victimMilitaryBuilding);
	abstract void attack(MilitaryForce victimMilitaryForce);
	abstract void underAttack(Object attacker);
	abstract void walk(int velocity, int direction);
	

}
