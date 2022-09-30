package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_CreateAccount extends Base {

	@Test
	public void createAccountTC04() {
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		executor.executeScript("arguments[0].click();", viewAll);
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		executor.executeScript("arguments[0].click();", account);
		
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		String ExpectedText = "Adhitya";
		driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div[1]/input")).sendKeys(ExpectedText);
		
		driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div[1]//button")).click();
		driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div[1]//span[text()='Public']")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		String actualText = driver.findElement(By.xpath("//div[text()='Account']/following-sibling::slot//lightning-formatted-text")).getText();
		
		Assert.assertEquals(actualText, ExpectedText);
		driver.quit();
	}

}
