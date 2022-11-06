package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class OpportunityHomePage extends ProjectSpecMethods{
	
	public OpportunityHomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public OpportunityCreatePage clickNewButton()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.NewButton.xpath"))).click();
		return new OpportunityCreatePage(driver);
	}
	
	public OpportunityDetailsPage openOpportunity()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityHomePage.FirstDisplayedOpportunity.xpath"))));
		WebElement opportunityName = driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.FirstDisplayedOpportunity.xpath")));
		executor.executeScript("arguments[0].click();", opportunityName);
		return new OpportunityDetailsPage(driver);
	}
	
	public OpportunityHomePage searchOpportunity(String searchText)
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.searchTextBox.xpath"))).sendKeys(searchText, Keys.ENTER);
		return this;
	}
	
	public OpportunityHomePage clearSearchText()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.clearSearchTextButton.xpath"))).click();
		return this;
	}
	
	public OpportunityHomePage verifyNoItemsDisplayedMessage(String expectedText)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.NoItemsDisplayedMessage.xpath"))).getText();
		Assert.assertEquals(actualText, expectedText);
		return this;
	}

}
