package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.base.ProjectSpecMethods;

public class AccountHomePage extends ProjectSpecMethods{
	
	public AccountHomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public AccountCreatePage clickNewButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.NewButton.xpath"))).click();
		return new AccountCreatePage(driver);
	}
	
	public AccountDetailsPage openFirstAccount()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountHomePage.FirstDisplayedAccount.xpath"))));
		WebElement accountName = driver.findElement(By.xpath(prop.getProperty("AccountHomePage.FirstDisplayedAccount.xpath")));
		executor.executeScript("arguments[0].click();", accountName);
		return new AccountDetailsPage(driver);
	}
	
	public AccountHomePage searchAccount(String searchText)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.searchTextBox.xpath"))).sendKeys(searchText, Keys.ENTER);
		return this;
	}
	
	public AccountHomePage clearSearchText()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountHomePage.clearSearchTextButton.xpath"))));
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.clearSearchTextButton.xpath"))).click();
		return this;
	}
	
	public AccountHomePage verifyNoItemsToDisplay(String expectedText)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("AccountHomePage.NoItemsDisplayedMessage.xpath"))).getText();
		Assert.assertEquals(actualText, expectedText);
		return this;
	}
	
	
	
	

}
