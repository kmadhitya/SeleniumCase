package com.salesforce.base;

import java.io.IOException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.salesforce.utils.ExcelUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpecificMethods {
	public static ChromeDriver driver;
	public String excelFileName;
	@BeforeSuite
	public void setupDriver()
	{
		System.out.println("At Before Suite");
	}
	
	@DataProvider(name = "excelData")
	public Object[][] optyData() throws IOException
	{
		Object[][] data = ExcelUtil.readExcelData(excelFileName);
		return data;
	}
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void launchBrowserAndLoadURL(String url, String username, String pwd)
	{
		System.out.println("At Before Test");
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
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("At After Test");
		driver.close();
	}
	@AfterSuite
	public void quitBrowser()
	{
		System.out.println("At After Suite");
		driver.quit();
	}
	

}
