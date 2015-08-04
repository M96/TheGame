package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class BiLoader {

	BiLoader()
	{
		
	}
	
	BufferedImage[] loadPics(String path, int pics)
	{
		BufferedImage[] temp = new BufferedImage[pics];
		BufferedImage source = null;
		
		URL pic_url = getClass().getClassLoader().getResource(path);
		
		try {
			source = ImageIO.read(pic_url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < pics; i++)
		{
			temp[i] = source.getSubimage(i*source.getWidth()/pics, 0, source.getWidth(), source.getHeight());
		}
		
		return temp;
	}
}
