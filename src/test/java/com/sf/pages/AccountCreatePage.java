package com.sf.pages;

import org.openqa.selenium.By;

import com.sf.base.ProjectSpecMethods;

public class AccountCreatePage extends ProjectSpecMethods{
	
	public AccountCreatePage enterAccountName(String accountName)
	{
		driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div[1]/input")).sendKeys(accountName);
		return this;
	}
	
	public AccountCreatePage selectOwnershipAsPublic()
	{
		driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div[1]//button")).click();
		driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div[1]//span[text()='Public']")).click();
		return this;
	}
	
	public OpportunityDetailsPage clickSaveButton()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return new OpportunityDetailsPage();
	}

}
