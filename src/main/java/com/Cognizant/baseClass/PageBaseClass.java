
/*********************************CREATING BASE CLASS FOR THE BASIC FUNCTIONS REQUIRED TO RUN THE TESTS*************************************/

package com.Cognizant.baseClass;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import com.Cognizant.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class PageBaseClass {

	public WebDriver driver;
	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	// METHOD FOR INVOKING THE BROWSER
	public void invokeBrowser(String browserName) {
		// ACCESSING THE DATAS STORED IN THE CONFIG.PROPERTIES FILE
		try {
			prop = new Properties();

			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\propFile\\config.properties");

			prop.load(file);
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (prop.getProperty(browserName).equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+ "\\src\\test\\resources\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();

			logger.log(Status.PASS, "Chrome Browser is sucessfully Exceuted");
		} 
		else if (prop.getProperty(browserName).equalsIgnoreCase("microsoftedge")) 
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\drivers\\msedgedriver.exe");

			driver = new EdgeDriver();

			logger.log(Status.PASS, "Edge Browser is sucessfully Exceuted");
		} 
		else if (prop.getProperty(browserName).equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+ "\\src\\test\\resources\\drivers\\geckodriver.exe");

			driver = new FirefoxDriver();

			logger.log(Status.PASS, "Firefox Browser is sucessfully Exceuted");
		} 
		else {

			System.out.println("Browser not found");

			logger.log(Status.FAIL, "Wrong Browser");
		}


		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

	}

	// METHOD FOR OPENING APPLICATION
	public LandingPage openApplication(String websiteURLKey)
	{
		driver.get(prop.getProperty(websiteURLKey));

		return PageFactory.initElements(driver, LandingPage.class);
	}

	// METHOD FOR QUITTING BROWSER
	public void quitBrowser() {

		driver.quit();

	}

}
