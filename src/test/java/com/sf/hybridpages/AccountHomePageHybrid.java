package com.sf.hybridpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sf.hybridprojectspecmethod.ProjectSpecMethods;

public class AccountHomePageHybrid extends ProjectSpecMethods{
	
	/*public AccountHomePageHybrid(ChromeDriver driver)
	{
		this.driver = driver;
	}*/
	
	public AccountCreatePageHybrid clickNewButton()
	{
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.NewButton.xpath"))).click();
		return new AccountCreatePageHybrid(driver);
	}
	
	public AccountDetailsPageHybrid openFirstAccount()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountHomePage.FirstDisplayedAccount.xpath"))));
		WebElement accountName = driver.findElement(By.xpath(prop.getProperty("AccountHomePage.FirstDisplayedAccount.xpath")));
		executor.executeScript("arguments[0].click();", accountName);
		return new AccountDetailsPageHybrid(driver);
	}
	
	public AccountHomePageHybrid searchAccount(String searchText)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.searchTextBox.xpath"))).sendKeys(searchText, Keys.ENTER);
		return this;
	}
	
	public AccountHomePageHybrid clearSearchText()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountHomePage.clearSearchTextButton.xpath"))));
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.clearSearchTextButton.xpath"))).click();
		return this;
	}
	
	public AccountHomePageHybrid verifyNoItemsToDisplay(String expectedText)
	{
		String actualText = driver.findElement(By.xpath(prop.getProperty("AccountHomePage.NoItemsDisplayedMessage.xpath"))).getText();
		Assert.assertEquals(actualText, expectedText);
		return this;
	}
	
	
	
	

}
