package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class AccountCreatePageHybrid extends ProjectSpecMethods{
	
	/*public AccountCreatePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public AccountCreatePageHybrid enterAccountName(String accountName)
	{
		typeText(locateElement("xpath", prop.getProperty("AccountCreatePage.AccountName.xpath")), accountName);
		return this;
	}
	
	public AccountCreatePageHybrid selectOwnershipAsPublic()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountCreatePage.Ownership.xpath")));
		clickElement(locateElement("xpath", prop.getProperty("AccountCreatePage.OwnershipAsPublic.xpath")));
		return this;
	}
	
	public AccountDetailsPageHybrid clickSaveButton()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountCreatePage.SaveButton.xpath")));
		return new AccountDetailsPageHybrid();
	}

}
