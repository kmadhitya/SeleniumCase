package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class OpportunityDetailsPageHybrid extends ProjectSpecMethods{
	
	/*public OpportunityDetailsPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public OpportunityDetailsPageHybrid verifyToastMessage(String toastExpectedText)
	{
		explicitWaitStatement("xpath", prop.getProperty("OpportunityDetailsPage.ToastMessage.xpath"));
		String toastText = getTheActualText(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.ToastMessage.xpath")));
		System.out.println("Toast message is : " + toastText);
		Assert.assertEquals(toastText, toastExpectedText);
		return this;
	}
	
	public OpportunityDetailsPageHybrid verifyOpportunityName(String name)
	{
		String actualText = getTheActualText(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.OpportunityName.xpath")));
		Assert.assertEquals(actualText, name);
		return this;
	}
	
	public OpportunityEditPageHybrid editOpportunity()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.OpportunityDropdownButton.xpath")));
		clickElement(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.EditOpportunityButton.xpath")));
		return new OpportunityEditPageHybrid();
	}
	
	public OpportunityDetailsPageHybrid deleteOpportunity()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.OpportunityDropdownButton.xpath")));
		clickElement(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.DeleteOpportunityButton.xpath")));
		return this;
	}
	
	public OpportunityHomePageHybrid confirmDelete()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.ConfirmDeleteButton.xpath")));
		return new OpportunityHomePageHybrid();
	}
	
	public OpportunityDetailsPageHybrid selectDetailsTab()
	{
		clickElement(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.DetailsTab.xpath")));
		return this;
	}
	
	public OpportunityDetailsPageHybrid verifyCloseDate() 
	{
		String actualText = getTheActualText(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.CloseDate.xpath")));
		Assert.assertEquals(actualText, "10/30/2022");
		return this;
	}
	
	public OpportunityDetailsPageHybrid verifyStage(String stage)
	{
		String actualText2 = getTheActualText(locateElement("xpath", prop.getProperty("OpportunityDetailsPage.Stage.xpath")));
		Assert.assertEquals(actualText2, stage);
		return this;
	}

}
