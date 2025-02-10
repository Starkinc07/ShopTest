package Ecom.Shop;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v112.page.Page;

import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.*;

public class Base implements ITestListener {

	protected WebDriver driver;
	protected WebDriverWait wait;
	String url="https://selenium08.blogspot.com/2019/11/dropdown.html";//"https://easyupload.io/"; //"https://selenium08.blogspot.com/2020/01/click-and-hold.html";//"https://demowebshop.tricentis.com/";
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	screenShotUtility sc;
	
	@BeforeClass
	public void onStart() {
		WebDriverManager.edgedriver().setup();	
		driver = new EdgeDriver();
		sc = new screenShotUtility();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Initialize WebDriverWait to wait for elements
		//wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Report/MyReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report"); // Title of the report
		htmlReporter.config().setReportName("Demo Shop Test Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Test User");
		
		
	}




	// Get the WebDriver instance
	//	public WebDriver getDriver() {
	//		return driver;
	//	}


	// Capture screenshot if test fails
	
	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) throws IOException {
		test = extent.createTest(result.getName());
		if (ITestResult.FAILURE == result.getStatus()) {
			
			//	captureScreenshot(testName);  // Capture screenshot only if the test fails

			test.fail("Test failed, screenshot captured");
			test.addScreenCaptureFromPath(sc.captureScreenshot(driver,result));

		}  else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, "TEST CASE PASSED: " + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP, "TEST CASE SKIPPED: " + result.getName());
			test.log(Status.FAIL, "TEST CASE SKIPPED: " + result.getThrowable());
		}
	}


	
	@AfterClass
	public void tearDown() {
		System.out.println("enter tear down ");
		extent.flush();
		driver.quit();
	}
}