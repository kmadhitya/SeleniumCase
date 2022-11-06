package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class SalesPageHybrid extends ProjectSpecMethods{
	
	/*public SalesPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public OpportunityHomePageHybrid clickOpportunityLabel()
	{
		//WebElement opportunity = driver.findElement(By.xpath(prop.getProperty("SalesPage.OpportunityLabel.xpath")));
		//executor.executeScript("arguments[0].click();", opportunity);
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("SalesPage.OpportunityLabel.xpath")));
		return new OpportunityHomePageHybrid();
	}
	
	public AccountHomePageHybrid clickAccountLabel()
	{
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("SalesPage.AccountLabel.xpath")));
		return new AccountHomePageHybrid();
	}
	
	public LeadHomePageHybrid clickLeadLabel()
	{
		clickElementUsingJavaScript(locateElement("xpath", "//span[text()='Leads']"));
		return new LeadHomePageHybrid();
	}

}
