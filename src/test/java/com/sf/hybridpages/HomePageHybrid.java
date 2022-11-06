package com.sf.hybridpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class HomePageHybrid extends ProjectSpecMethods{
	
	/*public HomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public HomePageHybrid clickAppLauncher()
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("HomePage.AppLauncher.xpath"))));
		//WebElement appLauncher = driver.findElement(By.xpath(prop.getProperty("HomePage.AppLauncher.xpath")));
		//executor.executeScript("arguments[0].click();", appLauncher);
		explicitWaitStatement("xpath", prop.getProperty("HomePage.AppLauncher.xpath"));
		//String property = prop.getProperty("HomePage.AppLauncher.xpath");
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("HomePage.AppLauncher.xpath")));
		return this;
	}
	
	public SalesPageHybrid clickSales()
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("HomePage.Sales.xpath"))));
		explicitWaitStatement("xpath", prop.getProperty("HomePage.Sales.xpath"));
		//driver.findElement(By.xpath(prop.getProperty("HomePage.Sales.xpath"))).click();
		clickElement(locateElement("xpath", prop.getProperty("HomePage.Sales.xpath")));
		return new SalesPageHybrid();
	}
	
	public ServiceConsoleHomePageHybrid clickServiceConsole()
	{
		explicitWaitStatement("xpath", prop.getProperty("HomePage.ServiceConsole.xpath"));
		clickElement(locateElement("xpath", prop.getProperty("HomePage.ServiceConsole.xpath")));
		return new ServiceConsoleHomePageHybrid();
	}

}
