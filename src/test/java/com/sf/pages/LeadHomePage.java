package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.base.ProjectSpecMethods;

public class LeadHomePage extends ProjectSpecMethods {
	
	public LeadHomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public LeadCreatePage clickNewButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.NewButton.xpath"))).click();
		return new LeadCreatePage(driver);
	}
	
	public LeadDetailsPage openLead()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Kumar'])[1]")));
		WebElement leadName = driver.findElement(By.xpath("(//a[text()='Kumar'])[1]"));
		executor.executeScript("arguments[0].click();", leadName);
		return new LeadDetailsPage(driver);
	}

}
