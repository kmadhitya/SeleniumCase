package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class LeadEditPageHybrid extends ProjectSpecMethods {
	
	/*public LeadEditPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public LeadEditPageHybrid enterLastName(String lastName)
	{
		explicitWaitStatement("xpath", "//label[text()='Last Name']/following-sibling::div[1]/input");
		typeText(locateElement("xpath", "//label[text()='Last Name']/following-sibling::div[1]/input"), lastName);
		return this;
	}
	
	public LeadEditPageHybrid selectLeadStatusAsWorkingContacted()
	{
		explicitWaitStatement("xpath", "//label[text()='Lead Status']/following-sibling::div[1]//button");
		clickElementUsingJavaScript(locateElement("xpath", "//label[text()='Lead Status']/following-sibling::div[1]//button"));
		clickElementUsingJavaScript(locateElement("xpath", "//span[@title='Working - Contacted']"));
		return this;
	}
	
	public LeadDetailsPageHybrid clickSaveButton()
	{
		clickElement(locateElement("xpath", "//button[text()='Save']"));
		return new LeadDetailsPageHybrid();
	}	
	

}
