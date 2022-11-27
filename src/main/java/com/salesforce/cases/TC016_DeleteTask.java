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
import com.salesforce.base.SpecificMethods;

public class TC016_DeleteTask extends SpecificMethods {
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "DeleteTask";
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
	WebElement delete = driver.findElement(By.xpath("//div[@title='Delete']"));
	executor.executeScript("arguments[0].click();", delete);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Delete']")));
	WebElement deleteConfirmation = driver.findElement(By.xpath("//span[text()='Delete']"));
	executor.executeScript("arguments[0].click();", deleteConfirmation);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
	String toastText = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
	System.out.println("Toast Message: " + toastText);
	String str = "Task \"Bootcamp\" was deleted. Undo";
	Assert.assertEquals(toastText, str);
	
	}

}
