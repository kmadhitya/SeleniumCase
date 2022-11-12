package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class LeadDetailsPageHybrid extends ProjectSpecMethods {
	
	/*public LeadDetailsPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public LeadDetailsPageHybrid verifyLeadName(String expectedName)
	{
		String actualText = getTheActualText(locateElement("xpath", "//div[text()='Lead']/following-sibling::slot//lightning-formatted-name"));
		Assert.assertEquals(actualText, expectedName);
		return this;
	}
	
	public LeadEditPageHybrid editLead()
	{
		clickElement(locateElement("xpath", "//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//button"));
		clickElement(locateElement("xpath", "//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//div//span[text()='Edit']"));
		return new LeadEditPageHybrid();
	}
	
	public LeadDetailsPageHybrid selectDetailsTab()
	{
		clickElement(locateElement("xpath", "(//a[text()='Details'])[1]"));
		return this;
	}
	
	public LeadDetailsPageHybrid verifyLeadStatus(String expected) 
	{
		String actualText = getTheActualText(locateElement("xpath", "//span[text()='Lead Status']/following::span[1]//lightning-formatted-text"));
		Assert.assertEquals(actualText, expected);
		return this;
	}
	

}
