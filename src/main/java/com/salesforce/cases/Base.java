package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static ChromeDriver driver;
	@BeforeSuite
	public void setupDriver()
	{
		System.out.println("At Before Suite");
	}
	
	@BeforeMethod
	public void launchBrowserAndLoadURL()
	{
		System.out.println("At Before Test");
		String url = "https://login.salesforce.com/";
		String username = "hari.radhakrishnan@qeagle.com";
		String pwd = "India$321";
		//System.setProperty("webdriver.chrome.drive", "./drivers/chromedriver");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
		
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		if (driver.getTitle().contains("Salesforce - Developer Edition"))
		{
			driver.findElement(By.xpath("(//a[text()='Switch to Lightning Experience'])[1]")).click();
		}
	}
	/*@AfterMethod
	public void closeBrowser()
	{
		System.out.println("At After Test");
		driver.close();
	}
	@AfterSuite
	public void quitBrowser()
	{
		System.out.println("At After Suite");
		driver.close();
	}*/
	

}
