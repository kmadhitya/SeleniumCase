package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOpportunity {
	
	public static void main(String[] args) throws InterruptedException
	{
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
		
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		Thread.sleep(3000);
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		executor.executeScript("arguments[0].click();", viewAll);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		executor.executeScript("arguments[0].click();", opportunity);
		
		driver.findElement(By.xpath("//div[text()='New']")).click();
		String ExpectedText = "Salesforce Automation by Adhitya";
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following-sibling::div[1]/input")).sendKeys(ExpectedText);
		driver.findElement(By.xpath("//label[text()='Close Date']/following-sibling::div[1]/input")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//button")).click();
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div[1]//span[text()='Needs Analysis']")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toast')]")));
		String toastText = driver.findElement(By.xpath("//span[contains(@class,'toast')]")).getText();
		System.out.println("Toast message is : " + toastText);
		
		String actualText = driver.findElement(By.xpath("//div[text()='Opportunity']/following-sibling::slot/lightning-formatted-text")).getText();
		Assert.assertEquals(toastText, "Opportunity \"Salesforce Automation by Adhitya\" was created.");
		Assert.assertEquals(actualText, ExpectedText);
		
		driver.close();
		
	}

}
