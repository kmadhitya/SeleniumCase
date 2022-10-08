package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.salesforce.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC012_EditContract extends Base {

	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditContract";
	}
	@Test(dataProvider = "excelData")
	public void editContractTC12() throws InterruptedException {
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		Thread.sleep(3000);
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		executor.executeScript("arguments[0].click();", viewAll);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Contracts']")));
		//driver.findElement(By.xpath("//p[text()='Contracts']")).click();
		
		WebElement contracts = driver.findElement(By.xpath("//p[text()='Contracts']"));
		executor.executeScript("arguments[0].click();", contracts);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("161", Keys.ENTER);
		
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a"));
		executor.executeScript("arguments[0].click();", dropdown);
		
		WebElement edit = driver.findElement(By.xpath("(//div[@title='Edit'])[1]"));
		executor.executeScript("arguments[0].click();", edit);
		
		WebElement status = driver.findElement(By.xpath("//span[text()='Status']/ancestor::span/following::div[1]//a"));
		executor.executeScript("arguments[0].click();", status);
		
		WebElement statusActivated = driver.findElement(By.xpath("//a[text()='Activated']"));
		executor.executeScript("arguments[0].click();", statusActivated);
		
		WebElement ownerExpirationNotice = driver.findElement(By.xpath("//span[text()='Owner Expiration Notice']/ancestor::span/following::div[1]//a"));
		executor.executeScript("arguments[0].click();", ownerExpirationNotice);
		
		WebElement ownerExpirationNoticeValue = driver.findElement(By.xpath("//a[text()='30 Days']"));
		executor.executeScript("arguments[0].click();", ownerExpirationNoticeValue);
		
		Thread.sleep(5000);		
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")));
		driver.findElement(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("161", Keys.ENTER);
		
		WebElement contractNum = driver.findElement(By.xpath("//tbody/tr[1]/th//a"));
		executor.executeScript("arguments[0].click();", contractNum);
		String actualStatus = driver.findElement(By.xpath("(//span[@title='Status'])[2]/following::div[1]//span")).getText();
		Assert.assertEquals(actualStatus, "Activated");
		driver.quit();
		
	}

}
