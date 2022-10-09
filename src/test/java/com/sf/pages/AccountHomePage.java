package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.base.ProjectSpecMethods;

public class AccountHomePage extends ProjectSpecMethods{
	
	public AccountCreatePage clickNewButton()
	{
		driver.findElement(By.xpath("//div[text()='New']")).click();
		return new AccountCreatePage();
	}
	
	public AccountDetailsPage openAccount()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Adhitya123'])[1]")));
		WebElement accountName = driver.findElement(By.xpath("(//a[text()='Adhitya123'])[1]"));
		executor.executeScript("arguments[0].click();", accountName);
		return new AccountDetailsPage();
	}
	
	public AccountHomePage searchAccount(String searchText)
	{
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(searchText, Keys.ENTER);
		return this;
	}

}
