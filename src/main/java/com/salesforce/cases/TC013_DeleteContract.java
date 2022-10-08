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

public class TC013_DeleteContract extends Base {

	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteContract";
	}
	@Test(dataProvider = "excelData")
	public void deleteContractTC12() throws InterruptedException {
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
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("162", Keys.ENTER);
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(By.xpath("//tbody/tr[1]/td[8]//a"));
		executor.executeScript("arguments[0].click();", dropdown);
		
		WebElement delete = driver.findElement(By.xpath("(//div[@title='Delete'])[1]"));
		executor.executeScript("arguments[0].click();", delete);
		driver.findElement(By.xpath("//div[text()='Are you sure you want to delete this contract?']/ancestor::div/following-sibling::div//button//span[text()='Delete']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")));
		driver.findElement(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("161", Keys.ENTER);
		String actualText = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		
		Assert.assertEquals(actualText, "No items to display.");
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
