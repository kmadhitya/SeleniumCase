package com.sf.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static ChromeDriver driver;
	public static JavascriptExecutor executor;
	public static WebDriverWait wait;
	public static ChromeOptions options;
	
	public void openURLInChromeBrowser(String url)
	{
		//System.setProperty("webdriver.chrome.drive", "./drivers/chromedriver");
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		executor = (JavascriptExecutor)driver;
		//wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	public WebElement locateElement(String locator, String value)
	{
		String loc = locator.toLowerCase();
		switch (loc)
		{
		    case "id":
			    return driver.findElement(By.id(value));
			case "xpath":
				return driver.findElement(By.xpath(value));
	
		}
		return null;
	}
	
	public void closeTheBrowser()
	{
		driver.close();
	}
	
	public void quitTheBrowser()
	{
		driver.quit();
	}
	
	public void typeText(WebElement ele, String text)
	{
		ele.sendKeys(text);
	}
	
	public void typeTextUsingJavaScript(WebElement ele, String text)
	{
		ele.sendKeys(text);
	}
	
	public void clickElement(WebElement ele)
	{
		ele.click();
	}
	
	public void clickElementUsingJavaScript(WebElement ele)
	{
		executor.executeScript("arguments[0].click();", ele);
	}
	
	public String getTitleOfThePage()
	{
		return driver.getTitle();
	}
	
	public void explicitWaitStatement(String locator, String locatorValue)
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		String loc = locator.toLowerCase();
		switch (loc)
		{
		    case "id":
		    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		}
	}

}