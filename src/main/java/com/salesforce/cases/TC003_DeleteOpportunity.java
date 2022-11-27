package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.salesforce.base.SpecificMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_DeleteOpportunity extends SpecificMethods {

	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteOpty";
	}
	@Test(dataProvider = "excelData")
	public void deleteOptyTC03(String expectedText, String searchText) throws InterruptedException {
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		
		//WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		//executor.executeScript("arguments[0].click();", viewAll);
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		executor.executeScript("arguments[0].click();", opportunity);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(searchText, Keys.ENTER);
		
		Thread.sleep(3000);
		
		WebElement opportunityName = driver.findElement(By.xpath("(//a[text()='Salesforce Automation by Adhitya123'])[1]"));
		executor.executeScript("arguments[0].click();", opportunityName);
		
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//button")).click();
		
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//div//span[text()='Delete']")).click();
		
		driver.findElement(By.xpath("//div[text()='Are you sure you want to delete this opportunity?']/ancestor::div/following-sibling::div//button//span[text()='Delete']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")).click();
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(searchText, Keys.ENTER);
		
		String actualText = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		
		Assert.assertEquals(actualText, expectedText);
	}

}
