package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.base.ProjectSpecMethods;

public class OpportunityCreatePage extends ProjectSpecMethods{
	
	public OpportunityCreatePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public OpportunityCreatePage enterOpportunityName(String name)
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.OpportunityName.xpath"))).sendKeys(name);
		return this;
	}
	
	public OpportunityCreatePage selectCloseDateAsToday()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.CloseDate.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.CloseDateAsToday.xpath"))).click();
		return this;
	}
	
	public OpportunityCreatePage selectStageAsNeedsAnalysis(String stage)
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.Stage.xpath"))).click();
		//driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.StageAsNeedsAnalysis.xpath"))).click();
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//span[text()='"+stage+"']")).click();
		return this;
	}
	
	public OpportunityDetailsPage clickSaveButton()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.SaveButton.xpath"))).click();
		return new OpportunityDetailsPage(driver);
	}

}
