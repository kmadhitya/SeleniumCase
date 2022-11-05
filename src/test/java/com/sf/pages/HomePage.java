package com.sf.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sf.base.ProjectSpecMethods;

public class HomePage extends ProjectSpecMethods{
	
	public HomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public HomePage clickAppLauncher()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("HomePage.AppLauncher.xpath"))));
		WebElement appLauncher = driver.findElement(By.xpath(prop.getProperty("HomePage.AppLauncher.xpath")));
		executor.executeScript("arguments[0].click();", appLauncher);
		return this;
	}
	
	public SalesPage clickSales()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("HomePage.Sales.xpath"))));
		driver.findElement(By.xpath(prop.getProperty("HomePage.Sales.xpath"))).click();
		return new SalesPage(driver);
	}
	
	public ServiceConsoleHomePage clickServiceConsole()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("HomePage.ServiceConsole.xpath"))));
		driver.findElement(By.xpath(prop.getProperty("HomePage.ServiceConsole.xpath"))).click();
		return new ServiceConsoleHomePage(driver);
	}

}
