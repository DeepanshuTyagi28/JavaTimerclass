package Sceenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class GraphScreenshot
{
	
	
	public static void Captured(WebDriver driver, String name) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //   FileUtils.copyFile(src, new File("D:\\Screenshots\\" + name +".png"));
		
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")  + "\\Screenshot\\Executive Summarys.png"));
		
		
		
	}
	
}