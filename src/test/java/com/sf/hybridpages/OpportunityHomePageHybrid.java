package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class OpportunityHomePageHybrid extends ProjectSpecMethods{
	
	/*public OpportunityHomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public OpportunityCreatePageHybrid clickNewButton()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityHomePage.NewButton.xpath")));
		return new OpportunityCreatePageHybrid();
	}
	
	public OpportunityDetailsPageHybrid openOpportunity()
	{
		explicitWaitStatement("xpath", prop.getProperty("OpportunityHomePage.FirstDisplayedOpportunity.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("OpportunityHomePage.FirstDisplayedOpportunity.xpath")));
		return new OpportunityDetailsPageHybrid();
	}
	
	public OpportunityHomePageHybrid searchOpportunity(String searchText)
	{
		//driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.searchTextBox.xpath"))).sendKeys(searchText, Keys.ENTER);
		typeText(locateElement("xpath", prop.getProperty("OpportunityHomePage.searchTextBox.xpath")), searchText);
		return this;
	}
	
	public OpportunityHomePageHybrid clearSearchText()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityHomePage.clearSearchTextButton.xpath")));
		return this;
	}
	
	public OpportunityHomePageHybrid verifyNoItemsDisplayedMessage(String expectedText)
	{
		//String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.NoItemsDisplayedMessage.xpath"))).getText();
		String actualText = getTheActualText(locateElement("xpath", prop.getProperty("OpportunityHomePage.NoItemsDisplayedMessage.xpath")));
		Assert.assertEquals(actualText, expectedText);
		return this;
	}

}
