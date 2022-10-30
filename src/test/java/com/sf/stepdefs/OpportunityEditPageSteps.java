package com.sf.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.When;

public class OpportunityEditPageSteps extends BasicSteps {

	@When ("I clear and select Date")
	public void clearAndSelectDate()
	{
		WebElement date = driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.CloseDate.xpath")));
		date.clear();
		date.sendKeys("10/30/2022");
	}
	
	@When ("I select Stage as Perception Analysis")
	public void selectStageAsPerceptionAnalysis()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.Stage.xpath"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityEditPage.StageAsPerceptionAnalysis.xpath"))));
		driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.StageAsPerceptionAnalysis.xpath"))).click();
	}
	
	@When ("I select Delivery Status from None to In progress")
	public void selectDeliveryStatusFromNoneToInprogress()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityEditPage.DeliveryStatus.xpath"))));
		WebElement deliveryStatus = driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.DeliveryStatus.xpath")));
		executor.executeScript("arguments[0].click();", deliveryStatus);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityEditPage.DeliveryStatusAsInProgress.xpath"))));
		WebElement deliveryStatusInProgress = driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.DeliveryStatusAsInProgress.xpath")));
		executor.executeScript("arguments[0].click();", deliveryStatusInProgress);
	}
	
}
