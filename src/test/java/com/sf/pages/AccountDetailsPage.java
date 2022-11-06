package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class AccountDetailsPage extends ProjectSpecMethods{
	
	public AccountDetailsPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public AccountDetailsPage verifyAccountName(String accountName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountDetailsPage.AccountName.xpath"))));
		String actualText = driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.AccountName.xpath"))).getText();
		Assert.assertEquals(actualText, accountName);
		return this;
	}
	
	public AccountEditPage editAccount()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.AccountDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.EditAccountButton.xpath"))).click();
		return new AccountEditPage(driver);
	}
	
	public AccountDetailsPage selectDetailsTab()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.DetailsTab.xpath"))).click();
		return this;
	}
	
	public AccountDetailsPage verifyType(String typeValue)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.Type.xpath"))).getText();
		Assert.assertEquals(actualText, typeValue);
		return this;
	}
	
	public AccountDetailsPage deleteAccount()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.AccountDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.DeleteAccountButton.xpath"))).click();
		return this;
	}
	
	public AccountHomePage confirmDeleteAccount()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.ConfirmDeleteButton.xpath"))).click();
		return new AccountHomePage(driver);
	}
	
	
	
	

}
