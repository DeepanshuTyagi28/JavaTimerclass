package Sceenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class Ashottry_Fullpage {
	
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Deepanshu Tyagi\\\\Desktop\\\\JAVA\\\\chromedriver_win32 (2)\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com");
		driver.manage().window().maximize();

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG",new File(System.getProperty("user.dir") + "\\Screenshot\\fullpagescreenshot.png"));

		
        WebElement logo = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));        
        File f = logo.getScreenshotAs(OutputType.FILE);        
        FileUtils.copyFile(f, new File(System.getProperty("user.dir") + "\\Screenshot\\LogoSS.png"));
        
             
		
	}

	
}