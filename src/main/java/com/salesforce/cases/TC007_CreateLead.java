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
import com.salesforce.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_CreateLead extends Base {

	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateLead";
	}
	@Test(dataProvider = "excelData")
	public void createLeadTC07(String lastName, String company, String expected) throws InterruptedException {
		
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		executor.executeScript("arguments[0].click();", viewAll);
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement leads = driver.findElement(By.xpath("//span[text()='Leads']"));
		executor.executeScript("arguments[0].click();", leads);
		
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//label[text()='Salutation']/following-sibling::div[1]//button")).click();
		driver.findElement(By.xpath("//label[text()='Salutation']/following-sibling::div[1]//span[text()='Mr.']")).click();
		
		driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::div[1]/input")).sendKeys("Kumar");
		driver.findElement(By.xpath("//label[text()='Company']/following-sibling::div[1]/input")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String actualText = driver.findElement(By.xpath("//div[text()='Lead']/following-sibling::slot//lightning-formatted-name")).getText();
		
		Assert.assertEquals(actualText, "Mr. Kumar");

		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
