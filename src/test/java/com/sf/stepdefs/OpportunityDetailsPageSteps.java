package com.sf.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpportunityDetailsPageSteps extends BasicSteps {
	
	@Then ("I verify the Toast Message {string}")
	public void verifyToastMessage(String toastExpectedText)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("OpportunityDetailsPage.ToastMessage.xpath"))));
		String toastText = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.ToastMessage.xpath"))).getText();
		System.out.println("Toast message is : " + toastText);
		Assert.assertEquals(toastText, toastExpectedText);
	}
	
	@Then ("I verify the Opportunity Name {string}")
	public void verifyOpportunityName(String name)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.OpportunityName.xpath"))).getText();
		Assert.assertEquals(actualText, name);
	}
	
	@When ("I edit the Opportunity")
	public void editOpportunity()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.OpportunityDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.EditOpportunityButton.xpath"))).click();
	}
	
	@When ("I click on delete Opportunity")
	public void deleteOpportunity()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.OpportunityDropdownButton.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.DeleteOpportunityButton.xpath"))).click();
	}
	
	@When ("I click on confirm delete")
	public void confirmDelete()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.ConfirmDeleteButton.xpath"))).click();
	}
	
	@Then ("I select Details tab")
	public void selectDetailsTab()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.DetailsTab.xpath"))).click();
	}
	
	@Then ("I verify Close Date")
	public void verifyCloseDate() 
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.CloseDate.xpath"))).getText();		
		Assert.assertEquals(actualText, "10/30/2022");
	}
	
	@Then ("I verify the Stage value {string}")
	public void verifyStage(String stage)
	{
		String actualText2 = driver.findElement(By.xpath(prop.getProperty("OpportunityDetailsPage.Stage.xpath"))).getText();
		Assert.assertEquals(actualText2, stage);
	}

}
