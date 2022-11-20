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
import com.salesforce.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC009_DeleteLead extends Base {

	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteLead";
	}
	@Test(dataProvider = "excelData")
	public void deleteLeadTC09() throws InterruptedException {
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		
		//WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		//executor.executeScript("arguments[0].click();", viewAll);
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement leads = driver.findElement(By.xpath("//span[text()='Leads']"));
		executor.executeScript("arguments[0].click();", leads);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Kumar", Keys.ENTER);
		
		Thread.sleep(3000);
		
		WebElement leadName = driver.findElement(By.xpath("(//a[contains(text(),'Kumar')])[1]"));
		executor.executeScript("arguments[0].click();", leadName);
		
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//div//span[text()='Delete']")).click();
		
		driver.findElement(By.xpath("//div[text()='Are you sure you want to delete this lead?']/ancestor::div/following-sibling::div//button//span[text()='Delete']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")).click();
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Kumar", Keys.ENTER);
		
		String actualText = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		
		Assert.assertEquals(actualText, "No items to display.");
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
