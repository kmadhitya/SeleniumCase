package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.base.ProjectSpecMethods;

public class LeadDetailsPage extends ProjectSpecMethods {
	
	public LeadDetailsPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public LeadDetailsPage verifyLeadName(String expectedName)
	{
		String actualText = driver.findElement(By.xpath("//div[text()='Lead']/following-sibling::slot//lightning-formatted-name")).getText();
		Assert.assertEquals(actualText, expectedName);
		return this;
	}
	

}
