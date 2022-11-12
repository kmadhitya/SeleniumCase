package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class AccountDetailsPageHybrid extends ProjectSpecMethods{
	
	/*public AccountDetailsPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public AccountDetailsPageHybrid verifyAccountName(String accountName)
	{
		explicitWaitStatement("xpath", prop.getProperty("AccountDetailsPage.AccountName.xpath"));
		String actualText = getTheActualText(locateElement("xpath", prop.getProperty("AccountDetailsPage.AccountName.xpath")));
		Assert.assertEquals(actualText, accountName);
		return this;
	}
	
	public AccountEditPageHybrid editAccount()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountDetailsPage.AccountDropdownButton.xpath")));
		clickElement(locateElement("xpath", prop.getProperty("AccountDetailsPage.EditAccountButton.xpath")));
		return new AccountEditPageHybrid();
	}
	
	public AccountDetailsPageHybrid selectDetailsTab()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountDetailsPage.DetailsTab.xpath")));
		return this;
	}
	
	public AccountDetailsPageHybrid verifyType(String typeValue)
	{
		String actualText = getTheActualText(locateElement("xpath", prop.getProperty("AccountDetailsPage.Type.xpath")));
		Assert.assertEquals(actualText, typeValue);
		return this;
	}
	
	public AccountDetailsPageHybrid deleteAccount()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountDetailsPage.AccountDropdownButton.xpath")));
		clickElement(locateElement("xpath", prop.getProperty("AccountDetailsPage.DeleteAccountButton.xpath")));
		return this;
	}
	
	public AccountHomePageHybrid confirmDeleteAccount()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountDetailsPage.ConfirmDeleteButton.xpath")));
		return new AccountHomePageHybrid();
	}
	
	
	
	

}
