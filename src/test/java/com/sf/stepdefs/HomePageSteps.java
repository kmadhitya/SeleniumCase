package com.sf.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;

public class HomePageSteps extends BasicSteps {
	
	@Given ("I click on the AppLauncher")
	public void clickAppLauncher()
	{
		WebElement appLauncher = driver.findElement(By.xpath(prop.getProperty("HomePage.AppLauncher.xpath")));
		executor.executeScript("arguments[0].click();", appLauncher);
	}
	
	@Given("I click on Sales")
	public void clickSales()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("HomePage.Sales.xpath"))));
		driver.findElement(By.xpath(prop.getProperty("HomePage.Sales.xpath"))).click();
	}

}
