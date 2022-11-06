package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class LeadEditPage extends ProjectSpecMethods {
	
	public LeadEditPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public LeadEditPage enterLastName(String lastName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Last Name']/following-sibling::div[1]/input")));
		driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::div[1]/input")).sendKeys(lastName);
		return this;
	}
	
	public LeadEditPage selectLeadStatusAsWorkingContacted()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Lead Status']/following-sibling::div[1]//button")));
		WebElement leadStatus = driver.findElement(By.xpath("//label[text()='Lead Status']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", leadStatus);
		WebElement leadStatusValue = driver.findElement(By.xpath("//span[@title='Working - Contacted']"));
		executor.executeScript("arguments[0].click();", leadStatusValue);
		return this;
	}
	
	public LeadDetailsPage clickSaveButton()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return new LeadDetailsPage(driver);
	}	
	

}
