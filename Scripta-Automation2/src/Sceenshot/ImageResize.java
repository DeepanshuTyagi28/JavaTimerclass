package Sceenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageResize {
	
	public static void Crop(String FileCROP) throws IOException {
			
		try {
		    BufferedImage originalImg = ImageIO.read(new File("C:\\Users\\Deepanshu Tyagi\\git\\TableauCapturingScreenshot\\ScriptaSelenium-master\\Screenshot\\" +FileCROP));
		    BufferedImage SubImg = originalImg.getSubimage(300, 80, 1320, 800);
		    File outputFile = new File("C:\\Users\\Deepanshu Tyagi\\git\\TableauCapturingScreenshot\\ScriptaSelenium-master\\Screenshot\\" + FileCROP);
		    ImageIO.write(SubImg, "png", outputFile);
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
	}
		
		
	}
