package main;

public class Mansion extends CivilBuilding {
	
	private static final String texturePath = "C:\\Users\\Attila\\Pictures\\mansion.png";

	public Mansion(int posX, int posY) {
		super(BiLoader.loadPics(texturePath, 1), posX, posY, 0, Building.MANSION);
		Game.addGameObject(this);
	}

}
