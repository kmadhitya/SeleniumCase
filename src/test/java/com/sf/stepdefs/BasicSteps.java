package com.sf.stepdefs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicSteps extends AbstractTestNGCucumberTests{
	
	public static ChromeDriver driver;
	public static JavascriptExecutor executor;
	public static WebDriverWait wait;
	public String excelFileName;
	public static Properties prop;
	
	@BeforeMethod
	public void preCondition() throws IOException
	{
		System.out.println("At Before Method");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
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
	public void postCondition()
	{
		System.out.println("At After Method");
		driver.close();
		driver.quit();
	}

}
