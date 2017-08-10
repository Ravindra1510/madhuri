package Constant;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import generics.BrowserUtils;

public class ClassLevel {
	@BeforeClass
	public void OpenApplication() throws IOException{
		BrowserUtils.OpenApplication();
	}
	@AfterClass
	public void CloseApplication(){
		BrowserUtils.closeApplication();
		
	}
}
