package com.sf.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sf.base.ProjectSpecMethods;

public class HomePage extends ProjectSpecMethods{
	
	public HomePage clickAppLauncher()
	{
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		executor.executeScript("arguments[0].click();", appLauncher);
		return this;
	}
	
	public SalesPage clickSales()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Sales']")));
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		return new SalesPage();
	}

}
