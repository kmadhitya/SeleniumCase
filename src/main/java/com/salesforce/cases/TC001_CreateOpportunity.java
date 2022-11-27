package com.salesforce.cases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.salesforce.base.SpecificMethods;
import com.salesforce.utils.ExcelUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOpportunity extends SpecificMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateOpty";
	}
	@Test(dataProvider = "excelData")
	public void createOptyTC01(String name, String toastExpectedText) throws InterruptedException
	{		
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		//Thread.sleep(3000);
		//WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		//executor.executeScript("arguments[0].click();", viewAll);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		executor.executeScript("arguments[0].click();", opportunity);
		
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following-sibling::div[1]/input")).sendKeys(name);
		driver.findElement(By.xpath("//label[text()='Close Date']/following-sibling::div[1]/input")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//button")).click();
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//span[text()='Needs Analysis']")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toast')]")));
		String toastText = driver.findElement(By.xpath("//span[contains(@class,'toast')]")).getText();
		System.out.println("Toast message is : " + toastText);
		
		String actualText = driver.findElement(By.xpath("//div[text()='Opportunity']/following-sibling::slot/lightning-formatted-text")).getText();
		Assert.assertEquals(toastText, toastExpectedText);
		Assert.assertEquals(actualText, name);
		
		
		
	}

}
