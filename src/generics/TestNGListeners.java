package generics;

import java.io.File;

import org.testng.Assert;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestNGListeners implements ISuiteListener, ITestListener, IInvokedMethodListener {

	ExtentReports extent;
	ExtentTest logger;
	/*try{
		String paTh=generics.ScreenShot(res.getname));
		String path=generics.ScreenShot(res.getName());
		String input_path=logger.addScreenCapture(path);
		logger.log(LogStatus.FAIL, res.getname()+"getting failed",input_path);
	}catch(Exception e){
		e.getStackTrace();
	}*/
	
	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		extent.endTest(logger);
		extent.flush();
		extent.close();
		Reporter.log("About to finish execution of Suite" +arg0.getName(),true);
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
		 extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		Reporter.log("About to start executing the suite" +arg0.getName(),true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		logger = extent.startTest("failTest");
		if(arg0.getStatus()==2)
		{
			ScreenShot.takeScreenShot();
		}
		Assert.assertTrue(false);
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		
	}

	@Override
	public void onFinish(ISuite arg0) {
		extent.endTest(logger);
		extent.flush();
		extent.close();
		Reporter.log("About to finish execution of Suite" +arg0.getName(),true);
		
	}

	@Override
	public void onStart(ISuite arg0) {
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
		 extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		 logger=extent.startTest(arg0.getName());
		Reporter.log("About to start executing the suite" +arg0.getName(),true);
		
	}
	
}
