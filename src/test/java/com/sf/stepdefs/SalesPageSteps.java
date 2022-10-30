package com.sf.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;

public class SalesPageSteps extends BasicSteps {
	
	@Given("I click on Opportunity label")
	public void clickOpportunityLabel()
	{
		WebElement opportunity = driver.findElement(By.xpath(prop.getProperty("SalesPage.OpportunityLabel.xpath")));
		executor.executeScript("arguments[0].click();", opportunity);
	}
	
	@Given("I click on Account label")
	public void clickAccountLabel()
	{
		WebElement account = driver.findElement(By.xpath(prop.getProperty("SalesPage.AccountLabel.xpath")));
		executor.executeScript("arguments[0].click();", account);
	}

}
