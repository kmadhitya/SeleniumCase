package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class OpportunityEditPageHybrid extends ProjectSpecMethods{
	
	/*public OpportunityEditPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public OpportunityEditPageHybrid clearAndSelectDate()
	{
		//WebElement date = driver.findElement(By.xpath(prop.getProperty("OpportunityEditPage.CloseDate.xpath")));
		//date.clear();
		//date.sendKeys("10/30/2022");
		clearAndTypeText(locateElement("xpath", prop.getProperty("OpportunityEditPage.CloseDate.xpath")), "10/30/2022");
		return this;
	}
	
	public OpportunityEditPageHybrid selectStageAsPerceptionAnalysis()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityEditPage.Stage.xpath")));
		explicitWaitStatement("xpath", prop.getProperty("OpportunityEditPage.StageAsPerceptionAnalysis.xpath"));
		clickElement(locateElement("xpath", prop.getProperty("OpportunityEditPage.StageAsPerceptionAnalysis.xpath")));
		return this;
	}
	
	public OpportunityEditPageHybrid selectDeliveryStatusFromNoneToInprogress()
	{
		explicitWaitStatement("xpath", prop.getProperty("OpportunityEditPage.DeliveryStatus.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("OpportunityEditPage.DeliveryStatus.xpath")));
		explicitWaitStatement("xpath", prop.getProperty("OpportunityEditPage.DeliveryStatusAsInProgress.xpath"));
		clickElementUsingJavaScript(locateElement("xpath", prop.getProperty("OpportunityEditPage.DeliveryStatusAsInProgress.xpath")));
		return this;
	}
	
	public OpportunityDetailsPageHybrid clickSaveButton()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityEditPage.SaveButton.xpath")));
		return new OpportunityDetailsPageHybrid();
	}

}
