package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class LeadHomePage extends ProjectSpecMethods {
	
	public LeadHomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public LeadCreatePage clickNewButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.NewButton.xpath"))).click();
		return new LeadCreatePage(driver);
	}
	
	public LeadDetailsPage openLead()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Kumar'])[1]")));
		WebElement leadName = driver.findElement(By.xpath("(//a[text()='Kumar'])[1]"));
		executor.executeScript("arguments[0].click();", leadName);
		return new LeadDetailsPage(driver);
	}
	
	public LeadHomePage searchLead(String searchText)
	{
		driver.findElement(By.xpath(prop.getProperty("OpportunityHomePage.searchTextBox.xpath"))).sendKeys(searchText, Keys.ENTER);
		return this;
	}
	
	public LeadHomePage clearSearchText()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")));
		driver.findElement(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")).click();
		return this;
	}
	
	public LeadHomePage verifyNoItemsToDisplay(String expectedText)
	{
		String actualText = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		Assert.assertEquals(actualText, expectedText);
		return this;
	}

}
