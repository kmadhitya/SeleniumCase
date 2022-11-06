package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.projectspecmethod.ProjectSpecMethods;

public class AccountDetailsPageHybrid extends ProjectSpecMethods{
	
	public AccountDetailsPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public AccountDetailsPageHybrid verifyAccountName(String accountName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountDetailsPage.AccountName.xpath"))));
		String actualText = driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.AccountName.xpath"))).getText();
		Assert.assertEquals(actualText, accountName);
		return this;
	}
	
	public AccountEditPageHybrid editAccount()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.AccountDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.EditAccountButton.xpath"))).click();
		return new AccountEditPageHybrid(driver);
	}
	
	public AccountDetailsPageHybrid selectDetailsTab()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.DetailsTab.xpath"))).click();
		return this;
	}
	
	public AccountDetailsPageHybrid verifyType(String typeValue)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.Type.xpath"))).getText();
		Assert.assertEquals(actualText, typeValue);
		return this;
	}
	
	public AccountDetailsPageHybrid deleteAccount()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.AccountDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.DeleteAccountButton.xpath"))).click();
		return this;
	}
	
	public AccountHomePageHybrid confirmDeleteAccount()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.ConfirmDeleteButton.xpath"))).click();
		return new AccountHomePageHybrid(driver);
	}
	
	
	
	

}
