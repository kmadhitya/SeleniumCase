package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class AccountHomePageHybrid extends ProjectSpecMethods{
	
	/*public AccountHomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public AccountCreatePageHybrid clickNewButton()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountHomePage.NewButton.xpath")));
		return new AccountCreatePageHybrid();
	}
	
	public AccountDetailsPageHybrid openFirstAccount()
	{
		explicitWaitStatement("xpath", prop.getProperty("AccountHomePage.FirstDisplayedAccount.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("AccountHomePage.FirstDisplayedAccount.xpath")));
		return new AccountDetailsPageHybrid();
	}
	
	public AccountHomePageHybrid searchAccount(String searchText)
	{
		typeTextAndEnter(locateElement("xpath", prop.getProperty("AccountHomePage.searchTextBox.xpath")), searchText);
		return this;
	}
	
	public AccountHomePageHybrid clearSearchText()
	{
		explicitWaitStatement("xpath", prop.getProperty("AccountHomePage.clearSearchTextButton.xpath"));
		clickElement(locateElement("xpath", prop.getProperty("AccountHomePage.clearSearchTextButton.xpath")));
		return this;
	}
	
	public AccountHomePageHybrid verifyNoItemsToDisplay(String expectedText)
	{
		String actualText = getTheActualText(locateElement("xpath", prop.getProperty("AccountHomePage.NoItemsDisplayedMessage.xpath")));
		Assert.assertEquals(actualText, expectedText);
		return this;
	}
	
	
	
	

}
