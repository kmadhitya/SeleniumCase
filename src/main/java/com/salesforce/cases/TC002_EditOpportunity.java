package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_EditOpportunity {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://login.salesforce.com/";
		String username = "hari.radhakrishnan@qeagle.com";
		String pwd = "India$321";
		//System.setProperty("webdriver.chrome.drive", "./drivers/chromedriver");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		executor.executeScript("arguments[0].click();", viewAll);
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		executor.executeScript("arguments[0].click();", opportunity);
		
		Thread.sleep(5000);
		
		WebElement opportunityName = driver.findElement(By.xpath("(//a[text()='Salesforce Automation by Adhitya'])[1]"));
		executor.executeScript("arguments[0].click();", opportunityName);
		
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//button")).click();
		
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//div//span[text()='Edit']")).click();
		WebElement date = driver.findElement(By.xpath("//label[text()='Close Date']/following-sibling::div[1]/input"));
		date.clear();
		date.sendKeys("9/12/2022");
		
		String expectedText = "Perception Analysis";
		
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//span[text()='Needs Analysis']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		
		Thread.sleep(5000);
		
		WebElement deliveryStatus = driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following-sibling::div[1]//span[contains(text(),'None')]"));
		executor.executeScript("arguments[0].click();", deliveryStatus);
		Thread.sleep(5000);
		
		WebElement deliveryStatusInProgress = driver.findElement(By.xpath("//span[@title='In progress']"));
		executor.executeScript("arguments[0].click();", deliveryStatusInProgress);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		driver.findElement(By.xpath("(//a[text()='Details'])[1]")).click();
		
		String actualText = driver.findElement(By.xpath("(//span[text()='Close Date'])[2]/following::span[1]//lightning-formatted-text")).getText();
		
		String actualText2 = driver.findElement(By.xpath("(//span[text()='Stage'])[2]/following::span[1]//lightning-formatted-text")).getText();
		
		
		Assert.assertEquals(actualText, "9/12/2022");
		
		Assert.assertEquals(actualText2, expectedText);
		
		driver.close();

	}

}
