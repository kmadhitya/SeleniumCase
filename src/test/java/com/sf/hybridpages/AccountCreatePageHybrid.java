package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class AccountCreatePageHybrid extends ProjectSpecMethods{
	
	public AccountCreatePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public AccountCreatePageHybrid enterAccountName(String accountName)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.AccountName.xpath"))).sendKeys(accountName);
		return this;
	}
	
	public AccountCreatePageHybrid selectOwnershipAsPublic()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.Ownership.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.OwnershipAsPublic.xpath"))).click();
		return this;
	}
	
	public AccountDetailsPageHybrid clickSaveButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.SaveButton.xpath"))).click();
		return new AccountDetailsPageHybrid(driver);
	}

}
