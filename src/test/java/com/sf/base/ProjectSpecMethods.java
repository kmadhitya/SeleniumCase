package com.sf.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.sf.utilities.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecMethods {
	
	public ChromeDriver driver;
	public static JavascriptExecutor executor;
	public static WebDriverWait wait;
	public String excelFileName;
	public static Properties prop;
	@BeforeSuite
	public void setupDriver()
	{
		System.out.println("At Before Suite");
	}
	
	@DataProvider(name = "excelData")
	public Object[][] optyData() throws IOException
	{
		Object[][] data = ReadExcel.readExcelData(excelFileName);
		return data;
	}
	
	//@Parameters({"url","username","password"})  String url, String username, String pwd
	@BeforeMethod
	public void launchBrowserAndLoadURL() throws IOException
	{
		System.out.println("At Before Test");
		//System.setProperty("webdriver.chrome.drive", "./drivers/chromedriver");
		WebDriverManager.chromedriver().setup();
		
		File downloadFolder = new File("D:\\Workspace\\Selenium\\files\\");
		downloadFolder.mkdir();
		Map<String, Object> preferences = new HashMap<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.default_directory", "D:\\Workspace\\Selenium\\files\\");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		options.setExperimentalOption("prefs", preferences);
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		executor = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(new File("src/main/resources/config.properties"));
		prop.load(fis);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String pwd = prop.getProperty("password");
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
