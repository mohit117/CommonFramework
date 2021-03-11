package com.amazon.qa.base;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.amazon.qa.utilities.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static TopMenu topMenuObj; // encapsulating top navigation to base class as all the page HASA top menu
	public static Footer footerObj;

	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentLogger;

	//will execute before every test class only once for all test cases in it
	@BeforeTest
	public void beforeTestMethod()
	{

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Amazon Automation Report");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.DARK);


		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Mohit");
		extent.setSystemInfo("Enviornment", "PROD");

	}


	//will execute before every test method present in class everytime
	@BeforeMethod
	@Parameters(value={"browserName"})
	public void beforeMethodtMethod(String browserName, Method testMethod)
	{
		extentLogger = extent.createTest(testMethod.getName());
		
		setupDriver(browserName);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(Constants.url);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}


	//will execute after every test method @Test every time
	@AfterMethod
	public void afterMethodMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case : " + methodName + "  PASSED";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			extentLogger.log(Status.PASS, m);
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case : " + methodName + "  FAILED";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			extentLogger.log(Status.FAIL, m);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case : " + methodName + "  SKIPPED";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			extentLogger.log(Status.SKIP, m);
		}
		
		//driver.quit();
	}

	//will execute after every class only ONCE when all the tests present in the class are done

	@AfterTest
	public void afterTestMethod()
	{
		extent.flush();
	}


	public void setupDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		topMenuObj = new TopMenu(driver); // initializing TopMenu class
		footerObj = new Footer(driver);
	}
	
	public String getCurrentPageUrl()
	{
		return driver.getCurrentUrl();
	}

}
