package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.projectspecmethod.ProjectSpecMethods;

public class OpportunityDetailsPageHybrid extends ProjectSpecMethods{
	
	public OpportunityDetailsPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public OpportunityDetailsPageHybrid verifyToastMessage(String toastExpectedText)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityDetailsPage.ToastMessage.xpath"))));
		String toastText = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.ToastMessage.xpath"))).getText();
		System.out.println("Toast message is : " + toastText);
		Assert.assertEquals(toastText, toastExpectedText);
		return this;
	}
	
	public OpportunityDetailsPageHybrid verifyOpportunityName(String name)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.OpportunityName.xpath"))).getText();
		Assert.assertEquals(actualText, name);
		return this;
	}
	
	public OpportunityEditPageHybrid editOpportunity()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.OpportunityDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.EditOpportunityButton.xpath"))).click();
		return new OpportunityEditPageHybrid(driver);
	}
	
	public OpportunityDetailsPageHybrid deleteOpportunity()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.OpportunityDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.DeleteOpportunityButton.xpath"))).click();
		return this;
	}
	
	public OpportunityHomePageHybrid confirmDelete()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.ConfirmDeleteButton.xpath"))).click();
		return new OpportunityHomePageHybrid(driver);
	}
	
	public OpportunityDetailsPageHybrid selectDetailsTab()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.DetailsTab.xpath"))).click();
		return this;
	}
	
	public OpportunityDetailsPageHybrid verifyCloseDate() 
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.CloseDate.xpath"))).getText();		
		Assert.assertEquals(actualText, "10/30/2022");
		return this;
	}
	
	public OpportunityDetailsPageHybrid verifyStage(String stage)
	{
		String actualText2 = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.Stage.xpath"))).getText();
		Assert.assertEquals(actualText2, stage);
		return this;
	}

}
