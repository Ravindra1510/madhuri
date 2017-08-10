package generics;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Constant.BrowsetDetailsConstants;

public class BasePageUtils {
	public WebDriver driver;
	public Actions actions=new Actions(driver);
	public BasePageUtils(WebDriver driver){
		this.driver=driver;
		}
	public void VerifyTitle(String eTitle){
		WebDriverWait wait=new WebDriverWait(driver,5);
		try{
			wait.until(ExpectedConditions.titleContains(eTitle));
			Reporter.log("Title is Matching",true);
		}catch(Exception e){
			Reporter.log("Title not matching:FAIL",true);
			Assert.fail();
		}
	}
	public void VerifyURL(String eURL){
		WebDriverWait wait=new WebDriverWait(driver,10);
			try{
				wait.until(ExpectedConditions.urlContains(eURL));
				Reporter.log("URL is Matching",true);
			}catch(Exception e){
				Reporter.log("URL not matching:Fail ",true);
				Assert.fail();
			}
		}

	public void Click(WebElement element){
		WebDriverWait wait=new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Reporter.log("Element clickable ",true);
			element.click();
			
		}catch(Exception e){
			Reporter.log("Element notpresent to click",true);
			Assert.fail();
		}
	}
	public void dynamicList(String xp,String eElement){
		WebDriverWait wait=new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp)));
			WebElement lstBox = driver.findElement(By.xpath(xp));
			Reporter.log("Element present and clickable",true);
			lstBox.sendKeys(eElement+Keys.ENTER);
		}catch(Exception e){
			Reporter.log("Element not present in the suggested list",true);
			Assert.fail();
		}
	}
		
		@BeforeMethod
		public void OpenApplication() throws IOException{
			Properties p=PropertyUtil.Property(BrowsetDetailsConstants.BrowserPathFileName);
			String Chrome_Key=p.getProperty(BrowsetDetailsConstants.ChromeDriverKey);
			String Chrome_Value=p.getProperty(BrowsetDetailsConstants.ChromeValue);
			System.setProperty(Chrome_Key, Chrome_Value);
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		}
		@AfterMethod
		public void closeApplication(){
			driver.quit();
	}
	public void mouseHover(String xp){
		WebDriverWait wait=new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp)));
			WebElement menu=driver.findElement(By.xpath(xp));
			Reporter.log("mouse hovered",true);
			actions.moveToElement(menu).build().perform();
				
		}catch(Exception e){
			Reporter.log("Mouse hovering not possible",true);
			Assert.fail();
		}
	}
	public void contextClick(String xp){
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp)));
			WebElement click=driver.findElement(By.xpath(xp));
			Reporter.log("Composit action Performed",true);
			actions.contextClick(click).perform();
		}catch(Exception e){
			Reporter.log("Unable to perform Context Click",true);
		}
	}
	public void MouseHover(String xpath){
		WebDriverWait wait=new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement toElement=driver.findElement(By.xpath(xpath));
			actions.moveToElement(toElement).build().perform();
			Reporter.log(",ouse hover performed",true);
			
		}catch(Exception e){
			Reporter.log("Element not present",true);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

