package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.base.ProjectSpecMethods;

public class SalesPage extends ProjectSpecMethods{
	
	public SalesPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public OpportunityHomePage clickOpportunityLabel()
	{
		WebElement opportunity = driver.findElement(By.xpath(prop.getProperty("SalesPage.OpportunityLabel.xpath")));
		executor.executeScript("arguments[0].click();", opportunity);
		return new OpportunityHomePage(driver);
	}
	
	public AccountHomePage clickAccountLabel()
	{
		WebElement account = driver.findElement(By.xpath(prop.getProperty("SalesPage.AccountLabel.xpath")));
		executor.executeScript("arguments[0].click();", account);
		return new AccountHomePage(driver);
	}

}
