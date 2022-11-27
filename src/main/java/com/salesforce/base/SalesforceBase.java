package com.salesforce.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.utils.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceBase extends Reporter{
	
	public static ChromeDriver driver;
	public static JavascriptExecutor executor;
	public static WebDriverWait wait;
	public static ChromeOptions options;
	
	private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver()
	{
		remoteWebDriver.set(new ChromeDriver());
	}
	
	public RemoteWebDriver getDriver()
	{
		return remoteWebDriver.get();
	}
	
	public void openURLInChromeBrowser(String url)
	{
		//System.setProperty("webdriver.chrome.drive", "./drivers/chromedriver");
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		executor = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try
		{
			driver.navigate().to(url);
			driver.manage().window().maximize();
			reportStep(url+" is launched ", "PASS");
		}
		catch(Exception e)
		{
			reportStep(url+" is not launched ", "FAIL");
		}
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
	
	public void switchToTheIFrameUsingID(int value)
	{
		driver.switchTo().frame(value);
	}
	
	public void switchToTheIFrameUsingName(String name)
	{
		driver.switchTo().frame(name);
	}
	
	public void switchToTheIFrameUsingWebElement(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	public void switchBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	public void typeText(WebElement ele, String text)
	{
		try 
		{
			ele.sendKeys(text);
			reportStep(text+" is typed on the "+ele, "PASS");
		}
		catch(Exception e)
		{
			reportStep(text+" is not typed on the "+ele, "FAIL");
		}
		
	}
	
	public void typeTextAndEnter(WebElement ele, String text)
	{
		try
		{
			ele.sendKeys(text, Keys.ENTER);
			reportStep(text+" is typed on the "+ele, "PASS");
		}
		catch(Exception e)
		{
			reportStep(text+" is not typed on the "+ele, "FAIL");
		}
	}
	
	public void clearAndTypeText(WebElement ele, String text)
	{
		try
		{
			ele.clear();
			ele.sendKeys(text);
			reportStep(text+" is typed on the "+ele, "PASS");
		}
		catch(Exception e)
		{
			reportStep(text+" is not typed on the "+ele, "FAIL");
		}
	}
	
	public void typeTextUsingJavaScript(WebElement ele, String text)
	{
		try
		{
			ele.sendKeys(text);
			driver.executeScript("arguments[0].value='"+ text +"';", ele);
			reportStep(text+" is typed on the "+ele, "PASS");
		}
		catch(Exception e)
		{
			reportStep(text+" is not typed on the "+ele, "FAIL");
		}
	}
	
	public void clickElement(WebElement ele)
	{
		try
		{
			ele.click();
			reportStep(ele+" is clicked ", "PASS");
		}
		catch(Exception e)
		{
			reportStep(ele+" is not clicked ", "FAIL");
		}
	}
	
	public void clickElementUsingJavaScript(WebElement ele)
	{
		try
		{
			driver.executeScript("arguments[0].click();", ele);
			reportStep(ele+" is clicked ", "PASS");
		}
		catch(Exception e)
		{
			reportStep(ele+" is not clicked ", "FAIL");
		}
	}
	
	public String getTitleOfThePage()
	{
		return driver.getTitle();
	}
	
	public String getTheActualText(WebElement ele)
	{
		return ele.getText();
	}
	
	public String getAttributeValue(WebElement ele, String attributeName)
	{
		return ele.getAttribute(attributeName);
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
	
	public void explicitWaitForFrame(WebElement ele)
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}

	@Override
	public long takeSnap() {
		long number = ( long ) Math.floor(Math.random() * 900000000L) + 10000000L;
		File src = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(folder+"/"+number+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return number;
	}
}
