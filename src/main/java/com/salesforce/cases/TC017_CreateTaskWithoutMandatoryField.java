package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC017_CreateTaskWithoutMandatoryField extends Base {
	@Test
	public void createTaskWithoutMandatoryFieldTC10() throws InterruptedException {
		
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
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Show one more action']")));
	WebElement dropdown = driver.findElement(By.xpath("//a[@title='Show one more action']"));
	executor.executeScript("arguments[0].click();", dropdown);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='New Task']")));
	WebElement newTask = driver.findElement(By.xpath("//a[@title='New Task']"));
	executor.executeScript("arguments[0].click();", newTask);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save']")));
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	
	String actualText = driver.findElement(By.xpath("//label[text()='Subject']/following::div[text()='Complete this field.']")).getText();
	
	Assert.assertEquals(actualText, "Complete this field.");
	}

}
