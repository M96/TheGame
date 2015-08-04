package main;

public class Game implements Runnable {

	MainClass graphic;
	
	Game(MainClass parent) {
		graphic = parent;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
