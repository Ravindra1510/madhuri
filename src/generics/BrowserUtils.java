package generics;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ReporterConfig.Property;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Constant.BrowsetDetailsConstants;

public class BrowserUtils{
	
	public static WebDriver driver;
	@BeforeMethod
	public static void OpenApplication() throws IOException{
		Properties p=PropertyUtil.Property(BrowsetDetailsConstants.BrowserPathFileName);
		String Chrome_Key=p.getProperty(BrowsetDetailsConstants.ChromeDriverKey);
		String Chrome_Value=p.getProperty(BrowsetDetailsConstants.ChromeValue);
		System.setProperty(Chrome_Key, Chrome_Value);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	@AfterMethod
	public static void closeApplication(){
		driver.quit();
	}

}  