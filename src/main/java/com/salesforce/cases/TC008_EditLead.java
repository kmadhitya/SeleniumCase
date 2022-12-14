package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.salesforce.base.SpecificMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008_EditLead extends SpecificMethods {

	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditLead";
	}
	@Test(dataProvider = "excelData")
	public void editLeadTC08(String LastName, String Expected) throws InterruptedException {
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		executor.executeScript("arguments[0].click();", viewAll);
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement leads = driver.findElement(By.xpath("//span[text()='Leads']"));
		executor.executeScript("arguments[0].click();", leads);
		
		Thread.sleep(3000);
		
		WebElement leadName = driver.findElement(By.xpath("(//a[text()='Kumar'])[1]"));
		executor.executeScript("arguments[0].click();", leadName);
		
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("//button[text()='Submit for Approval']/ancestor::li/following-sibling::li//div//span[text()='Edit']")).click();
		driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::div[1]/input")).sendKeys("Ganesh");
		
		WebElement leadStatus = driver.findElement(By.xpath("//label[text()='Lead Status']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", leadStatus);
		WebElement leadStatusValue = driver.findElement(By.xpath("//span[@title='Working - Contacted']"));
		executor.executeScript("arguments[0].click();", leadStatusValue);
		
		Thread.sleep(5000);		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		driver.findElement(By.xpath("(//a[text()='Details'])[1]")).click();
		
		String actualText = driver.findElement(By.xpath("//span[text()='Lead Status']/following::span[1]//lightning-formatted-text")).getText();
		
		Assert.assertEquals(actualText, "Working - Contacted");
		
		driver.quit();
		
	}

}
