package main;

import java.awt.image.BufferedImage;

public class Ui {

	BufferedImage image;
	Game theGame;

	private boolean buildingSelected;
	private int selectedBuildingID;

	Ui(Game parent) {
		image = BiLoader.loadPics("src\\pics\\test.png", 1)[0];
		theGame = parent;
		buildingSelected = false;
	}

	void elementClicked(int x, int y) {
		
		if (buildingSelected) {
			switch (selectedBuildingID) {
			case (Building.MANSION): {
				new Mansion(x+theGame.posXonMap, y+theGame.posYonMap);
				break;
			}
			}
			buildingSelected = false;
		} else {
			if (x < 100f && y < 100f) {
				selectedBuildingID = Building.MANSION;
				buildingSelected = true;
			}
		}
	}
}
