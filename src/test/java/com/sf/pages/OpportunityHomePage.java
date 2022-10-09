package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.base.ProjectSpecMethods;

public class OpportunityHomePage extends ProjectSpecMethods{
	
	public OpportunityCreatePage clickNewButton()
	{
		driver.findElement(By.xpath("//div[text()='New']")).click();
		return new OpportunityCreatePage();
	}
	
	public OpportunityDetailsPage openOpportunity()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Salesforce Automation by Adhitya123'])[1]")));
		WebElement opportunityName = driver.findElement(By.xpath("(//a[text()='Salesforce Automation by Adhitya123'])[1]"));
		executor.executeScript("arguments[0].click();", opportunityName);
		return new OpportunityDetailsPage();
	}
	
	public OpportunityHomePage searchOpportunity(String searchText)
	{
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(searchText, Keys.ENTER);
		return this;
	}
	
	public OpportunityHomePage clearSearchText()
	{
		driver.findElement(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")).click();
		return this;
	}
	
	public OpportunityHomePage verifyNoItemsDisplayedMessage(String expectedText)
	{
		String actualText = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		Assert.assertEquals(actualText, expectedText);
		return this;
	}

}
