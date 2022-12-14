package com.sf.hybridbase;

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
import com.sf.hybridactions.BrowserActions;
import com.sf.hybridactions.ElementActions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends Reporter implements BrowserActions, ElementActions {
	
	public static ChromeDriver driver;
	public static JavascriptExecutor executor;
	public static WebDriverWait wait;
	public static ChromeOptions options;
	
	private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> webDriverWait = new ThreadLocal<WebDriverWait>();
	
	public void setDriver()
	{
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		remoteWebDriver.set(new ChromeDriver(options));
	}
	
	public RemoteWebDriver getDriver()
	{
		return remoteWebDriver.get();
	}
	
	public void setWait()
	{
		webDriverWait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
	}
	
	public WebDriverWait getWait()
	{
		return webDriverWait.get();
	}
	
	public void openURLInChromeBrowser(String url)
	{
		WebDriverManager.chromedriver().setup();
		setDriver();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		executor = (JavascriptExecutor)getDriver();
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		try
		{
			getDriver().navigate().to(url);
			getDriver().manage().window().maximize();
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
			    return getDriver().findElement(By.id(value));
			case "xpath":
				return getDriver().findElement(By.xpath(value));
	
		}
		return null;
	}
	
	public void closeTheBrowser()
	{
		try
		{
			getDriver().close();
			reportStep("Browser is closed ", "INFO");
		}
		catch(Exception e)
		{
			reportStep("Browser is not closed ", "FAIL");
		}
		
	}
	
	public void quitTheBrowser()
	{
		try
		{
			getDriver().quit();
			reportStep("Browser is quit ", "INFO");
		}
		catch(Exception e)
		{
			reportStep("Browser is not quit", "FAIL");
		}
		
	}
	
	public void switchToTheIFrameUsingID(int value)
	{
		try
		{
			getDriver().switchTo().frame(value);
			reportStep("Switched to Frame using: "+value, "PASS");
		}
		catch(Exception e)
		{
			reportStep("Failed switching to Frame using: "+value, "FAIL");
		}		
	}
	
	public void switchToTheIFrameUsingName(String name)
	{
		try
		{
			getDriver().switchTo().frame(name);
			reportStep("Switched to Frame using: "+name, "PASS");
		}
		catch(Exception e)
		{
			reportStep("Failed switching to Frame using: "+name, "FAIL");
		}	
	}
	
	public void switchToTheIFrameUsingWebElement(WebElement ele)
	{
		try
		{
			getDriver().switchTo().frame(ele);
			reportStep("Switched to Frame using: "+ele, "PASS");
		}
		catch(Exception e)
		{
			reportStep("Failed switching to Frame using: "+ele, "FAIL");
		}	
	}
	
	public void switchBackFromFrame()
	{
		try
		{
			getDriver().switchTo().defaultContent();
			reportStep("Switched back from frame ", "PASS");
		}
		catch(Exception e)
		{
			reportStep("Failed switching back from Frame ", "FAIL");
		}	
		
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
			getDriver().executeScript("arguments[0].value='"+ text +"';", ele);
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
			getDriver().executeScript("arguments[0].click();", ele);
			reportStep(ele+" is clicked ", "PASS");
		}
		catch(Exception e)
		{
			reportStep(ele+" is not clicked ", "FAIL");
		}
	}
	
	public String getTitleOfThePage()
	{
		return getDriver().getTitle();
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
		//wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		setWait();
		String loc = locator.toLowerCase();
		switch (loc)
		{
		    case "id":
		    	getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			case "xpath":
				getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		}
	}
	
	public void explicitWaitForFrame(WebElement ele)
	{
		//wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		setWait();
		getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}

	@Override
	public long takeSnap() {
		long number = ( long ) Math.floor(Math.random() * 900000000L) + 10000000L;
		File src = getDriver().getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(folder+"/"+number+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return number;
	}

}
