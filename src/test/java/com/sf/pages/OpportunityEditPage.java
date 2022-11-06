package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class OpportunityEditPage extends ProjectSpecMethods{
	
	public OpportunityEditPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public OpportunityEditPage clearAndSelectDate()
	{
		WebElement date = driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.CloseDate.xpath")));
		date.clear();
		date.sendKeys("10/30/2022");
		return this;
	}
	
	public OpportunityEditPage selectStageAsPerceptionAnalysis()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.Stage.xpath"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityEditPage.StageAsPerceptionAnalysis.xpath"))));
		driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.StageAsPerceptionAnalysis.xpath"))).click();
		return this;
	}
	
	public OpportunityEditPage selectDeliveryStatusFromNoneToInprogress()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityEditPage.DeliveryStatus.xpath"))));
		WebElement deliveryStatus = driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.DeliveryStatus.xpath")));
		executor.executeScript("arguments[0].click();", deliveryStatus);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityEditPage.DeliveryStatusAsInProgress.xpath"))));
		WebElement deliveryStatusInProgress = driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.DeliveryStatusAsInProgress.xpath")));
		executor.executeScript("arguments[0].click();", deliveryStatusInProgress);
		return this;
	}
	
	public OpportunityDetailsPage clickSaveButton()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.SaveButton.xpath"))).click();
		return new OpportunityDetailsPage(driver);
	}

}
