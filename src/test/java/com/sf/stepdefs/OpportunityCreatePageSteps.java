package com.sf.stepdefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;

public class OpportunityCreatePageSteps extends BasicSteps {
	
	@When ("I enter Opportunity Name {string}")
	public void enterOpportunityName(String name)
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.OpportunityName.xpath"))).sendKeys(name);
	}
	
	@When ("I select CloseDate As Today")
	public void selectCloseDateAsToday()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.CloseDate.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.CloseDateAsToday.xpath"))).click();
	}
	
	@When ("I select Stage As Needs Analysis {string}")
	public void selectStageAsNeedsAnalysis(String stage)
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.Stage.xpath"))).click();
		//driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.StageAsNeedsAnalysis.xpath"))).click();
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//span[text()='"+stage+"']")).click();
	}

}
