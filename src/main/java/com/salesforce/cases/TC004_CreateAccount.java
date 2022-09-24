package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		driver.close();
	}

}
