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
import com.salesforce.base.Base;

public class TC015_EditTask extends Base {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditTask";
	}
	@Test(dataProvider = "excelData")
	public void editOptyTC02() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='navigation']/button/div")));
	WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", appLauncher);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']")));
	WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
	executor.executeScript("arguments[0].click();", viewAll);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Sales']")));
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Tasks']")));
	WebElement task = driver.findElement(By.xpath("//span[text()='Tasks']"));
	executor.executeScript("arguments[0].click();", task);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Show 9 more actions']")));
	WebElement dropdown = driver.findElement(By.xpath("//a[@title='Show 9 more actions']"));
	executor.executeScript("arguments[0].click();", dropdown);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Edit']")));
	WebElement edit = driver.findElement(By.xpath("//div[@title='Edit']"));
	executor.executeScript("arguments[0].click();", edit);
	
	WebElement dueDate = driver.findElement(By.xpath("//span[text()='Due Date']/following::div[1]/div/input"));
	executor.executeScript("arguments[0].click();", dueDate);
	WebElement today = driver.findElement(By.xpath("//button[text()='Today']"));
	executor.executeScript("arguments[0].click();", today);
	WebElement priority = driver.findElement(By.xpath("//span[text()='Priority']/following::div[1]//div/a"));
	executor.executeScript("arguments[0].click();", priority);
	WebElement priorityLow = driver.findElement(By.xpath("//a[text()='Low']"));
	executor.executeScript("arguments[0].click();", priorityLow);
	WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
	executor.executeScript("arguments[0].click();", save);
	String actualText = driver.findElement(By.xpath("//span[text()='Subject']/following::span[1]/span")).getText();
	Assert.assertEquals(actualText, "Bootcamp");
	
	
	
	}

}
