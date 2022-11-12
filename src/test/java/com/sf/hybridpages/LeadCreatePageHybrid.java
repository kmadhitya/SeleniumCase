package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class LeadCreatePageHybrid extends ProjectSpecMethods {
	
	/*public LeadCreatePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public LeadCreatePageHybrid selectSalutationAsMr()
	{
		clickElement(locateElement("xpath", "//label[text()='Salutation']/following-sibling::div[1]//button"));
		clickElement(locateElement("xpath", "//label[text()='Salutation']/following-sibling::div[1]//span[text()='Mr.']"));
		return this;
	}
	
	public LeadCreatePageHybrid enterLastName(String name)
	{
		typeText(locateElement("xpath", "//label[text()='Last Name']/following-sibling::div[1]/input"), name);
		return this;
	}
	
	public LeadCreatePageHybrid enterCompanyName(String company)
	{
		typeText(locateElement("xpath", "//label[text()='Company']/following-sibling::div[1]/input"), company);
		return this;
	}
	
	public LeadDetailsPageHybrid clickSaveButton()
	{
		clickElement(locateElement("xpath", prop.getProperty("AccountCreatePage.SaveButton.xpath")));
		return new LeadDetailsPageHybrid();
	}

}
