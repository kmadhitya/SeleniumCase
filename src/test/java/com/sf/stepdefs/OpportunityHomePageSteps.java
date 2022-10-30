package com.sf.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.When;

public class OpportunityHomePageSteps extends BasicSteps {
	
	@When ("I open the Opportunity")
	public void openOpportunity()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityHomePage.FirstDisplayedOpportunity.xpath"))));
		WebElement opportunityName = driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.FirstDisplayedOpportunity.xpath")));
		executor.executeScript("arguments[0].click();", opportunityName);
	}
	
	@When ("I search the Opportunity using {string}")
	public void searchOpportunity(String searchText)
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.searchTextBox.xpath"))).sendKeys(searchText, Keys.ENTER);
	}

}
