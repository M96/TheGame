package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JPanel{

	JFrame frame;
	
	public MainClass() {
		this.setPreferredSize(new Dimension(800,600));
		
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new MainClass();
	}

}
