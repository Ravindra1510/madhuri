package Constant;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentTest;

import generics.BrowserUtils;

public class SuiteLevel {
@BeforeSuite
public void OpenApplication() throws IOException{
	BrowserUtils.OpenApplication();
}
@AfterSuite
public void CloseApplication(){
	BrowserUtils.closeApplication();
	
}
}
