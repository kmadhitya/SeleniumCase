package com.sf.stepdefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;

public class AccountCreatePageSteps extends BasicSteps {
	
	@When ("I enter Account Name {string}")
	public void enterAccountName(String accountName)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.AccountName.xpath"))).sendKeys(accountName);
	}
	
	@When ("I select Ownership as Public")
	public void selectOwnershipAsPublic()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.Ownership.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("AccountCreatePage.OwnershipAsPublic.xpath"))).click();
	}

}
