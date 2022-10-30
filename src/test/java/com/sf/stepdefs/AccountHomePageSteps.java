package com.sf.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AccountHomePageSteps extends BasicSteps {
	
	@Given ("I open first Account")
	public void openFirstAccount()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AccountHomePage.FirstDisplayedAccount.xpath"))));
		WebElement accountName = driver.findElement(By.xpath(prop.getProperty("AccountHomePage.FirstDisplayedAccount.xpath")));
		executor.executeScript("arguments[0].click();", accountName);
	}
	
	@When ("I search the Account {string}")
	public void searchAccount(String searchText)
	{
		driver.findElement(By.xpath(prop.getProperty("AccountHomePage.searchTextBox.xpath"))).sendKeys(searchText, Keys.ENTER);
	}

}
