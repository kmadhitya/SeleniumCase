package com.sf.pages;

import org.openqa.selenium.By;

import com.sf.base.ProjectSpecMethods;

public class OpportunityCreatePage extends ProjectSpecMethods{
	
	public OpportunityCreatePage enterOpportunityName(String name)
	{
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following-sibling::div[1]/input")).sendKeys(name);
		return this;
	}
	
	public OpportunityCreatePage selectCloseDateAsToday()
	{
		driver.findElement(By.xpath("//label[text()='Close Date']/following-sibling::div[1]/input")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		return this;
	}
	
	public OpportunityCreatePage selectStageAsNeedsAnalysis()
	{
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//button")).click();
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//span[text()='Needs Analysis']")).click();
		return this;
	}
	
	public OpportunityDetailsPage clickSaveButton()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return new OpportunityDetailsPage();
	}

}
