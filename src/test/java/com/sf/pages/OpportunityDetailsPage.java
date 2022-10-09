package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.base.ProjectSpecMethods;

public class OpportunityDetailsPage extends ProjectSpecMethods{
	
	public OpportunityDetailsPage verifyToastMessage(String toastExpectedText)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toast')]")));
		String toastText = driver.findElement(By.xpath("//span[contains(@class,'toast')]")).getText();
		System.out.println("Toast message is : " + toastText);
		Assert.assertEquals(toastText, toastExpectedText);
		return this;
	}
	
	public OpportunityDetailsPage verifyOpportunityName(String name)
	{
		String actualText = driver.findElement(By.xpath("//div[text()='Opportunity']/following-sibling::slot/lightning-formatted-text")).getText();
		Assert.assertEquals(actualText, name);
		return this;
	}
	
	public OpportunityEditPage editOpportunity()
	{
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//div//span[text()='Edit']")).click();
		return new OpportunityEditPage();
	}
	
	public OpportunityDetailsPage deleteOpportunity()
	{
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//div//span[text()='Delete']")).click();
		return this;
	}
	
	public OpportunityHomePage confirmDelete()
	{
		driver.findElement(By.xpath("//div[text()='Are you sure you want to delete this opportunity?']/ancestor::div/following-sibling::div//button//span[text()='Delete']")).click();
		return new OpportunityHomePage();
	}
	
	public OpportunityDetailsPage selectDetailsTab()
	{
		driver.findElement(By.xpath("(//a[text()='Details'])[1]")).click();
		return this;
	}
	
	public OpportunityDetailsPage verifyCloseDate() 
	{
		String actualText = driver.findElement(By.xpath("(//span[text()='Close Date'])[2]/following::span[1]//lightning-formatted-text")).getText();		
		Assert.assertEquals(actualText, "10/30/2022");
		return this;
	}
	
	public OpportunityDetailsPage verifyStage(String stage)
	{
		String actualText2 = driver.findElement(By.xpath("(//span[text()='Stage'])[2]/following::span[1]//lightning-formatted-text")).getText();
		Assert.assertEquals(actualText2, stage);
		return this;
	}

}
