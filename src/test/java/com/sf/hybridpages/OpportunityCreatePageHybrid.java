package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class OpportunityCreatePageHybrid extends ProjectSpecMethods{
	
	/*public OpportunityCreatePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public OpportunityCreatePageHybrid enterOpportunityName(String name)
	{
		typeText(locateElement("xpath", prop.getProperty("OpportunityCreatePage.OpportunityName.xpath")), name);
		return this;
	}
	
	public OpportunityCreatePageHybrid selectCloseDateAsToday()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityCreatePage.CloseDate.xpath")));
		clickElement(locateElement("xpath", prop.getProperty("OpportunityCreatePage.CloseDateAsToday.xpath")));
		return this;
	}
	
	public OpportunityCreatePageHybrid selectStageAsNeedsAnalysis(String stage)
	{
		//driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.Stage.xpath"))).click();
		//driver.findElement(By.xpath(prop.getProperty("OpportunityCreatePage.StageAsNeedsAnalysis.xpath"))).click();
		//driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//span[text()='"+stage+"']")).click();
		clickElement(locateElement("xpath", prop.getProperty("OpportunityCreatePage.Stage.xpath")));
		clickElement(locateElement("xpath", "//label[text()='Stage']/following-sibling::div[1]//span[text()='"+stage+"']"));
		return this;
	}
	
	public OpportunityDetailsPageHybrid clickSaveButton()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityCreatePage.SaveButton.xpath")));
		return new OpportunityDetailsPageHybrid();
	}

}
