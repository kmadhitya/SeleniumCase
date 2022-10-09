package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.base.ProjectSpecMethods;

public class OpportunityEditPage extends ProjectSpecMethods{
	
	public OpportunityEditPage clearAndSelectDate()
	{
		WebElement date = driver.findElement(By.xpath("//label[text()='Close Date']/following-sibling::div[1]/input"));
		date.clear();
		date.sendKeys("10/30/2022");
		return this;
	}
	
	public OpportunityEditPage selectStageAsPerceptionAnalysis()
	{
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//span[text()='Needs Analysis']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Perception Analysis']")));
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		return this;
	}
	
	public OpportunityEditPage selectDeliveryStatusFromNoneToInprogress()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Delivery/Installation Status']/following-sibling::div[1]//span[contains(text(),'None')]")));
		WebElement deliveryStatus = driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following-sibling::div[1]//span[contains(text(),'None')]"));
		executor.executeScript("arguments[0].click();", deliveryStatus);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='In progress']")));
		WebElement deliveryStatusInProgress = driver.findElement(By.xpath("//span[@title='In progress']"));
		executor.executeScript("arguments[0].click();", deliveryStatusInProgress);
		return this;
	}
	
	public OpportunityDetailsPage clickSaveButton()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return new OpportunityDetailsPage();
	}

}
