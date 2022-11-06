package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.projectspecmethod.ProjectSpecMethods;

public class LeadDetailsPageHybrid extends ProjectSpecMethods {
	
	public LeadDetailsPageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public LeadDetailsPageHybrid verifyLeadName(String expectedName)
	{
		String actualText = driver.findElement(By.xpath("//div[text()='Lead']/following-sibling::slot//lightning-formatted-name")).getText();
		Assert.assertEquals(actualText, expectedName);
		return this;
	}
	
	public LeadEditPageHybrid editLead()
	{
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//div//span[text()='Edit']")).click();
		return new LeadEditPageHybrid(driver);
	}
	
	public LeadDetailsPageHybrid selectDetailsTab()
	{
		driver.findElement(By.xpath("(//a[text()='Details'])[1]")).click();
		return this;
	}
	
	public LeadDetailsPageHybrid verifyLeadStatus(String expected) 
	{
		String actualText = driver.findElement(By.xpath("//span[text()='Lead Status']/following::span[1]//lightning-formatted-text")).getText();
		Assert.assertEquals(actualText, expected);
		return this;
	}
	

}
