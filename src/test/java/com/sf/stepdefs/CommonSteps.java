package com.sf.stepdefs;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends BasicSteps{
	
	@When ("I click on New button")
	public void clickNewButton()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.NewButton.xpath"))).click();
	}
	
	@When ("I click on Save button")
	public void clickSaveButton()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.SaveButton.xpath"))).click();
	}
	
	@When ("I click on clear Search Text")
	public void clearSearchText()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.clearSearchTextButton.xpath"))).click();
	}
	
	@Then ("I should see No Items Displayed Message {string}")
	public void verifyNoItemsDisplayedMessage(String expectedText)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.NoItemsDisplayedMessage.xpath"))).getText();
		Assert.assertEquals(actualText, expectedText);
	}

}
