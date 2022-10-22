package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.base.ProjectSpecMethods;

public class AccountCreatePage extends ProjectSpecMethods{
	
	public AccountCreatePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public AccountCreatePage enterAccountName(String accountName)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.AccountName.xpath"))).sendKeys(accountName);
		return this;
	}
	
	public AccountCreatePage selectOwnershipAsPublic()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.Ownership.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.OwnershipAsPublic.xpath"))).click();
		return this;
	}
	
	public AccountDetailsPage clickSaveButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.SaveButton.xpath"))).click();
		return new AccountDetailsPage(driver);
	}

}
