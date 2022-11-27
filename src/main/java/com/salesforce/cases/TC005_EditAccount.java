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

public class TC005_EditAccount extends SpecificMethods {

	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName = "EditAccount";
	}
	@Test(dataProvider = "excelData")
	public void editAccountTC05(String phone, String billingAddress, String shippingAddress, String typeValue) throws InterruptedException {
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		
		//WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		//executor.executeScript("arguments[0].click();", viewAll);
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		executor.executeScript("arguments[0].click();", account);
		
		Thread.sleep(3000);
		
		WebElement accountName = driver.findElement(By.xpath("(//a[text()='Adhitya'])[1]"));
		executor.executeScript("arguments[0].click();", accountName);
		
		driver.findElement(By.xpath("//button[text()='New Note']/ancestor::li/following-sibling::li//button")).click();
		driver.findElement(By.xpath("//button[text()='New Note']/ancestor::li/following-sibling::li//div//span[text()='Edit']")).click();
		
		driver.findElement(By.xpath("//label[text()='Phone']/following-sibling::div/input")).sendKeys(phone);
		
		driver.findElement(By.xpath("//label[text()='Type']/following-sibling::div[1]//button")).click();
		WebElement type = driver.findElement(By.xpath("//span[@title='Technology Partner']"));
		executor.executeScript("arguments[0].click();", type);
		
		WebElement click_industry = driver.findElement(By.xpath("//label[text()='Industry']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", click_industry);
		WebElement industry = driver.findElement(By.xpath("//span[@title='Healthcare']"));
		executor.executeScript("arguments[0].click();", industry);
		
		//"arguments[0].value='"+ value +"';"
		//String billingAddress = "101 Billing Address";
		WebElement billingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following-sibling::div/textarea"));
		executor.executeScript("arguments[0].value='"+ billingAddress +"';", billingStreet);
		//String shippingAddress = "201 Shipping Address";
		WebElement shippingStreet = driver.findElement(By.xpath("//label[text()='Shipping Street']/following-sibling::div/textarea"));
		executor.executeScript("arguments[0].value='"+ shippingAddress +"';", shippingStreet);
		
		Thread.sleep(3000);
		WebElement customerPriority = driver.findElement(By.xpath("//label[text()='Customer Priority']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", customerPriority);
		WebElement customerPriorityValue = driver.findElement(By.xpath("//span[@title='Low']"));
		executor.executeScript("arguments[0].click();", customerPriorityValue);
		
		Thread.sleep(3000);
		WebElement sla = driver.findElement(By.xpath("//label[text()='SLA']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", sla);
		WebElement slaValue = driver.findElement(By.xpath("//span[@title='Silver']"));
		executor.executeScript("arguments[0].click();", slaValue);
		
		Thread.sleep(3000);
		WebElement active = driver.findElement(By.xpath("//label[text()='Active']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", active);
		WebElement activeValue = driver.findElement(By.xpath("(//span[text()='No'])[2]"));
		executor.executeScript("arguments[0].click();", activeValue);
		
		Thread.sleep(3000);
		WebElement upsellOpty = driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following-sibling::div[1]//button"));
		executor.executeScript("arguments[0].click();", upsellOpty);
		WebElement upsellOptyValue = driver.findElement(By.xpath("(//span[text()='No'])[1]"));
		executor.executeScript("arguments[0].click();", upsellOptyValue);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//label[text()='Upsell Opportunity']/following-sibling::div[1]//button
		
		driver.findElement(By.xpath("(//a[text()='Details'])[1]")).click();
		
		String actualText = driver.findElement(By.xpath("//span[text()='Type']/following::span[1]//lightning-formatted-text")).getText();
		
		Assert.assertEquals(actualText, typeValue);
	}

}
