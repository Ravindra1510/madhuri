package generics;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class ScreenShot {
	public static WebDriver driver;
	public static void takeScreenShot(){
		try{
			driver=new ChromeDriver();
			Date d = new Date();
			String now=d.toString().replace(':','_');
			TakesScreenshot js=(TakesScreenshot)driver;
			File src=js.getScreenshotAs(OutputType.FILE);
			 File DestFile=new File("./SnapShot/"+now+"screenship.png");
			 FileUtils.copyFile(src, DestFile);
			
		}catch(Exception e){
			Reporter.log("taking screenshot failed");
			
		}
		
		
	}

}
