package Constant;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import generics.BrowserUtils;

public class TestLevel {
	@BeforeTest
	public void OpenApplication() throws IOException{
		BrowserUtils.OpenApplication();
	}
	@AfterTest
	public void CloseApplication(){
		BrowserUtils.closeApplication();
		
		
		
	}
}
