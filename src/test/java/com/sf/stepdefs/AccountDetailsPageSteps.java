package com.sf.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountDetailsPageSteps extends BasicSteps {
	
	@Then ("I verify the Account Name {string}")
	public void verifyAccountName(String accountName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountDetailsPage.AccountName.xpath"))));
		String actualText = driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.AccountName.xpath"))).getText();
		Assert.assertEquals(actualText, accountName);
	}
	
	@When ("I edit the Account")
	public void editAccount()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.AccountDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.EditAccountButton.xpath"))).click();
	}
	
	@Then ("I select Account Details tab")
	public void selectAccountDetailsTab()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.DetailsTab.xpath"))).click();
	}
	
	@Then ("I verify the Type {string}")
	public void verifyType(String typeValue)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.Type.xpath"))).getText();
		Assert.assertEquals(actualText, typeValue);
	}
	
	@When ("I delete Account")
	public void deleteAccount()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.AccountDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.DeleteAccountButton.xpath"))).click();
	}
	
	@When ("I confirm Delete Account")
	public void confirmDeleteAccount()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountDetailsPage.ConfirmDeleteButton.xpath"))).click();
	}

}
