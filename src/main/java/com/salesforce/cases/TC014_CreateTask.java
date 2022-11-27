package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.salesforce.base.SpecificMethods;

public class TC014_CreateTask extends SpecificMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateTask";
	}
	@Test(dataProvider = "excelData")
	public void createtaskTC14() throws InterruptedException
	{		
		WebElement globalActions = driver.findElement(By.xpath("(//span[text()='Global Actions'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", globalActions);
		driver.findElement(By.xpath("//span[text()='New Task']")).click();
		driver.findElement(By.xpath("//label[text()='Subject']/following::input")).sendKeys("Bootcamp");
		driver.findElement(By.xpath("//span[text()='Name']/following::input[@title='Search Contacts']")).sendKeys("Test Adhitya");
		driver.findElement(By.xpath("//div[@title='Test Adhitya']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Status']/following::div[1]//a")));
		WebElement status = driver.findElement(By.xpath("//span[text()='Status']/following::div[1]//a"));
		executor.executeScript("arguments[0].click();", status);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Waiting on someone else']")));
		WebElement statusOption = driver.findElement(By.xpath("//a[text()='Waiting on someone else']"));
		executor.executeScript("arguments[0].click();", statusOption);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
		String toastText = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println("Toast Message: " + toastText);
		Assert.assertEquals(toastText, "Task Bootcamp was created.");
	}

}
