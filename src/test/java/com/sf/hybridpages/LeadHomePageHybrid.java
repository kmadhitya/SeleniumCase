package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class LeadHomePageHybrid extends ProjectSpecMethods {
	
	/*public LeadHomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public LeadCreatePageHybrid clickNewButton()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountHomePage.NewButton.xpath")));
		return new LeadCreatePageHybrid();
	}
	
	public LeadDetailsPageHybrid openLead()
	{
		explicitWaitStatement("xpath", "(//a[text()='Kumar'])[1]");
		clickElementUsingJavaScript(locateElement("xpath", "(//a[text()='Kumar'])[1]"));
		return new LeadDetailsPageHybrid();
	}

}
