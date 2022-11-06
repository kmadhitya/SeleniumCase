package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class OpportunityDetailsPage extends ProjectSpecMethods{
	
	public OpportunityDetailsPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public OpportunityDetailsPage verifyToastMessage(String toastExpectedText)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityDetailsPage.ToastMessage.xpath"))));
		String toastText = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.ToastMessage.xpath"))).getText();
		System.out.println("Toast message is : " + toastText);
		Assert.assertEquals(toastText, toastExpectedText);
		return this;
	}
	
	public OpportunityDetailsPage verifyOpportunityName(String name)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.OpportunityName.xpath"))).getText();
		Assert.assertEquals(actualText, name);
		return this;
	}
	
	public OpportunityEditPage editOpportunity()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.OpportunityDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.EditOpportunityButton.xpath"))).click();
		return new OpportunityEditPage(driver);
	}
	
	public OpportunityDetailsPage deleteOpportunity()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.OpportunityDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.DeleteOpportunityButton.xpath"))).click();
		return this;
	}
	
	public OpportunityHomePage confirmDelete()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.ConfirmDeleteButton.xpath"))).click();
		return new OpportunityHomePage(driver);
	}
	
	public OpportunityDetailsPage selectDetailsTab()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.DetailsTab.xpath"))).click();
		return this;
	}
	
	public OpportunityDetailsPage verifyCloseDate() 
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.CloseDate.xpath"))).getText();		
		Assert.assertEquals(actualText, "10/30/2022");
		return this;
	}
	
	public OpportunityDetailsPage verifyStage(String stage)
	{
		String actualText2 = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.Stage.xpath"))).getText();
		Assert.assertEquals(actualText2, stage);
		return this;
	}

}
