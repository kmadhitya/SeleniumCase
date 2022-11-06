package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.projectspecmethod.ProjectSpecMethods;

public class SalesPageHybrid extends ProjectSpecMethods{
	
	public SalesPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public OpportunityHomePageHybrid clickOpportunityLabel()
	{
		WebElement opportunity = driver.findElement(By.xpath(prop.getProperty("SalesPage.OpportunityLabel.xpath")));
		executor.executeScript("arguments[0].click();", opportunity);
		return new OpportunityHomePageHybrid(driver);
	}
	
	public AccountHomePageHybrid clickAccountLabel()
	{
		WebElement account = driver.findElement(By.xpath(prop.getProperty("SalesPage.AccountLabel.xpath")));
		executor.executeScript("arguments[0].click();", account);
		return new AccountHomePageHybrid(driver);
	}
	
	public LeadHomePageHybrid clickLeadLabel()
	{
		WebElement leads = driver.findElement(By.xpath("//span[text()='Leads']"));
		executor.executeScript("arguments[0].click();", leads);
		return new LeadHomePageHybrid(driver);
	}

}
