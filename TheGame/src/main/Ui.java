package main;

import java.awt.image.BufferedImage;

public class Ui {

	BufferedImage image;
	Game theGame;

	private boolean buildingSelected;
	private int selectedBuildingID;

	Ui(Game parent) {
		image = BiLoader.loadPics("test.png", 1)[0];
		theGame = parent;
		buildingSelected = false;
	}

	void elementClicked(int tempx, int tempy) {
		int x = (int) (tempx * MainClass.scaleFactor);
		int y = (int) (tempy * MainClass.scaleFactor);
		
		if (buildingSelected) {
			switch (selectedBuildingID) {
			case (Building.MANSION): {
				new Mansion(x, y);
				break;
			}
			}
			buildingSelected = false;
		} else {
			if (x < 100 && y < 100) {
				selectedBuildingID = Building.MANSION;
				buildingSelected = true;
			}
		}
	}
}
