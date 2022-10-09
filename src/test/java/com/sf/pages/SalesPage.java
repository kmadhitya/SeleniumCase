package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sf.base.ProjectSpecMethods;

public class SalesPage extends ProjectSpecMethods{
	
	public OpportunityHomePage clickOpportunityLabel()
	{
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		executor.executeScript("arguments[0].click();", opportunity);
		return new OpportunityHomePage();
	}
	
	public AccountHomePage clickAccountLabel()
	{
		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		executor.executeScript("arguments[0].click();", account);
		return new AccountHomePage();
	}

}
