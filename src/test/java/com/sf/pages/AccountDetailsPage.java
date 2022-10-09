package com.sf.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sf.base.ProjectSpecMethods;

public class AccountDetailsPage extends ProjectSpecMethods{
	
	public AccountDetailsPage verifyOpportunityName(String accountName)
	{
		String actualText = driver.findElement(By.xpath("//div[text()='Account']/following-sibling::slot//lightning-formatted-text")).getText();
		Assert.assertEquals(actualText, accountName);
		return this;
	}
	
	public AccountEditPage editAccount()
	{
		driver.findElement(By.xpath("//button[text()='New Note']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("//button[text()='New Note']/ancestor::li/following-sibling::li//div//span[text()='Edit']")).click();
		return new AccountEditPage();
	}
	
	public AccountDetailsPage selectDetailsTab()
	{
		driver.findElement(By.xpath("(//a[text()='Details'])[1]")).click();
		return this;
	}
	
	public AccountDetailsPage verifyType(String typeValue)
	{
		String actualText = driver.findElement(By.xpath("//span[text()='Type']/following::span[1]//lightning-formatted-text")).getText();
		Assert.assertEquals(actualText, typeValue);
		return this;
	}

}
