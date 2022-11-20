package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

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
	
	public LeadEditPage editLead()
	{
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//div//span[text()='Edit']")).click();
		return new LeadEditPage(driver);
	}
	
	public LeadDetailsPage deleteLead()
	{
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//div//span[text()='Delete']")).click();
		return this;
	}
	
	public LeadHomePage confirmDelete()
	{
		driver.findElement(By.xpath("//div[text()='Are you sure you want to delete this lead?']/ancestor::div/following-sibling::div//button//span[text()='Delete']")).click();
		return new LeadHomePage(driver);
	}
	
	public LeadDetailsPage selectDetailsTab()
	{
		driver.findElement(By.xpath("(//a[text()='Details'])[1]")).click();
		return this;
	}
	
	public LeadDetailsPage verifyLeadStatus(String expected) 
	{
		String actualText = driver.findElement(By.xpath("//span[text()='Lead Status']/following::span[1]//lightning-formatted-text")).getText();
		Assert.assertEquals(actualText, expected);
		return this;
	}
	

}
