package com.sf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sf.base.ProjectSpecMethods;

public class ServiceConsoleHomePage extends ProjectSpecMethods{
	
	public ServiceConsoleHomePage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	public ServiceConsoleHomePage clickServiceControlDropdown()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Show Navigation Menu']/lightning-primitive-icon")));
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']/lightning-primitive-icon")).click();
		return this;
	}
	
	public FilesHomePage clickFiles()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='Files']")));
		driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Files']")).click();
		return new FilesHomePage(driver);
	}

}
