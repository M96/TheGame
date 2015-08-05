package main;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Ui{
	
	BufferedImage image;
	
	private Button theButton;
	
	
	Ui(JFrame frame)
	{
		//image = BiLoader.loadPics("Lighthouse.jpg", 1)[0];
		
		theButton = new Button("The Button");
		theButton.setBounds(50, 50, 60, 20);
		theButton.setVisible(true);
		theButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		});
		frame.add(theButton);
	}
	
}
