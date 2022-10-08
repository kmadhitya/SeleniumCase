package com.salesforce.cases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.salesforce.base.Base;

public class TC011_CreateContract extends Base {

	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "CreateContract";
	}
	@Test(dataProvider = "excelData")
	public void createContractTC11() throws InterruptedException {
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
		
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		driver.findElement(By.xpath("(//input[@role='combobox'])[1]")).sendKeys("Adhitya");
		driver.findElement(By.xpath("//mark[text()='Adhitya']")).click();

		/*Date date = new Date();
		LocalDateTime plusDays = LocalDateTime.from(date.toInstant()).plusDays(1);
		String tomorrow = plusDays.toString();
		System.out.println("Tomorrow's date: " +tomorrow);*/
		driver.findElement(By.xpath("//span[text()='Contract Start Date']/following::div[1]/input")).sendKeys("9/19/2022");
		driver.findElement(By.xpath("//span[contains(text(),'Contract Term')]/ancestor::label/following::input[1]")).sendKeys("6");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		String contractNumber = driver.findElement(By.xpath("(//div[text()='Contract'])[1]/following::div[1]/span")).getText();
		System.out.println("Contract Number is: " +contractNumber);
		String startDate = driver.findElement(By.xpath("(//span[@title='Contract Start Date'])[2]/following::div[1]//span")).getText();
		String[] start = startDate.split("/");
		String endDate = driver.findElement(By.xpath("(//span[@title='Contract End Date'])[2]/following::div[1]//span")).getText();
		String[] end = endDate.split("/");
		int endResult = Integer.parseInt(start[0]) - Integer.parseInt(end[0]);
		System.out.println("Difference between the start and end date: " +endResult);
		String contractTerm = driver.findElement(By.xpath("(//span[contains(@title,'Contract Term')])[2]/following::div[1]//span")).getText();
		int term = Integer.parseInt(contractTerm);
		System.out.println("Contract term is: " +term);
		Assert.assertEquals(term, endResult);
		driver.quit();
	}

}
