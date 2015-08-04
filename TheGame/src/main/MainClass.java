package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JPanel implements Runnable{

	JFrame frame;
	
	public MainClass() {
		this.setPreferredSize(new Dimension(800,600));
		
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		
		Thread thread = new Thread(this);
		thread.start();
	}

	public static void main(String[] args) {
		new MainClass();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
