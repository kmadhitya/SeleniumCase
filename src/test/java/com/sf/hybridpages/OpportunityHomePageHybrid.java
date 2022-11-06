package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.projectspecmethod.ProjectSpecMethods;

public class OpportunityHomePageHybrid extends ProjectSpecMethods{
	
	public OpportunityHomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public OpportunityCreatePageHybrid clickNewButton()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.NewButton.xpath"))).click();
		return new OpportunityCreatePageHybrid(driver);
	}
	
	public OpportunityDetailsPageHybrid openOpportunity()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityHomePage.FirstDisplayedOpportunity.xpath"))));
		WebElement opportunityName = driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.FirstDisplayedOpportunity.xpath")));
		executor.executeScript("arguments[0].click();", opportunityName);
		return new OpportunityDetailsPageHybrid(driver);
	}
	
	public OpportunityHomePageHybrid searchOpportunity(String searchText)
	{
		//driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.searchTextBox.xpath"))).sendKeys(searchText, Keys.ENTER);
		typeText(locateElement("xpath", prop.getProperty("OpportunityHomePage.searchTextBox.xpath")), searchText);
		return this;
	}
	
	public OpportunityHomePageHybrid clearSearchText()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.clearSearchTextButton.xpath"))).click();
		return this;
	}
	
	public OpportunityHomePageHybrid verifyNoItemsDisplayedMessage(String expectedText)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.NoItemsDisplayedMessage.xpath"))).getText();
		Assert.assertEquals(actualText, expectedText);
		return this;
	}

}
