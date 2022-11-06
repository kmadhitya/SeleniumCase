package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.projectspecmethod.ProjectSpecMethods;

public class OpportunityCreatePageHybrid extends ProjectSpecMethods{
	
	public OpportunityCreatePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public OpportunityCreatePageHybrid enterOpportunityName(String name)
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.OpportunityName.xpath"))).sendKeys(name);
		return this;
	}
	
	public OpportunityCreatePageHybrid selectCloseDateAsToday()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.CloseDate.xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.CloseDateAsToday.xpath"))).click();
		return this;
	}
	
	public OpportunityCreatePageHybrid selectStageAsNeedsAnalysis(String stage)
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.Stage.xpath"))).click();
		//driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.StageAsNeedsAnalysis.xpath"))).click();
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//span[text()='"+stage+"']")).click();
		return this;
	}
	
	public OpportunityDetailsPageHybrid clickSaveButton()
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.SaveButton.xpath"))).click();
		return new OpportunityDetailsPageHybrid(driver);
	}

}
